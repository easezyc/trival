<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="myservlet.control.mybean.data.Password" %>
<jsp:useBean id="password" type="myservlet.control.mybean.data.Password" scope="request"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改密码</title>
	<meta http-equiv="refresh" content="3;url=http://localhost:8080/trival/index.jsp" />
	<link href="http://localhost:8080/trival/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://localhost:8080/trival/jquery/jquery-2.0.0.min.js"></script>
    <script src="http://localhost:8080/trival/bootstrap/js/bootstrap.min.js"></script>
  </head>
  
  <body>
	<center>
	<br><jsp:getProperty name="password" property="backnews"/>
	</center>
  </body>
</html>
