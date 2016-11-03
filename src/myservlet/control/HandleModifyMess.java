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

public class HandleModifyMess extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HandleModifyMess() {
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

		HttpSession session=request.getSession(true);
		Login login=(Login)session.getAttribute("login");
		boolean ok=true;
		if(login==null){
			ok=false;
			response.sendRedirect("login.jsp");
		}
		if(ok==true){
			continueDoPost(request,response);
		}
	}
	public void continueDoPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		HttpSession session=request.getSession(true);
		Login login=(Login)session.getAttribute("login");
		String logname=login.getName();
		Connection con;
		Statement sql;
		ModifyMessage modify=new ModifyMessage();
		request.setAttribute("modify", modify);
		String email=request.getParameter("Newemail").trim(),phone=request.getParameter("Newphone").trim();
		String uri="jdbc:mysql://localhost/trival?characterEncoding=utf-8";
  		String user="root";
  		String databasepassword="123";
  		String backnews="";
  		try{
  			con=DriverManager.getConnection(uri,user,databasepassword);
  			String updateCondition="UPDATE account SET phone='"+phone+"',mail='"+email+"' WHERE nicheng='"+logname+"'";
  			sql=con.createStatement();
  			int m=sql.executeUpdate(updateCondition);
  			if(m==1){
  				backnews="修改信息成功";
  				modify.setBacknews(backnews);
  				modify.setLogname(logname);
  				modify.setNewemail(email);
  				modify.setNewphone(phone);
  			}
  			else{
  				backnews="信息填写不完整或信息中有非法字符";
  				modify.setBacknews(backnews);
  			}
  			con.close();
  		}
  		catch(SQLException exp){
  			modify.setBacknews(""+exp);
  		}
  		RequestDispatcher dispatcher=request.getRequestDispatcher("/account/showModifyMess.jsp");
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
