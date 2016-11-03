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

public class HandleSearchroutine extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HandleSearchroutine() {
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
		ShowByPage2 showbean=null;
		try{
			showbean=(ShowByPage2)session.getAttribute("show1");
			if(showbean==null){
				showbean=new ShowByPage2();
				session.setAttribute("show1", showbean);
			}
			else{
				session.removeAttribute("show1");
				showbean=new ShowByPage2();
				session.setAttribute("show1", showbean);
			}
		}
		catch(Exception exp){
			showbean=new ShowByPage2();
			session.setAttribute("show1", showbean);
		}
		showbean.setPagesize(7);
		showbean.setShowpage(1);
		request.setCharacterEncoding("utf-8");
		Connection con;
		Statement sql;
		String backnews="";
		String time=request.getParameter("time").trim();
		String city=request.getParameter("city").trim();
		String sheng=request.getParameter("sheng").trim();
		String shi=request.getParameter("shi").trim();
		String uri="jdbc:mysql://localhost/trival?characterEncoding=utf-8";
  		String user="root";
  		String databasepassword="123";
  		
  		CachedRowSetImpl rowset = null;
  		Boolean suc=false;
  		try {					
			rowset = new CachedRowSetImpl();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
  		int nowpage=0;	
  		int m=0;
  		try{
  			if(city.equals("")||time.equals("")){
  				suc=false;
		  		backnews="不能输入为空";
		  		}
  			else{
  				if(sheng.equals("")){
  					con=DriverManager.getConnection(uri,user,databasepassword);
  		  			if(city.equals("2")&&time.equals("1")){
  		  				suc=false;
  		  				backnews="不推荐一天玩两个城市";
  		  			}
  		  			else if(city.equals("3")&&time.equals("1")){
  		  				suc=false;
  		  				backnews="不推荐一天玩三个城市";
  		  			}
  		  			else if(city.equals("3")&&time.equals("2")){
  		  				suc=false;
  		  				backnews="不推荐三天玩三个城市";
  		  			}
  		  			else if(city.equals("1")&&time.equals("1")){
  		  				if(shi.equals("")){
  		  				String condition="SELECT * FROM city order by score DESC";
  		  				sql=con.createStatement();
  		  	  			ResultSet rs=sql.executeQuery(condition);
  		  	  			rowset.populate(rs);
  			  			rowset.last();
  			  			m=rowset.getRow();
  			  			rowset.first();
  			  			if(m==0){
  		  	  				suc=false;
  		  	  				backnews="没有查到相关记录";
  		  	  			}
  		  	  				else{
  		  	  				suc=true;
  		  	  				backnews="ok";
  		  	  				}
  		  				}
  		  				else{
  		  					String condition="SELECT * FROM city where shi ='"+shi+"' order by score DESC";
  		  					sql=con.createStatement();
  		  	  				ResultSet rs=sql.executeQuery(condition);
  		  	  				rowset.populate(rs);
  		  	  				rowset.last();
  			  				m=rowset.getRow();
  			  				rowset.first();
  			  				if(m==0){
  		  	  				suc=false;
  		  	  				backnews="没有查到相关记录";
  		  	  				}
  		  	  				else{
  		  	  				suc=true;
  		  	  				backnews="ok";
  		  	  				}
  		  				}	  				
  		  			}
  		  			else if(city.equals("1")&&time.equals("2")){
  		  				if(shi.equals("")){
  		  					String condition="SELECT * FROM city order by score DESC";
  		  					sql=con.createStatement();
  		  	  				ResultSet rs=sql.executeQuery(condition);
  		  	  				rowset.populate(rs);
  		  	  				rowset.last();
  			  				m=rowset.getRow();
  			  				rowset.first();
  			  				if(m==0){
  		  	  				suc=false;
  		  	  				backnews="没有查到相关记录";
  		  	  				}
  		  	  				else{
  		  	  				suc=true;
  		  	  				backnews="ok";
  		  	  				}
  		  				}
  		  				else{
  		  					String condition="SELECT * FROM city where shi ='"+shi+"' order by score DESC";
  		  					sql=con.createStatement();
  		  					ResultSet rs=sql.executeQuery(condition);
  		  					rowset.populate(rs);
  		  					rowset.last();
  		  					m=rowset.getRow();
  		  					rowset.first();
  		  					if(m==0){
  		  	  				suc=false;
  		  	  				backnews="没有查到相关记录";
  		  					}
  		  					else{
  		  	  				suc=true;
  		  	  				backnews="ok";
  		  					}
  		  				} 		  				
  		  			}
  		  			else if(city.equals("1")&&time.equals("3")){
  		  			if((shi.equals("")||shi.equals("上海")||shi.equals("北京"))&&(sheng.equals("上海")||sheng.equals("北京"))){
		  					String condition="SELECT * FROM city where sheng="+sheng+" order by score DESC";
		  					sql=con.createStatement();
		  	  				ResultSet rs=sql.executeQuery(condition);
		  	  				rowset.populate(rs);
		  	  				rowset.last();
			  				m=rowset.getRow();
			  				rowset.first();
			  				if(m==0){
		  	  				suc=false;
		  	  				backnews="没有查到相关记录";
		  	  				}
		  	  				else{
		  	  				suc=true;
		  	  				backnews="ok";
		  	  				}
		  				}
  		  			else{
  		  				suc=false;
  		  				backnews="没有查询到相关记录";
  		  			}
  		  			}
  		  			else if(city.equals("2")&&time.equals("2")){
  		  			if(shi.equals("")){
		  					String condition="SELECT * FROM city2 order by score DESC";
		  					sql=con.createStatement();
		  	  				ResultSet rs=sql.executeQuery(condition);
		  	  				rowset.populate(rs);
		  	  				rowset.last();
			  				m=rowset.getRow();
			  				rowset.first();
			  				if(m==0){
		  	  				suc=false;
		  	  				backnews="没有查到相关记录";
		  	  				}
		  	  				else{
		  	  				suc=true;
		  	  				backnews="ok";
		  	  				}
		  				}
		  				else{
		  					String condition="SELECT * FROM city2 where shi1 ='"+shi+"'or shi2 ='"+shi+"' order by score DESC";
		  					sql=con.createStatement();
		  					ResultSet rs=sql.executeQuery(condition);
		  					rowset.populate(rs);
		  					rowset.last();
		  					m=rowset.getRow();
		  					rowset.first();
		  					if(m==0){
		  	  				suc=false;
		  	  				backnews="没有查到相关记录";
		  					}
		  					else{
		  	  				suc=true;
		  	  				backnews="ok";
		  					}
		  				} 		  				
  		  			}
  		  			else if(city.equals("2")&&time.equals("3")){
  		  			if(shi.equals("")){
	  					String condition="SELECT * FROM city26 order by score DESC";
	  					sql=con.createStatement();
	  	  				ResultSet rs=sql.executeQuery(condition);
	  	  				rowset.populate(rs);
	  	  				rowset.last();
		  				m=rowset.getRow();
		  				rowset.first();
		  				if(m==0){
	  	  				suc=false;
	  	  				backnews="没有查到相关记录";
	  	  				}
	  	  				else{
	  	  				suc=true;
	  	  				backnews="ok";
	  	  				}
	  				}
	  				else{
	  					String condition="SELECT * FROM city26 where shi1 ='"+shi+"'or shi2 ='"+shi+"' order by score DESC";
	  					sql=con.createStatement();
	  					ResultSet rs=sql.executeQuery(condition);
	  					rowset.populate(rs);
	  					rowset.last();
	  					m=rowset.getRow();
	  					rowset.first();
	  					if(m==0){
	  	  				suc=false;
	  	  				backnews="没有查到相关记录";
	  					}
	  					else{
	  	  				suc=true;
	  	  				backnews="ok";
	  					}
	  				} 		  				
  		  			}
  		  			else if(city.equals("3")&&time.equals("3")){
  		  			if(shi.equals("")){
	  					String condition="SELECT * FROM city36 order by score DESC";
	  					sql=con.createStatement();
	  	  				ResultSet rs=sql.executeQuery(condition);
	  	  				rowset.populate(rs);
	  	  				rowset.last();
		  				m=rowset.getRow();
		  				rowset.first();
		  				if(m==0){
	  	  				suc=false;
	  	  				backnews="没有查到相关记录";
	  	  				}
	  	  				else{
	  	  				suc=true;
	  	  				backnews="ok";
	  	  				}
	  				}
	  				else{
	  					String condition="SELECT * FROM city36 where shi1 ='"+shi+"'or shi2 ='"+shi+"'or shi3 ='"+shi+"' order by score DESC";
	  					sql=con.createStatement();
	  					ResultSet rs=sql.executeQuery(condition);
	  					rowset.populate(rs);
	  					rowset.last();
	  					m=rowset.getRow();
	  					rowset.first();
	  					if(m==0){
	  	  				suc=false;
	  	  				backnews="没有查到相关记录";
	  					}
	  					else{
	  	  				suc=true;
	  	  				backnews="ok";
	  					}
	  				} 
  		  			}
  				}
  				else {
  				con=DriverManager.getConnection(uri,user,databasepassword);
  			if(city.equals("2")&&time.equals("1")){
  				suc=false;
  				backnews="不推荐一天玩两个城市";
  			}
  			else if(city.equals("3")&&time.equals("1")){
  				suc=false;
  				backnews="不推荐一天玩三个城市";
  			}
  			else if(city.equals("3")&&time.equals("2")){
  				suc=false;
  				backnews="不推荐三天玩三个城市";
  			}
  			else if(city.equals("1")&&time.equals("1")){
  				if(shi.equals("")){
  					String condition="SELECT * FROM city WHERE sheng ='"+sheng+"' order by score DESC";
  	  				sql=con.createStatement();
  	  	  			ResultSet rs=sql.executeQuery(condition);
  	  	  			rowset.populate(rs);
  		  			rowset.last();
  		  			m=rowset.getRow();
  		  			rowset.first();
  		  			if(m==0){
  	  	  				suc=false;
  	  	  				backnews="没有查到相关记录";
  	  	  			}
  	  	  			else{
  	  	  				suc=true;
  	  	  				backnews="ok";
  	  	  			}
  				}
  				else{
  					String condition="SELECT * FROM city WHERE sheng ='"+sheng+"'and shi ='"+shi+"' order by score DESC";
  	  				sql=con.createStatement();
  	  	  			ResultSet rs=sql.executeQuery(condition);
  	  	  			rowset.populate(rs);
  		  			rowset.last();
  		  			m=rowset.getRow();
  		  			rowset.first();
  		  			if(m==0){
  	  	  				suc=false;
  	  	  				backnews="没有查到相关记录";
  	  	  			}
  	  	  			else{
  	  	  				suc=true;
  	  	  				backnews="ok";
  	  	  			}
  				} 				
  			}
  			else if(city.equals("1")&&time.equals("2")){
  				if(shi.equals("")){
  					String condition="SELECT * FROM city WHERE sheng ='"+sheng+"' order by score DESC";
  	  				sql=con.createStatement();
  	  	  			ResultSet rs=sql.executeQuery(condition);
  	  	  			rowset.populate(rs);
  		  			rowset.last();
  		  			m=rowset.getRow();
  		  			rowset.first();
  		  			if(m==0){
  	  	  				suc=false;
  	  	  				backnews="没有查到相关记录";
  	  	  			}
  	  	  			else{
  	  	  				suc=true;
  	  	  				backnews="ok";
  	  	  			}
  				}
  				else{
  					String condition="SELECT * FROM city WHERE sheng ='"+sheng+"'and shi ='"+shi+"' order by score DESC";
  	  				sql=con.createStatement();
  	  	  			ResultSet rs=sql.executeQuery(condition);
  	  	  			rowset.populate(rs);
  		  			rowset.last();
  		  			m=rowset.getRow();
  		  			rowset.first();
  		  			if(m==0){
  	  	  				suc=false;
  	  	  				backnews="没有查到相关记录";
  	  	  			}
  	  	  			else{
  	  	  				suc=true;
  	  	  				backnews="ok";
  	  	  			}
  				}  				
  			}
  			else if(city.equals("1")&&time.equals("3")){
  				if((shi.equals("")&&(sheng.equals("上海")||sheng.equals("北京")))||(shi.equals("上海")&&sheng.equals("上海"))||(shi.equals("北京")&&sheng.equals("北京"))){
  					String condition="SELECT * FROM city WHERE sheng ='"+sheng+"' order by score DESC";
  	  				sql=con.createStatement();
  	  	  			ResultSet rs=sql.executeQuery(condition);
  	  	  			rowset.populate(rs);
  		  			rowset.last();
  		  			m=rowset.getRow();
  		  			rowset.first();
  		  			if(m==0){
  	  	  				suc=false;
  	  	  				backnews="没有查到相关记录";
  	  	  			}
  	  	  			else{
  	  	  				suc=true;
  	  	  				backnews="ok";
  	  	  			}
  				}
  				else{
  	  	  				suc=false;
  	  	  				backnews="没有查到相关记录";
  				}  				
  			}
  			else if(city.equals("2")&&time.equals("2")){
  				if(shi.equals("")){
  					String condition="SELECT * FROM city2 WHERE sheng1 ='"+sheng+"'or sheng2 ='"+sheng+"' order by score DESC";
  	  				sql=con.createStatement();
  	  	  			ResultSet rs=sql.executeQuery(condition);
  	  	  			rowset.populate(rs);
  		  			rowset.last();
  		  			m=rowset.getRow();
  		  			rowset.first();
  		  			if(m==0){
  	  	  				suc=false;
  	  	  				backnews="没有查到相关记录";
  	  	  			}
  	  	  			else{
  	  	  				suc=true;
  	  	  				backnews="ok";
  	  	  			}
  				}
  				else{
  					String condition="SELECT * FROM city2 WHERE (sheng1 ='"+sheng+"'or sheng2 ='"+sheng+"')and (shi1 ='"+shi+"'or shi2='"+shi+"') order by score DESC";
  	  				sql=con.createStatement();
  	  	  			ResultSet rs=sql.executeQuery(condition);
  	  	  			rowset.populate(rs);
  		  			rowset.last();
  		  			m=rowset.getRow();
  		  			rowset.first();
  		  			if(m==0){
  	  	  				suc=false;
  	  	  				backnews="没有查到相关记录";
  	  	  			}
  	  	  			else{
  	  	  				suc=true;
  	  	  				backnews="ok";
  	  	  			}
  				}  				
  			}
  			else if(city.equals("2")&&time.equals("3")){
  				if(shi.equals("")){
  					String condition="SELECT * FROM city26 WHERE sheng1 ='"+sheng+"'or sheng2 ='"+sheng+"' order by score DESC";
  	  				sql=con.createStatement();
  	  	  			ResultSet rs=sql.executeQuery(condition);
  	  	  			rowset.populate(rs);
  		  			rowset.last();
  		  			m=rowset.getRow();
  		  			rowset.first();
  		  			if(m==0){
  	  	  				suc=false;
  	  	  				backnews="没有查到相关记录";
  	  	  			}
  	  	  			else{
  	  	  				suc=true;
  	  	  				backnews="ok";
  	  	  			}
  				}
  				else{
  					String condition="SELECT * FROM city26 WHERE (sheng1 ='"+sheng+"'or sheng2 ='"+sheng+"')and (shi1 ='"+shi+"'or shi2='"+shi+"') order by score DESC";
  	  				sql=con.createStatement();
  	  	  			ResultSet rs=sql.executeQuery(condition);
  	  	  			rowset.populate(rs);
  		  			rowset.last();
  		  			m=rowset.getRow();
  		  			rowset.first();
  		  			if(m==0){
  	  	  				suc=false;
  	  	  				backnews="没有查到相关记录";
  	  	  			}
  	  	  			else{
  	  	  				suc=true;
  	  	  				backnews="ok";
  	  	  			}
  				}  	
  			}
  			else if(city.equals("3")&&time.equals("3")){
  				if(shi.equals("")){
  					String condition="SELECT * FROM city36 WHERE sheng1 ='"+sheng+"'or sheng2 ='"+sheng+"'or sheng3='"+sheng+"' order by score DESC";
  	  				sql=con.createStatement();
  	  	  			ResultSet rs=sql.executeQuery(condition);
  	  	  			rowset.populate(rs);
  		  			rowset.last();
  		  			m=rowset.getRow();
  		  			rowset.first();
  		  			if(m==0){
  	  	  				suc=false;
  	  	  				backnews="没有查到相关记录";
  	  	  			}
  	  	  			else{
  	  	  				suc=true;
  	  	  				backnews="ok";
  	  	  			}
  				}
  				else{
  					String condition="SELECT * FROM city36 WHERE (sheng1 ='"+sheng+"'or sheng2 ='"+sheng+"'or sheng3 ='"+sheng+"')and (shi1 ='"+shi+"'or shi2='"+shi+"'or shi3='"+shi+"') order by score DESC";
  	  				sql=con.createStatement();
  	  	  			ResultSet rs=sql.executeQuery(condition);
  	  	  			rowset.populate(rs);
  		  			rowset.last();
  		  			m=rowset.getRow();
  		  			rowset.first();
  		  			if(m==0){
  	  	  				suc=false;
  	  	  				backnews="没有查到相关记录";
  	  	  			}
  	  	  			else{
  	  	  				suc=true;
  	  	  				backnews="ok";
  	  	  			}
  				}  	
  			}
  		}
  			
  			showbean.setRowset(rowset);
  			if(suc==true&&city.equals("1")){
  				StringBuffer introduce=new StringBuffer(),name=new StringBuffer();
  				name.append(rowset.getString(2)+"#"+rowset.getString(4)+"#");
  				introduce.append(rowset.getString(1)+"#"+rowset.getString(2)+"#"+rowset.getString(3)+"#");
  				while(rowset.next()){
  					name.append(rowset.getString(2)+"#"+rowset.getString(4)+"#");
  	  				introduce.append(rowset.getString(1)+"#"+rowset.getString(2)+"#"+rowset.getString(3)+"#");
  				}
  				showbean.setIntroduce(introduce);
  				showbean.setName(name);
  				StringBuffer a=new StringBuffer();
  				a.append("1");
  				showbean.setTimemark(a);
  			}
  			else if(suc==true&&city.equals("2")){
  				StringBuffer introduce=new StringBuffer(),name=new StringBuffer();
  				StringBuffer timemark=new StringBuffer();
  				name.append(rowset.getString(2)+"#"+rowset.getString(6)+"#"+rowset.getString(9)+"#");
  				introduce.append(rowset.getString(1)+"#"+rowset.getString(2)+"#"+rowset.getString(4)+"#"+rowset.getString(5)+"#"+rowset.getString(6)+"#"+rowset.getString(8)+"#");
  				timemark.append(rowset.getString(3)+"#"+rowset.getString(7)+"#");
  				while(rowset.next()){
  					name.append(rowset.getString(2)+"#"+rowset.getString(6)+"#"+rowset.getString(9)+"#");
  	  				introduce.append(rowset.getString(1)+"#"+rowset.getString(2)+"#"+rowset.getString(4)+"#"+rowset.getString(5)+"#"+rowset.getString(6)+"#"+rowset.getString(8)+"#");
  	  				timemark.append(rowset.getString(3)+"#"+rowset.getString(7)+"#");
  				}
  				showbean.setIntroduce(introduce);
  				showbean.setName(name);
  				showbean.setTimemark(timemark);
  				System.out.println(name.toString()+timemark.toString());
  			}
  			else if(suc==true&&city.equals("3")){
  				StringBuffer introduce=new StringBuffer(),name=new StringBuffer();
  				StringBuffer timemark=new StringBuffer();
  				name.append(rowset.getString(2)+"#"+rowset.getString(6)+"#"+rowset.getString(10)+"#"+rowset.getString(13)+"#");
  				introduce.append(rowset.getString(1)+"#"+rowset.getString(2)+"#"+rowset.getString(4)+"#"+rowset.getString(5)+"#"+rowset.getString(6)+"#"+rowset.getString(8)+"#"+rowset.getString(9)+"#"+rowset.getString(10)+"#"+rowset.getString(12)+"#");
  				timemark.append(rowset.getString(3)+"#"+rowset.getString(7)+"#"+rowset.getString(11)+"#");
  				while(rowset.next()){
  					name.append(rowset.getString(2)+"#"+rowset.getString(6)+"#"+rowset.getString(10)+"#"+rowset.getString(13)+"#");
  	  				introduce.append(rowset.getString(1)+"#"+rowset.getString(2)+"#"+rowset.getString(4)+"#"+rowset.getString(5)+"#"+rowset.getString(6)+"#"+rowset.getString(8)+"#"+rowset.getString(9)+"#"+rowset.getString(10)+"#"+rowset.getString(12)+"#");
  	  				timemark.append(rowset.getString(3)+"#"+rowset.getString(7)+"#"+rowset.getString(11)+"#");
  				}
  				showbean.setIntroduce(introduce);
  				showbean.setName(name);
  				showbean.setTimemark(timemark);
  				//System.out.println(name.toString()+timemark.toString());
  			}
  			int pagesize=7;  	  		
  	  		int pageallcount=0;
  	  		if(m%pagesize==0)pageallcount=m/pagesize;
  	  		else pageallcount=m/pagesize+1;
  	  		showbean.setPageallcount(pageallcount);
  	  		showbean.setNumber(m);
  	  		showbean.qiuNowpage();
  	  		
  			}
  			showbean.setSuc(suc);
  			showbean.setBacknews(backnews);
  			showbean.setCity(city);
  			showbean.setTime(time);  			
  		}
  		catch(SQLException exp){}
  		//System.out.println(name.toString());
  		response.sendRedirect("/trival/searchroutine/searchroutineindex.jsp");
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
