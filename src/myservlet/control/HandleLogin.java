package myservlet.control;

import java.io.IOException;
import java.io.PrintWriter;
import myservlet.control.mybean.data.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandleLogin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HandleLogin() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Connection con;
		Statement sql;
		Login loginbean=null;
		String backnews="";
		
		HttpSession session=request.getSession(true);
		try{
			loginbean=(Login)session.getAttribute("login");
			if(loginbean.equals(null)){
				loginbean=new Login();
				session.setAttribute("login",loginbean);
			}
		}
		catch(Exception ee){
			loginbean=new Login();
			session.setAttribute("login",loginbean);
		}
		String logname=request.getParameter("logname").trim(),password=request.getParameter("password");
		String flag = request.getParameter("isLogin");
		
		boolean ok=loginbean.getSuccess();
		if(ok==true&&logname.equals(loginbean.getName())){
			backnews=logname+"已经登录了";
			loginbean.setBacknews(backnews);
		}
		else {
			String uri="jdbc:mysql://localhost/trival?characterEncoding=utf-8";
	  		String user="root";
	  		String databasepassword="123";
	  		boolean boo=(logname.length()>0)&&(password.length()>0);
	  		try{
	  			con=DriverManager.getConnection(uri,user,databasepassword);
	  			String condition="select * from account where nicheng = '"+logname+"' and password= '"+password+"'";
	  			sql=con.createStatement();
	  			if(boo){
	  				ResultSet rs=sql.executeQuery(condition);
	  				boolean m=rs.next();
	  				if(m==true){
	  					backnews="登陆成功";
	  					loginbean.setBacknews(backnews);
	  					loginbean.setSuccess(true);
	  					loginbean.setName(logname);
	  					String phone=rs.getString(2);
	  					String mail=rs.getString(3);
	  					loginbean.setPhone(phone);
	  					loginbean.setMail(mail);
	  				}
	  				else {
	  					backnews="您输入的用户名不存在，或者密码不匹配";
	  					loginbean.setBacknews(backnews);
	  					loginbean.setSuccess(false);
	  					loginbean.setName(logname);
	  					loginbean.setPassword(password);
	  				}
	  			}
	  			else {
	  				backnews="您输入的用户名不存在，或者密码不匹配";
  					loginbean.setBacknews(backnews);
  					loginbean.setSuccess(false);
  					loginbean.setName(logname);
  					loginbean.setPassword(password);
	  			}
	  			con.close();
	  		}
	  		catch(SQLException exp){
	  			backnews=""+exp;
	  			loginbean.setBacknews(backnews);
	  			loginbean.setSuccess(false);
	  		}
		}
		String uri=request.getParameter("uri");
		RequestDispatcher dispatcher=request.getRequestDispatcher(uri);
		dispatcher.forward(request,response);
		//System.out.println(backnews);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try{ Class.forName("com.mysql.jdbc.Driver");
		  }
		  	catch(Exception e){System.out.println(e);
		  }
		// Put your code here
	}

}
