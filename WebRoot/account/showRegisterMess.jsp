<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html"%>
<%@page import="myservlet.control.mybean.data.Register" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>注册</title>
    <link href="http://localhost:8080/trival/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://localhost:8080/trival/jquery/jquery-2.0.0.min.js"></script>
    <script src="http://localhost:8080/trival/bootstrap/js/bootstrap.min.js"></script>
	<meta http-equiv="refresh" content="3;url=http://localhost:8080/trival/index.jsp" />
  </head>
  <body>
  <jsp:useBean id="register" type="myservlet.control.mybean.data.Register" scope="request"/>
  	<center style="padding:200px">
  		<font size=4 color=blue>
  			<br><jsp:getProperty name="register" property="backnews"/>
  		</font>
  		<%if(register.getBacknews().equals("注册成功")){ %>
  		<table>
  			<tr><td>昵称:</td>
  			<td><jsp:getProperty name="register" property="name"/>
  			</td></tr>
  			<tr><td>密码:</td>
  			<td><jsp:getProperty name="register" property="password"/></td>
  			</tr>
  			<tr><td>手机号:</td>
  			<td><jsp:getProperty name="register" property="phone"/></td>
  			</tr>
  			<tr><td>邮箱号:</td>
  			<td><jsp:getProperty name="register" property="mail"/></td>
  			</tr>
  		</table>
  		<%} %>
  	</center>
   
  </body>
</html>
