<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link href="http://localhost:8080/trival/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://localhost:8080/trival/bootstrap/jquery/jquery.min.js"></script>
    <script src="http://localhost:8080/trival/bootstrap/js/bootstrap.min.js"></script>
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	 <style type="text/css">
	
	 .loginbox {
            width: 100%;
            max-width: 500px;
            height:200px;
            position: absolute;
            top: 50%;
            margin-top: -150px;
            padding: 20px 20px 20px 20px;            
            /*设置负值，为要定位子盒子的一半高度*/
        }
	 @media screen and (min-width:500px) {
            .loginbox {
                left: 50%;
                /*设置负值，为要定位子盒子的一半宽度*/
                margin-left: -250px;
            }
        }	
    .firstpage{
    height:625px;
    width:100%;
    position:absolute;
    background-position:center center;
	background-size:cover;
    }
    #firstpagephoto{
    background-image:url("http://localhost:8080/trival/images/register.jpg");
    }
	</style>
	
  </head>
  
  <body>
  <%
  	 String uri=request.getParameter("uri");
     String logname = "";
     String password= "";
	int y=0;
    Cookie[] cookies = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {
         if ("logname".equals(cookies[i].getName())) {
            logname = cookies[i].getValue();y++;
         } else if ("password".equals(cookies[i].getName())) {
             password = cookies[i].getValue();y++;
        }
        }
 %>

  <div class="firstpage" id="firstpagephoto">
		<div class="container">
  			<div class="loginbox panel panel-default">
  			<%if(uri.equals("/trival/servlet/HandleShowscenicspot")){ %>
  			<form action="/trival/servlet/HandleLogin?uri=/servlet/HandleShowscenicspot&name=<%=request.getParameter("name") %>" method="post">
  			<%} else {%>
   				<form action="/trival/servlet/HandleLogin?uri=<%=uri %>" method="post">
   				<%} %>
     				 <div class="input-group">
         			<span class="input-group-addon">昵称</span>
         			<%if(y==2){%>
         			<input id="phone" type="text" class="form-control" name="logname"   value="<%=logname %>" ></div></br>
         			<%}else {%>
         			<input id="phone" type="text" class="form-control" name="logname"   placeholder="请输入昵称"></div></br>
         			<%} %>
         			<div class="input-group">
         				<span class="input-group-addon">密码</span>
         				<input id="password" type="password" class="form-control" name="password" <%if(y==2){%> value="<%=password%>"<%}else { %> placeholder="请输入密码"<%} %> >
      				</div>
      					<br>
					<div class="btn-group btn-group-sm">
					 	<input type="checkbox" name="isLogin" checked="checked" >自动登录<br/> 
  						<button id="ok" type="submit" type="button" class="btn btn-default">登录</button>
  						<a type="botton" class="btn btn-default" href="/trival/account/register.jsp">注册</a>
  					</div>
 				</form>
 			</div>
 		</div>
 </div>

  </body>
</html>
