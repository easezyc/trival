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

public class HandleShowroutine1 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HandleShowroutine1() {
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
		ShowByPage2 showbean=null;
		showbean=(ShowByPage2)session.getAttribute("show1");
		Searchroutine searchroutine=new Searchroutine();
		try{
			searchroutine=(Searchroutine)session.getAttribute("searchroutine");
			if(searchroutine==null){
				searchroutine=new Searchroutine();
				session.setAttribute("searchroutine", searchroutine);
			}
			else{
				session.removeAttribute("searchroutine");
				searchroutine=new Searchroutine();
				session.setAttribute("searchroutine", searchroutine);
			}
		}
		catch(Exception exp){
			searchroutine=new Searchroutine();
			session.setAttribute("searchroutine", searchroutine);
		}
		double allscore=0;
		request.setCharacterEncoding("utf-8");
		Connection con = null;
		Statement sql;
		String city=showbean.getCity();
		String time=showbean.getTime();
		String name1="",name2="",name3="";
		StringBuffer name=new StringBuffer(),introduce=new StringBuffer(),routine=new StringBuffer();
		String timemark1="",timemark2="",timemark3="";
		String uri="jdbc:mysql://localhost/trival?characterEncoding=utf-8";
  		String user="root";
  		String databasepassword="123";
  		StringBuffer routinenumber=new StringBuffer();
  		StringBuffer tablenumber=new StringBuffer();
  		StringBuffer day=new StringBuffer();
		if(city.equals("1")){
			if(time.equals("1")){
				name1=request.getParameter("name1").trim();
				name.append(name1+"#");
				try{
					con=DriverManager.getConnection(uri,user,databasepassword);
					String condition="SELECT * FROM city WHERE shi ='"+name1+"'";
					sql=con.createStatement();
		  	  		ResultSet rs=sql.executeQuery(condition);
		  	  		rs.next();
		  	  		introduce.append(rs.getString(3)+"#");
		  	  		condition="SELECT * FROM day1 WHERE shi ='"+name1+"' order by score DESC";
		  	  		sql=con.createStatement();
		  	  		rs=sql.executeQuery(condition);
		  	  		tablenumber.append("1#");
		  	  		day.append("一日游#");
		  	  		rs.next();
		  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  			routinenumber.append(rs.getInt(3)+"#");
		  			int t=rs.getInt(3);
		  			allscore+=rs.getDouble(6);
		  	  		while(rs.next())
		  	  		{
		  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  	  			//routinenumber.append(rs.getInt(3)+"#");
		  	  			allscore+=rs.getDouble(6);
		  	  		}
		  	  		allscore=allscore/t;
		  	  		routine.append("!");
				}
				catch(SQLException exp){}
			}
			else if(time.equals("2")){
				name1=request.getParameter("name1").trim();
				name.append(name1+"#");
				try{
					con=DriverManager.getConnection(uri,user,databasepassword);
					String condition="SELECT * FROM city WHERE shi ='"+name1+"'";
					sql=con.createStatement();
		  	  		ResultSet rs=sql.executeQuery(condition);
		  	  		rs.next();
		  	  		introduce.append(rs.getString(3)+"#");
		  	  		condition="SELECT * FROM day23 WHERE shi ='"+name1+"'  order by score DESC";
		  	  		sql=con.createStatement();
		  	  		rs=sql.executeQuery(condition);
		  	  		tablenumber.append("2#");
		  	  		day.append("二到三日游#");
		  	  		rs.next();
		  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  			routinenumber.append(rs.getInt(3)+"#");
		  			int t=rs.getInt(3);
		  			allscore+=rs.getInt(6);
		  	  		while(rs.next())
		  	  		{
		  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  	  			//routinenumber.append(rs.getInt(3)+"#");
		  	  			allscore+=rs.getInt(6);
		  	  		}
		  	  		routine.append("!");
		  	  		allscore/=t;
				}
				catch(SQLException exp){}
			}
			else if(time.equals("3")){
				name1=request.getParameter("name1").trim();
				name.append(name1+"#");
				try{
					con=DriverManager.getConnection(uri,user,databasepassword);
					String condition="SELECT * FROM city WHERE shi ='"+name1+"'";
					sql=con.createStatement();
		  	  		ResultSet rs=sql.executeQuery(condition);
		  	  		rs.next();
		  	  		introduce.append(rs.getString(3)+"#");
		  	  		condition="SELECT * FROM day4 WHERE shi ='"+name1+"'  order by score DESC";
		  	  		sql=con.createStatement();
		  	  		rs=sql.executeQuery(condition);
		  	  		tablenumber.append("3#");
		  	  		day.append("四到六日游#");
		  	  		rs.next();
		  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  			routinenumber.append(rs.getInt(3)+"#");
		  			int t=rs.getInt(3);
		  			allscore+=rs.getInt(6);
		  	  		while(rs.next())
		  	  		{
		  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  	  			//routinenumber.append(rs.getInt(3)+"#");
		  	  			allscore+=rs.getInt(6);
		  	  		}
		  	  		allscore/=t;
		  	  		routine.append("!");
				}
				catch(SQLException exp){}
			}
		}
		if(city.equals("2")){
			if(time.equals("2")){
				name1=request.getParameter("name1").trim();
				name.append(name1+"#");
				name2=request.getParameter("name2").trim();
				name.append(name2+"#");
				timemark1=request.getParameter("timemark1").trim();
				timemark2=request.getParameter("timemark2").trim();
				try{
					con=DriverManager.getConnection(uri,user,databasepassword);
					String condition="SELECT * FROM city2 WHERE shi1 ='"+name1+"'and shi2='"+name2+"'";
					sql=con.createStatement();
		  	  		ResultSet rs=sql.executeQuery(condition);
		  	  		rs.next();
		  	  		introduce.append(rs.getString(4)+"#"+rs.getString(8)+"#");
		  	  		if(timemark1.equals("2")){
		  	  		condition="SELECT * FROM day23 WHERE shi ='"+name1+"'  order by score DESC";
		  	  		sql=con.createStatement();
		  	  		rs=sql.executeQuery(condition);
		  	  		tablenumber.append("2#");
		  	  		day.append("二到三日游#");
		  	  		rs.next();
		  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  			routinenumber.append(rs.getInt(3)+"#");
		  			allscore+=rs.getDouble(6);
		  	  		while(rs.next())
		  	  		{
		  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  	  			//routinenumber.append(rs.getInt(3)+"#");
		  	  		}
		  	  		routine.append("!");
		  	  		}
		  	  		else if(timemark1.equals("1")){
		  	  		condition="SELECT * FROM day1 WHERE shi ='"+name1+"'  order by score DESC";
		  	  		sql=con.createStatement();
		  	  		rs=sql.executeQuery(condition);
		  	  		tablenumber.append("1#");
		  	  		day.append("一日游#");
		  	  		rs.next();
		  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  			routinenumber.append(rs.getInt(3)+"#");
		  			allscore+=rs.getDouble(6);
		  	  		while(rs.next())
		  	  		{
		  	  			
		  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  	  			//routinenumber.append(rs.getInt(3)+"#");
		  	  		}
		  	  		routine.append("!");
		  	  		}
		  	  	if(timemark2.equals("2")){
		  	  		condition="SELECT * FROM day23 WHERE shi ='"+name2+"'  order by score DESC";
		  	  		sql=con.createStatement();
		  	  		rs=sql.executeQuery(condition);
		  	  		tablenumber.append("2#");
		  	  		day.append("二到三日游#");
		  	  		rs.next();
		  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  			routinenumber.append(rs.getInt(3)+"#");
		  			allscore+=rs.getDouble(6);
		  	  		while(rs.next())
		  	  		{
		  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  	  			//routinenumber.append(rs.getInt(3)+"#");
		  	  		}
		  	  		routine.append("!");
		  	  		}
		  	  		else if(timemark2.equals("1")){
		  	  		condition="SELECT * FROM day1 WHERE shi ='"+name2+"'  order by score DESC";
		  	  		sql=con.createStatement();
		  	  		rs=sql.executeQuery(condition);
		  	  		tablenumber.append("1#");
		  	  		day.append("一日游#");
		  	  		rs.next();
		  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  			routinenumber.append(rs.getInt(3)+"#");
		  			allscore+=rs.getDouble(6);
		  	  		while(rs.next())
		  	  		{
		  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  	  			//routinenumber.append(rs.getInt(3)+"#");
		  	  		}
		  	  		routine.append("!");
		  	  		}
		  	  		allscore/=2;
				}
				catch(SQLException exp){}
			}
			else if(time.equals("3")){
				name1=request.getParameter("name1").trim();
				name.append(name1+"#");
				name2=request.getParameter("name2").trim();
				name.append(name2+"#");
				timemark1=request.getParameter("timemark1").trim();
				timemark2=request.getParameter("timemark2").trim();
				try{
					con=DriverManager.getConnection(uri,user,databasepassword);
					String condition="SELECT * FROM city26 WHERE shi1 ='"+name1+"'and shi2='"+name2+"'";
					sql=con.createStatement();
		  	  		ResultSet rs=sql.executeQuery(condition);
		  	  		rs.next();
		  	  		introduce.append(rs.getString(4)+"#"+rs.getString(8)+"#");
		  	  		if(timemark1.equals("2")){
		  	  		condition="SELECT * FROM day23 WHERE shi ='"+name1+"'  order by score DESC";
		  	  		sql=con.createStatement();
		  	  		rs=sql.executeQuery(condition);
		  	  		tablenumber.append("2#");
		  	  		day.append("二到三日游#");
		  	  		rs.next();
		  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  			routinenumber.append(rs.getInt(3)+"#");
		  			allscore+=rs.getDouble(6);
		  	  		while(rs.next())
		  	  		{
		  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  	  			//routinenumber.append(rs.getInt(3)+"#");
		  	  		}
		  	  		routine.append("!");
		  	  		}
		  	  		else if(timemark1.equals("1")){
		  	  		condition="SELECT * FROM day1 WHERE shi ='"+name1+"'  order by score DESC";
		  	  		sql=con.createStatement();
		  	  		rs=sql.executeQuery(condition);
		  	  		tablenumber.append("1#");
		  	  		day.append("一日游#");
		  	  		rs.next();
		  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  			routinenumber.append(rs.getInt(3)+"#");
		  			allscore+=rs.getDouble(6);
		  	  		while(rs.next())
		  	  		{
		  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  	  			//routinenumber.append(rs.getInt(3)+"#");
		  	  		}
		  	  		routine.append("!");
		  	  		}
		  	  	if(timemark2.equals("2")){
		  	  		condition="SELECT * FROM day23 WHERE shi ='"+name2+"'  order by score DESC";
		  	  		sql=con.createStatement();
		  	  		rs=sql.executeQuery(condition);
		  	  		tablenumber.append("2#");
		  	  		day.append("二到三日游#");
		  	  		rs.next();
		  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  			routinenumber.append(rs.getInt(3)+"#");
		  			allscore+=rs.getDouble(6);
		  	  		while(rs.next())
		  	  		{
		  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  	  			//routinenumber.append(rs.getInt(3)+"#");
		  	  		}
		  	  		routine.append("!");
		  	  		}
		  	  		else if(timemark2.equals("1")){
		  	  		condition="SELECT * FROM day1 WHERE shi ='"+name2+"' order by score DESC";
		  	  		sql=con.createStatement();
		  	  		rs=sql.executeQuery(condition);
		  	  		tablenumber.append("1#");
		  	  		day.append("一日游#");
		  	  		rs.next();
		  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  			routinenumber.append(rs.getInt(3)+"#");
		  			allscore+=rs.getDouble(6);
		  	  		while(rs.next())
		  	  		{
		  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
		  	  			//routinenumber.append(rs.getInt(3)+"#");
		  	  		}
		  	  		routine.append("!");
		  	  		}
				}
				catch(SQLException exp){}
			}
		}
		
		
		
		
		
		if(city.equals("3")){
			name1=request.getParameter("name1").trim();
			name.append(name1+"#");
			name2=request.getParameter("name2").trim();
			name.append(name2+"#");
			name3=request.getParameter("name3").trim();
			name.append(name3+"#");
			timemark1=request.getParameter("timemark1").trim();
			timemark2=request.getParameter("timemark2").trim();
			timemark3=request.getParameter("timemark3").trim();
			try{
				con=DriverManager.getConnection(uri,user,databasepassword);
				String condition="SELECT * FROM city36 WHERE shi1 ='"+name1+"'and shi2='"+name2+"'and shi3='"+name3+"'";
				sql=con.createStatement();
	  	  		ResultSet rs=sql.executeQuery(condition);
	  	  		rs.next();
	  	  		introduce.append(rs.getString(4)+"#"+rs.getString(8)+"#"+rs.getString(12)+"#");
	  	  		if(timemark1.equals("3")){
	  	  		condition="SELECT * FROM day4 WHERE shi ='"+name1+"' order by score DESC";
	  	  		sql=con.createStatement();
	  	  		rs=sql.executeQuery(condition);
	  	  		tablenumber.append("2#");
	  	  		day.append("四日游#");
	  	  		rs.next();
	  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  			routinenumber.append(rs.getInt(3)+"#");
	  			allscore+=rs.getDouble(6);
	  	  		while(rs.next())
	  	  		{
	  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  	  			//routinenumber.append(rs.getInt(3)+"#");
	  	  		}
	  	  		routine.append("!");
	  	  		}
	  	  		else if(timemark1.equals("2")){
	  	  		condition="SELECT * FROM day23 WHERE shi ='"+name1+"' order by score DESC";
	  	  		sql=con.createStatement();
	  	  		rs=sql.executeQuery(condition);
	  	  		tablenumber.append("2#");
	  	  		day.append("二到三日游#");
	  	  		rs.next();
	  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  			routinenumber.append(rs.getInt(3)+"#");
	  			allscore+=rs.getDouble(6);
	  	  		while(rs.next())
	  	  		{
	  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  	  			//routinenumber.append(rs.getInt(3)+"#");
	  	  		}
	  	  		routine.append("!");
	  	  		}
	  	  		else if(timemark1.equals("1")){
	  	  		condition="SELECT * FROM day1 WHERE shi ='"+name1+"' order by score DESC";
	  	  		sql=con.createStatement();
	  	  		rs=sql.executeQuery(condition);
	  	  		tablenumber.append("1#");
	  	  		day.append("一日游#");
	  	  		rs.next();
	  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  			routinenumber.append(rs.getInt(3)+"#");
	  			allscore+=rs.getDouble(6);
	  	  		while(rs.next())
	  	  		{
	  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  	  			//routinenumber.append(rs.getInt(3)+"#");
	  	  		}
	  	  		routine.append("!");
	  	  		}
	  	  		if(timemark2.equals("2")){
	  	  		condition="SELECT * FROM day23 WHERE shi ='"+name2+"' order by score DESC";
	  	  		sql=con.createStatement();
	  	  		rs=sql.executeQuery(condition);
	  	  		tablenumber.append("2#");
	  	  		day.append("二到三日游#");
	  	  		rs.next();
	  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  			routinenumber.append(rs.getInt(3)+"#");
	  			allscore+=rs.getDouble(6);
	  	  		while(rs.next())
	  	  		{
	  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  	  			//routinenumber.append(rs.getInt(3)+"#");
	  	  		}
	  	  		routine.append("!");
	  	  		}
	  	  		else if(timemark2.equals("1")){
	  	  		condition="SELECT * FROM day1 WHERE shi ='"+name2+"' order by score DESC";
	  	  		sql=con.createStatement();
	  	  		rs=sql.executeQuery(condition);
	  	  		tablenumber.append("1#");
	  	  		day.append("一日游#");
	  	  		rs.next();
	  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  			routinenumber.append(rs.getInt(3)+"#");
	  			allscore+=rs.getDouble(6);
	  	  		while(rs.next())
	  	  		{
	  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  	  			//routinenumber.append(rs.getInt(3)+"#");
	  	  		}
	  	  		routine.append("!");
	  	  		}
	  	  		else if(timemark2.equals("3")){
	  	  		condition="SELECT * FROM day4 WHERE shi ='"+name2+"' order by score DESC";
	  	  		sql=con.createStatement();
	  	  		rs=sql.executeQuery(condition);
	  	  		tablenumber.append("2#");
	  	  		day.append("四日游#");
	  	  		rs.next();
	  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  			routinenumber.append(rs.getInt(3)+"#");
	  			allscore+=rs.getDouble(6);
	  	  		while(rs.next())
	  	  		{
	  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  	  			//routinenumber.append(rs.getInt(3)+"#");
	  	  		}
	  	  		routine.append("!");
	  	  		}
	  	  	if(timemark3.equals("2")){
	  	  		condition="SELECT * FROM day23 WHERE shi ='"+name3+"' order by score DESC";
	  	  		sql=con.createStatement();
	  	  		rs=sql.executeQuery(condition);
	  	  		tablenumber.append("2#");
	  	  		day.append("二到三日游#");
	  	  		rs.next();
	  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  			routinenumber.append(rs.getInt(3)+"#");
	  			allscore+=rs.getDouble(6);
	  	  		while(rs.next())
	  	  		{
	  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  	  			//routinenumber.append(rs.getInt(3)+"#");
	  	  		}
	  	  	
	  	  		routine.append("!");
	  	  		}
	  	  		else if(timemark3.equals("1")){
	  	  		condition="SELECT * FROM day1 WHERE shi ='"+name3+"' order by score DESC";
	  	  		sql=con.createStatement();
	  	  		rs=sql.executeQuery(condition);
	  	  		tablenumber.append("1#");
	  	  		day.append("一日游#");
	  	  		rs.next();
	  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  			routinenumber.append(rs.getInt(3)+"#");
	  			allscore+=rs.getDouble(6);
	  	  		while(rs.next())
	  	  		{
	  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  	  			//routinenumber.append(rs.getInt(3)+"#");
	  	  		}
	  	  		routine.append("!");
	  	  		}
	  	  		else if(timemark3.equals("3")){
	  	  		condition="SELECT * FROM day4 WHERE shi ='"+name3+"' order by score DESC";
	  	  		sql=con.createStatement();
	  	  		rs=sql.executeQuery(condition);
	  	  		tablenumber.append("2#");
	  	  		day.append("四日游#");
	  	  		rs.next();
	  	  		routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  			routinenumber.append(rs.getInt(3)+"#");
	  			allscore+=rs.getDouble(6);
	  	  		while(rs.next())
	  	  		{
	  	  			routine.append(rs.getInt(4)+"#"+rs.getString(6)+rs.getString(5)+"*");
	  	  			//routinenumber.append(rs.getInt(3)+"#");
	  	  		}
	  	  		routine.append("!");
	  	  		}
			}
			catch(SQLException exp){}
		}
		try{
			allscore=allscore/Integer.parseInt(city);
			String condition;
			if(city.equals("1")){
				condition="update city set score ='"+allscore+"' where shi ='"+name1+"'";
				sql=con.createStatement();
				sql.executeUpdate(condition);
			}
			else if(city.equals("2")&&time.equals("2")){
				condition="update city2 set score ='"+allscore+"' where shi1 ='"+name1+"' and shi2 ='"+name2+"'";
				sql=con.createStatement();
				sql.executeUpdate(condition);
			}
			else if(city.equals("2")&&time.equals("3")){
				condition="update city26 set score ='"+allscore+"' where shi1 ='"+name1+"' and shi2 ='"+name2+"'";
				sql=con.createStatement();
				sql.executeUpdate(condition);
			}
			else if(city.equals("3")&&time.equals("3")){
				condition="update city36 set score ='"+allscore+"' where shi1 ='"+name1+"' and shi2 ='"+name2+"' and shi3 ='"+name3+"'";
				sql=con.createStatement();
				sql.executeUpdate(condition);
			}
		}
		catch(Exception exp){}
		searchroutine.setCity(city);
		searchroutine.setTime(time);
		searchroutine.setIntroduce(introduce);
		searchroutine.setName(name);
		searchroutine.setRoutine(routine);
		searchroutine.setRoutinenumber(routinenumber);
		searchroutine.setTablenumber(tablenumber);
		searchroutine.setDay(day);
		//System.out.println(day);
		//System.out.println(routinenumber);
		//System.out.println(tablenumber);
		//System.out.println(time);
		//System.out.println(name.toString());
		//System.out.println(city);
		//System.out.println(introduce);
		//System.out.println(routine);
		response.sendRedirect("/trival/searchroutine/showroutine1.jsp");
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
