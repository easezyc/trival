package myservlet.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import com.sun.rowset.*;

import myservlet.control.mybean.data.*;

import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandleShowroutine2 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HandleShowroutine2() {
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
		ShowRoutine showroutine=null;
		try{
			showroutine=(ShowRoutine)session.getAttribute("showroutine");
			if(showroutine==null){
				showroutine=new ShowRoutine();
				session.setAttribute("showroutine", showroutine);
			}
			else{
				session.removeAttribute("showroutine");
				showroutine=new ShowRoutine();
				session.setAttribute("showroutine", showroutine);
			}
		}
		catch(Exception exp){
			showroutine=new ShowRoutine();
			session.setAttribute("showroutine", showroutine);
		}
		request.setCharacterEncoding("utf-8");
		Connection con = null;
		Statement sql;
		String number=request.getParameter("number").trim();
		String name1=request.getParameter("name").trim();
		String tablenumber=request.getParameter("tablenumber").trim();
		showroutine.setCity(name1);
		showroutine.setNumber(number);
		showroutine.setTablenumber(tablenumber);
		String uri="jdbc:mysql://localhost/trival?characterEncoding=utf-8";
  		String user="root";
  		String databasepassword="123";
  		StringBuffer t=new StringBuffer();
  		StringBuffer name=new StringBuffer();
  		String s=new String();
  		StringBuffer introduce=new StringBuffer();
  		StringBuffer photouri=new StringBuffer();
  		Boolean ok=true;
  		String backnews="";
  		showroutine.setOk(ok);
  		showroutine.setBacknews(backnews);
  		StringBuffer result=new StringBuffer();
  		int n=0;
		try{
			con=DriverManager.getConnection(uri,user,databasepassword);
			if(tablenumber.equals("1")){
				String condition="SELECT * FROM day1 WHERE shi ='"+name1+"'and xuhao ='"+number+"'";
				sql=con.createStatement();
	  	  		ResultSet rs=sql.executeQuery(condition);
	  	  		rs.next();
	  	  
	  	  		t.append(rs.getString(5));
	  	  		name.append(name1+"一日游#");
	  	  		n=t.indexOf("#");
	  	  		s=t.substring(0,n);
	  	  		t.delete(0,n+1);
	  	  		while((n=t.indexOf("#"))>=0){
	  	  		s=t.substring(0,n);
	  	  		t.delete(0,n+1);
	  	  		condition="SELECT * FROM scenicspot WHERE scenicspot ='"+s+"'";
	  	  		sql=con.createStatement();
	  	  		rs=sql.executeQuery(condition);
	  	  		rs.next();
	  	  		name.append(rs.getString(3)+"#");
	  	  		introduce.append(rs.getString(4)+"#");	
	  	  		photouri.append(rs.getString(1)+"#");
	  	  		}
	  	  		
			}
			if(tablenumber.equals("2")){
				String condition="SELECT * FROM day23 WHERE shi ='"+name1+"'and xuhao ='"+number+"'";
				sql=con.createStatement();
	  	  		ResultSet rs=sql.executeQuery(condition);
	  	  		rs.next();
	  	  
	  	  		t.append(rs.getString(5));
	  	  		name.append(name1+"二到三日游#");
	  	  		n=t.indexOf("#");
	  	  		s=t.substring(0,n);
	  	  		t.delete(0,n+1);
	  	  		while((n=t.indexOf("#"))>=0){
	  	  		s=t.substring(0,n);
	  	  		t.delete(0,n+1);
	  	  		condition="SELECT * FROM scenicspot WHERE scenicspot ='"+s+"'";
	  	  		sql=con.createStatement();
	  	  		rs=sql.executeQuery(condition);
	  	  		rs.next();
	  	  		name.append(rs.getString(3)+"#");
	  	  		introduce.append(rs.getString(4)+"#");	
	  	  		photouri.append(rs.getString(1)+"#");
	  	  		}
			}
			if(tablenumber.equals("3")){
				String condition="SELECT * FROM day4 WHERE shi ='"+name1+"'and xuhao ='"+number+"'";
				sql=con.createStatement();
	  	  		ResultSet rs=sql.executeQuery(condition);
	  	  		rs.next();
	  	  		t.append(rs.getString(5));
	  	  		name.append(name1+"四到六日游#");
	  	  		n=t.indexOf("#");
	  	  		s=t.substring(0,n);
	  	  		t.delete(0,n+1);
	  	  		while((n=t.indexOf("#"))>=0){
	  	  		s=t.substring(0,n);
	  	  		t.delete(0,n+1);
	  	  		condition="SELECT * FROM scenicspot WHERE scenicspot ='"+s+"'";
	  	  		sql=con.createStatement();
	  	  		rs=sql.executeQuery(condition);
	  	  		rs.next();
	  	  		name.append(rs.getString(3)+"#");
	  	  		introduce.append(rs.getString(4)+"#");	
	  	  		photouri.append(rs.getString(1)+"#");
	  	  		}
			}
			showroutine.setName(name);
			showroutine.setIntroduce(introduce);
			showroutine.setPhotouri(photouri);
		}
		catch(SQLException exp){System.out.println(name+"no");}
		try{
			String condition;
			ResultSet rs;
			int m=0;
			condition="SELECT * FROM routinecomment1 WHERE tablenumber='"+tablenumber+"' and number ='"+number+"' and city ='"+name1+"'";
  			sql=con.createStatement();
  			rs=sql.executeQuery(condition);
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
  				condition="update day23 set score ='"+sum+"',person='"+m+"' where shi ='"+name1+"' and xuhao ='"+number+"'";
  				sql=con.createStatement();
  				sql.executeUpdate(condition);
  			}
  			else if(tablenumber.equals("1")){
  				condition="update day1 set score ='"+sum+"',person='"+m+"' where shi ='"+name1+"' and xuhao ='"+number+"'";
  				sql=con.createStatement();
  				sql.executeUpdate(condition);
  			}
  			else if(tablenumber.equals("4")){
  				condition="update day4 set score ='"+sum+"',person='"+m+"' where shi ='"+name1+"' and xuhao ='"+number+"'";
  				sql=con.createStatement();
  				sql.executeUpdate(condition);
  			}
  			showroutine.setPerson(m);
  			showroutine.setAverage(sum);
  			showroutine.setResult(result);
  			showroutine.setN(m);
		}		
		catch(SQLException exp){System.out.println("no#");}
		//System.out.println(showroutine.getName());
		response.sendRedirect("/trival/searchroutine/showroutine2.jsp");
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
