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
public class HandleScenicspot extends HttpServlet {
	
	/**
	 * Constructor of the object.
	 */
	public HandleScenicspot() {
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
	@SuppressWarnings("restriction")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		ShowByPage showbean=null;
		try{
			showbean=(ShowByPage)session.getAttribute("show");
			if(showbean==null){
				showbean=new ShowByPage();
				session.setAttribute("show", showbean);
			}
			else{
				session.removeAttribute("show");
				showbean=new ShowByPage();
				session.setAttribute("show", showbean);
			}
		}
		catch(Exception exp){
			showbean=new ShowByPage();
			session.setAttribute("show", showbean);
		}
		showbean.setPagesize(10);
		showbean.setShowpage(1);
		request.setCharacterEncoding("utf-8");
		Connection con;
		Statement sql;
		String backnews="";
		Boolean suc=false;
		String name=request.getParameter("scenicspotname").trim();
		String sheng=request.getParameter("sheng").trim();
		String uri="jdbc:mysql://localhost/trival?characterEncoding=utf-8";
  		String user="root";
  		String databasepassword="123";
  		CachedRowSetImpl rowset = null;
				try {					
					rowset = new CachedRowSetImpl();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		int nowpage=0;	
  		int m=0;
  		try{
  			
  			if(sheng.equals("")){
  				if(name.equals("")){suc=false;
		  		backnews="不能输入为空";}
  			else {
  				con=DriverManager.getConnection(uri,user,databasepassword);
  	  			String condition="SELECT * FROM scenicspot WHERE scenicspot like'%"+name+"%' ORDER BY score DESC";
  	  			
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
  			else {
  				con=DriverManager.getConnection(uri,user,databasepassword);
  				String condition="";
  				if(name.equals("")){
  					condition="SELECT * FROM scenicspot WHERE sheng='"+sheng+"' ORDER BY score DESC";
  		  		}
  				else {
  					condition="SELECT * FROM scenicspot WHERE scenicspot like'%"+name+"%'and sheng='"+sheng+"' ORDER BY score DESC";
  				}
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
  			showbean.setBacknews(backnews);
  			showbean.setSuc(suc);
  			showbean.setRowset(rowset);
  			if(suc==true){
  				StringBuffer result=new StringBuffer();
  				result.append(rowset.getString(3)+"#"+rowset.getString(2)+"#"+"共计"+rowset.getInt(6)+"人评论，评分:"+rowset.getDouble(5)+"#"+rowset.getString(4)+"#");
  				while(rowset.next()){
  				result.append(rowset.getString(3)+"#"+rowset.getString(2)+"#"+"共计"+rowset.getInt(6)+"人评论，评分:"+rowset.getDouble(5)+"#"+rowset.getString(4)+"#");
  				}
  				showbean.setPresentpageresult(result);
  			}
  			int pagesize=10;  	  		
  	  		int pageallcount=0;
  	  		if(m%pagesize==0)pageallcount=m/pagesize;
  	  		else pageallcount=m/pagesize+1;
  	  		showbean.setPageallcount(pageallcount);
  	  		  	  		
  	  		
  	  		showbean.setNumber(m);
  	  		showbean.qiuNowpage();
  		}
  		catch(SQLException exp){}
  		response.sendRedirect("/trival/searchscenicspot/searchscenicspot.jsp");  		
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
