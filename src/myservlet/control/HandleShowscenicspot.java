package myservlet.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import myservlet.control.mybean.data.*;

import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HandleShowscenicspot extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HandleShowscenicspot() {
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
		HttpSession session=request.getSession(true);
		request.setCharacterEncoding("utf-8");
		Connection con;
		Statement sql;
		String scenicspotname=new String(),introduction=new String(),province=new String();
		Comment comment;
		String backnew="";
		String name=request.getParameter("name").trim();
		String uri="jdbc:mysql://localhost/trival?characterEncoding=utf-8";
  		String user="root";
  		String databasepassword="123";
  		String backnews="";
  		boolean ok=false;
  		try{
			comment=(Comment)session.getAttribute("comment");
			if(comment==null){
				comment=new Comment();
				session.setAttribute("comment", comment);
			}
			else{
				session.removeAttribute("comment");
				comment=new Comment();
				session.setAttribute("comment", comment);
			}
		}
		catch(Exception exp){
			comment=new Comment();
			session.setAttribute("comment", comment);
		}
  		StringBuffer result=new StringBuffer();
  		try{
  			con=DriverManager.getConnection(uri,user,databasepassword);
  			String condition="SELECT * FROM scenicspot WHERE scenicspot='"+name+"'";
  			sql=con.createStatement();
  			double score;
  			ResultSet rs=sql.executeQuery(condition);
  			while(rs.next()){
  			scenicspotname=rs.getString(3);
	 		introduction=rs.getString(4);
	 		score=rs.getDouble(5);
	 		province=rs.getString(1);
  			}
  			condition="SELECT * FROM comment WHERE name='"+name+"'";  			
  			sql=con.createStatement();
  			rs=sql.executeQuery(condition);
  			int number=0;
  			score=0;
  			while(rs.next()){
  				result.append(rs.getString(4)+"#");
  				result.append(rs.getString(2)+"#");
  				result.append("ÆÀ·Ö£º"+rs.getDouble(3)+"#");
  				score+=rs.getDouble(3);
  				number++;
  				ok=true;
  			}
  			if(number!=0){
	  			double save=score/number;
		  		condition="update scenicspot set score='"+save+"',num='"+number+"' where scenicspot='"+name+"'";
	  			sql=con.createStatement();
	  			sql.executeUpdate(condition);
	  			comment.setScore(save);
	  			}
	  			else{comment.setScore(0);}
  			comment.setNumber(number);
  			comment.setResult(result);
		}
		catch(SQLException exp){
			backnews=""+exp;
			comment.setBacknews(backnews);
		}
  		comment.setName(scenicspotname);
 		comment.setIntroduction(introduction);
 		comment.setProvince(province);
 		comment.setBacknews(backnews);
 		comment.setOk(ok);
 		response.sendRedirect("/trival/searchscenicspot/Showscenicspot.jsp"); 
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

		doGet(request,response);
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
