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

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class HandleRoutine extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HandleRoutine() {
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
		response.setCharacterEncoding("UTF-8");
		routinecomment routinecomment;
		StringBuffer article=new StringBuffer();
		boolean ok=false;
		int number=0;
		double score=0;
		StringBuffer result=new StringBuffer();
		try{
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
		}
		String geturi=request.getParameter("uri");
		String uri="E:/myeclipse work/trival/WebRoot/showroutine/routine/"+geturi;
		System.out.println(uri);//"C:/zyc/apache-tomcat-8.0.24/webapps/trival/showroutine/routine/"
		try {
            String encoding="utf-8";
            File file=new File(uri);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    article.append(lineTxt);
                }
                read.close();
            }else{
            	System.out.println("找不到指定的文件");
            }
            Connection con;
			Statement sql;
			String uri1="jdbc:mysql://localhost/trival?characterEncoding=utf-8";				 
	  		String user="root";
	  		String databasepassword="123";
	  		con=DriverManager.getConnection(uri1,user,databasepassword);
	  		String condition="SELECT * FROM routinecomment WHERE uri='"+geturi+"'";
  			sql=con.createStatement();
  			ResultSet rs=sql.executeQuery(condition);
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
  			else{
  				double save=0;routinecomment.setScore(save);}
    } catch (Exception e) {
        System.out.println("读取文件内容出错");
        e.printStackTrace();
    }
		routinecomment.setArticle(article);
		routinecomment.setUri(geturi);
		routinecomment.setOk(ok);
		routinecomment.setResult(result);
		routinecomment.setBacknews("");
		routinecomment.setNumber(number);
		response.sendRedirect("/trival/showroutine/showroutine.jsp"); 
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
