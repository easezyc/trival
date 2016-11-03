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

public class HandleRegister extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HandleRegister() {
	}
	public String handleregister(String s){
		return s;
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
		Register reg=new Register();
		request.setAttribute("register",reg);
		String name=request.getParameter("name").trim(),password=request.getParameter("password").trim(),phone=request.getParameter("phone"),email=request.getParameter("email"),checkpassword=request.getParameter("checkpassword");
		String insertrecord="('"+name+"','"+phone+"','"+email+"','"+password+"')";
		String backnews="";
			String uri="jdbc:mysql://localhost/trival?characterEncoding=utf-8";
	  		String user="root";
	  		String databasepassword="123";	  		
	  		boolean boo=(name.length()>0&&password.length()>0);	  		
	  		try{
	  			con=DriverManager.getConnection(uri,user,databasepassword);
	  			String insertCondition="INSERT INTO account VALUES"+insertrecord;
	  			sql=con.createStatement();
	  			if(boo){if(password.equals(checkpassword))
	  			{int m=sql.executeUpdate(insertCondition);
	  			reg.setName(name);
	  			reg.setMail(email);
	  			reg.setPassword(password);
	  			reg.setPhone(phone);
	  			backnews="注册成功";
	  			reg.setBacknews(backnews);
	  			}
	  			else {backnews="两次密码不同";
	  			reg.setBacknews(backnews);
	  			}
	  			}
	  			else{
	  				backnews="账号密码不能为空";
	  				reg.setBacknews(backnews);
	  			}
	  			con.close();
	  		}
	  		catch(SQLException exp){
	  			backnews="该昵称已被注册，请您更换名字";
	  			reg.setBacknews(backnews);
	  		}
  		RequestDispatcher dispatcher=request.getRequestDispatcher("/account/showRegisterMess.jsp");
  		dispatcher.forward(request,response);
		
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
