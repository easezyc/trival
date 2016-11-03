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

public class HandleShowByPage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HandleShowByPage() {
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
		ShowByPage showbean=null;
		showbean=(ShowByPage)session.getAttribute("show");
		int pageallcount=showbean.getPageallcount();
		int showpage= Integer.parseInt(request.getParameter("showpage").trim())%pageallcount;
		if(showpage==0)showpage=pageallcount;
		int pagesize=showbean.getPagesize();
		int number=showbean.getNumber();
		showbean.setShowpage(showpage);
		showbean.qiuNowpage();
		int nowpage=showbean.getNowpage();
		StringBuffer result=new StringBuffer();
		CachedRowSetImpl rowset = null;					
		rowset = showbean.getRowset();		
		try{
			rowset.absolute((showpage-1)*pagesize+1);
			for(int i=1;i<=nowpage;i++){
				result.append(rowset.getString(3)+"#"+rowset.getString(2)+"#"+"共计"+rowset.getInt(6)+"人评论，评分:"+rowset.getDouble(5)+"#"+rowset.getString(4)+"#");
				rowset.next();
			}
			showbean.setPresentpageresult(result);
		}
		catch(SQLException exp){}
		response.sendRedirect("/trival/searchscenicspot/searchscenicspot.jsp");
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
