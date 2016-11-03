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

public class HandleRoutineComment1 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HandleRoutineComment1() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		ShowRoutine showroutine=(ShowRoutine)session.getAttribute("showroutine");
		String comment=request.getParameter("comment").trim();
		String score=request.getParameter("score").trim();
		Login login=(Login)session.getAttribute("login");
		String user1=login.getName();
		String tablenumber=showroutine.getTablenumber();
		String number=showroutine.getNumber();
		String city=showroutine.getCity();
		String backnews="";
		Connection con;
		Statement sql;
		String uri1="jdbc:mysql://localhost/trival?characterEncoding=utf-8";
  		String user="root";
  		String databasepassword="123";
  		String condition="";
  		ResultSet rs;
  		StringBuffer result=new StringBuffer();
  		Boolean ok=false;
  		try{
  			con=DriverManager.getConnection(uri1,user,databasepassword);
  			if(comment==""){
  				backnews="输入不能为空";
  				ok=false;
  			}
  			else if(score==""){
  				backnews="分数不能为空";
  				ok=false;
  			}
  			else{
  				String insertrecord="('"+tablenumber+"','"+city+"','"+number+"','"+score+"','"+user1+"','"+comment+"')";
	  			condition="INSERT INTO routinecomment1 VALUES"+insertrecord;
	  			sql=con.createStatement();
	  			sql.executeUpdate(condition);
	  			backnews="评论成功";
	  			ok=true;
  			}
  			condition="SELECT * FROM routinecomment1 WHERE tablenumber='"+tablenumber+"' and number ='"+number+"' and city ='"+city+"'";
  			sql=con.createStatement();
  			rs=sql.executeQuery(condition);
  			int m=0;
  			double sum=0;
  			while(rs.next()){
  				result.append(rs.getString(5)+"#"+"评分："+rs.getString(4)+"#");
  				result.append(rs.getString(6)+"#");
  				m++;
  				sum+=rs.getInt(4);
  			}
  			if(m!=0)sum=sum/m;
  			else sum=0;
  			if(tablenumber.equals("2")){
  				condition="update day23 set score ='"+sum+"',person='"+m+"' where shi ='"+city+"' and xuhao ='"+number+"'";
  				sql=con.createStatement();
  				sql.executeUpdate(condition);
  			}
  			else if(tablenumber.equals("1")){
  				condition="update day1 set score ='"+sum+"',person='"+m+"' where shi ='"+city+"' and xuhao ='"+number+"'";
  				sql=con.createStatement();
  				sql.executeUpdate(condition);
  			}
  			else if(tablenumber.equals("4")){
  				condition="update day4 set score ='"+sum+"',person='"+m+"' where shi ='"+city+"' and xuhao ='"+number+"'";
  				sql=con.createStatement();
  				sql.executeUpdate(condition);
  			}
  			showroutine.setPerson(m);
  			showroutine.setAverage(sum);
  			showroutine.setResult(result);
  			showroutine.setN(m);
  			showroutine.setOk(ok);
  			showroutine.setBacknews(backnews);
  			//routinecomment.setScore(save);
  			
  		}
  		catch(SQLException exp){
  			backnews="aaa"+exp;
  		}
  		response.sendRedirect("/trival/searchroutine/showroutine2.jsp"); 
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init(ServletConfig config) throws ServletException {
		// Put your code here
		super.init(config);
		try{ Class.forName("com.mysql.jdbc.Driver");
		  }
		  	catch(Exception e){System.out.println(e);
		  }
	}

}
