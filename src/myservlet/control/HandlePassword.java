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


public class HandlePassword extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HandlePassword() {
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
		HttpSession session=request.getSession(true);		
		Login login=(Login)session.getAttribute("login");
		boolean ok=true;
		if((login==null)){
			ok=false;
			response.sendRedirect("/trival/account/login.jsp");
		
		}
		if(ok==true)continueWork(request,response);
	}
	public void continueWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		Login login=(Login)session.getAttribute("login");
		Connection con;
		String logname=login.getName();
		Password passwordbean=new Password();
		request.setAttribute("password", passwordbean);
		String oldpassword=request.getParameter("oldpassword");
		String newpassword=request.getParameter("newpassword");
		String uri="jdbc:mysql://localhost/trival?characterEncoding=utf-8";
  		String user="root";
  		String databasepassword="123";
  		if(newpassword.equals(""))passwordbean.setBacknews("密码更新失败");
  		else {try{
  			con=DriverManager.getConnection(uri,user,databasepassword);
  			Statement sql=con.createStatement();
  			ResultSet rs=sql.executeQuery("SELECT * FROM account where nicheng='"+logname+"'And password='"+oldpassword+"'");
  			if(rs.next()){
  				String updateString="UPDATE account SET password='"+newpassword+"'where nicheng='"+logname+"'";
  				int m=sql.executeUpdate(updateString);
  				if(m==1){
  					passwordbean.setBacknews("密码更新成功");
  					passwordbean.setOldpassword(oldpassword);
  					passwordbean.setNewpassword(newpassword);
  				}
  				else passwordbean.setBacknews("密码更新失败");
  			}
  			else passwordbean.setBacknews("密码更新失败");
  		}
  		catch(SQLException exp){
  			passwordbean.setBacknews("密码更新失败"+exp);
  		}
  		}
  		RequestDispatcher dispatcher=request.getRequestDispatcher("/account/showNewPassword.jsp");
  		dispatcher.forward(request, response);
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
