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

public class HandleShowByPage2 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HandleShowByPage2() {
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
		int pageallcount=showbean.getPageallcount();
		int showpage= Integer.parseInt(request.getParameter("showpage").trim())%pageallcount;
		if(showpage==0)showpage=pageallcount;
		int pagesize=showbean.getPagesize();
		int number=showbean.getNumber();
		showbean.setShowpage(showpage);
		showbean.qiuNowpage();
		String city=showbean.getCity();
		int nowpage=showbean.getNowpage();
		StringBuffer name=new StringBuffer(),introduce=new StringBuffer();
		CachedRowSetImpl rowset = null;					
		rowset = showbean.getRowset();
		StringBuffer timemark=new StringBuffer();
		if(city.equals("1")){
		try{
			rowset.absolute((showpage-1)*pagesize+1);
			for(int i=1;i<=nowpage;i++){
				name.append(rowset.getString(2)+"#"+rowset.getString(4)+"#");
				introduce.append(rowset.getString(1)+"#"+rowset.getString(2)+"#"+rowset.getString(3)+"#");
				rowset.next();
			}
			showbean.setIntroduce(introduce);
			showbean.setName(name);
		}
		catch(SQLException exp){}
		}
		else if(city.equals("2")){
				try {
					rowset.absolute((showpage-1)*pagesize+1);
					for(int i=1;i<=nowpage;i++){
						name.append(rowset.getString(2)+"#"+rowset.getString(6)+"#"+rowset.getString(9)+"#");
		  				introduce.append(rowset.getString(1)+"#"+rowset.getString(2)+"#"+rowset.getString(4)+"#"+rowset.getString(5)+"#"+rowset.getString(6)+"#"+rowset.getString(8)+"#");
		  				timemark.append(rowset.getString(3)+"#"+rowset.getString(7)+"#");
						rowset.next();
					}
					showbean.setIntroduce(introduce);
					showbean.setName(name);
					showbean.setTimemark(timemark);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		}
		else if(city.equals("3")){
			try {
				rowset.absolute((showpage-1)*pagesize+1);
				for(int i=1;i<=nowpage;i++){
					name.append(rowset.getString(2)+"#"+rowset.getString(6)+"#"+rowset.getString(10)+"#"+rowset.getString(13)+"#");
  	  				introduce.append(rowset.getString(1)+"#"+rowset.getString(2)+"#"+rowset.getString(4)+"#"+rowset.getString(5)+"#"+rowset.getString(6)+"#"+rowset.getString(8)+"#"+rowset.getString(9)+"#"+rowset.getString(10)+"#"+rowset.getString(12)+"#");
  	  				timemark.append(rowset.getString(3)+"#"+rowset.getString(7)+"#"+rowset.getString(11)+"#");
					rowset.next();
				}
				showbean.setIntroduce(introduce);
				showbean.setName(name);
				showbean.setTimemark(timemark);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		response.sendRedirect("/trival/searchroutine/searchroutineindex.jsp");
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
