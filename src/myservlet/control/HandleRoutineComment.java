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

public class HandleRoutineComment extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HandleRoutineComment() {
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
		routinecomment routinecomment=(routinecomment)session.getAttribute("routinecomment");
		Login login=(Login)session.getAttribute("login");
		String username=login.getName();
		String uri=routinecomment.getUri().trim();
		String com=request.getParameter("comment").trim();
		String one=request.getParameter("score").trim();
		String backnews=new String();
		int number=0;
		double score=0;
		String condition="";
		ResultSet rs;
		StringBuffer result=new StringBuffer();
		boolean ok=false;
		/*try{
			routinecomment=(routinecomment)session.getAttribute("routinecomment");
			if(routinecomment==null){
				routinecomment=new routinecomment();
				session.setAttribute("routinecomment", routinecomment);
			}
			else {
				session.removeAttribute("routinecomment");
				routinecomment=new routinecomment();
				session.setAttribute("routinecomment", routinecomment);
			}
		}
		catch(Exception exp){
			routinecomment=new routinecomment();
			session.setAttribute("routinecomment", routinecomment);
		}*/
		Connection con;
		Statement sql;
		String uri1="jdbc:mysql://localhost/trival?characterEncoding=utf-8";
  		String user="root";
  		String databasepassword="123";
  		try{
  			con=DriverManager.getConnection(uri1,user,databasepassword);
  			if(com==""){
  				backnews="输入不能为空";
  				
  			}
  			else if(one==""){
  				backnews="分数不能为空";
  			}
  			else{
  				double onescore=Double.parseDouble(one.trim());
  				String insertrecord="('"+uri+"','"+com+"','"+onescore+"','"+username+"')";
	  			condition="INSERT INTO routinecomment VALUES"+insertrecord;
	  			sql=con.createStatement();
	  			sql.executeUpdate(condition);
	  			backnews="评论成功";
  			}
  			condition="SELECT * FROM routinecomment WHERE uri='"+uri+"'";
  			sql=con.createStatement();
  			rs=sql.executeQuery(condition);
  			while(rs.next()){
  				result.append(rs.getString(4)+"#"+"评分："+rs.getString(3)+"#");
  				result.append(rs.getString(2)+"#");
  				score+=rs.getDouble(3);
  				number++;
  				ok=true;
  			}
  			if(number!=0){
  			double save=score/number;
  			routinecomment.setScore(save);
  			}
  			else{routinecomment.setScore(0);}
  		}
  		catch(SQLException exp){
  			backnews=""+exp;
  		}
  		routinecomment.setNumber(number);
  		routinecomment.setBacknews(backnews);
  		routinecomment.setOk(ok);
  		routinecomment.setResult(result);
  		response.sendRedirect("/trival/showroutine/showroutine.jsp"); 
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
