<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="myservlet.control.mybean.data.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>查看路线</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="http://localhost:8080/trival/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://localhost:8080/trival/bootstrap/jquery/jquery.min.js"></script>	
    <script src="http://localhost:8080/trival/bootstrap/js/bootstrap.min.js"></script>
    <style type="text/css">
    .title{
    font-size:60px;
    font-weight:900;
    text-align:center;
    }
    .name{
    font-size:35px;
    font-weight:500;
    text-align:center;
    text-decoration:underline;
    }
    .introduce{
    font-size:20px;
    font-weight:300;
    text-indent:2em;
    }
    </style>
  </head>
  
  <body>
      <nav class="navbar-inverse navbar-fixed-top">
  	<div class="container">
  	<div class="row">
  		<div class="navbar-header">
  		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
  		<a class="navbar-brand" href="http://localhost:8080/trival/"><strong>首页</strong></a>
  		</div>
  		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
  		
	
  <% Login login=(Login)session.getAttribute("login");
  if(login!=null&&login.getSuccess()==true){ %>
    <ul class="nav navbar-nav">
    <li class="dropdown">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
      <%StringBuffer result=new StringBuffer();
      result.append(login.getName());
      out.print(result.toString());%> 
      <span class="caret"></span></a>
   	  <ul class="dropdown-menu">
      <li><a href="/trival/servlet/HandleLookinform">查看用户信息</a></li>
      <li><a href="/trival/account/inputModifyMess.jsp">修改用户信息</a></li>
      <li><a href="/trival/account/modifyPassword.jsp">修改密码</a></li>
      <li><a href="/trival/servlet/HandleExit?uri=<%=request.getRequestURI() %>">注销</a></li>
      </ul>
      </li>
      <li><a href="/trival/searchscenicspot/searchscenicspot.jsp">搜索景点</a></li>
  		<li><a href="/trival/searchroutine/searchroutineindex.jsp">搜索路线</a></li>
  		<li><a href="/trival/showroutine/routineindex.jsp">查看经典路线</a></li>
   </ul>
<%}
else{ %>  	 
  		<ul class="nav navbar-nav">
  		<li><a href="/trival/account/login.jsp?uri=<%=request.getServletPath()%>">登录</a></li>
  		<li><a href="/trival/searchscenicspot/searchscenicspot.jsp">搜索景点</a></li>
  		<li><a href="/trival/searchroutine/searchroutineindex.jsp">搜索路线</a></li>
  		<li><a href="/trival/showroutine/routineindex.jsp">查看经典路线</a></li>
  		</ul>
  		
  	<%} %>
  	</div>
  				</div>
			</div>

  	</nav>
  	
  	<%
  	ShowRoutine showroutine=(ShowRoutine)session.getAttribute("showroutine");
  	StringBuffer name=new StringBuffer(showroutine.getName());
  	StringBuffer introduce=new StringBuffer(showroutine.getIntroduce());
  	String show=new String();
  	String uri=new String();
  	StringBuffer photouri=new StringBuffer(showroutine.getPhotouri());
  	int n=0;
  	
  	 %>
  	<div class="container" style="margin-top:60px;">
  		<div class="title">
  		<%
  		n=name.indexOf("#");
    	show=name.substring(0,n);
    	name.delete(0,n+1);
    	out.print(show);
  		 %>
  		</div>
  		<div style="text-align:center;font-size:30px;">
  		共计<%out.print(showroutine.getPerson()); %>人评价，得分<%out.print(showroutine.getAverage()); %>
  		</div>
  		<%while((n=name.indexOf("#"))>=0){ %>
  		
  			<%
  			uri=name.substring(0,n);
    		name.delete(0,n+1);
  			 %>
  			<div class="name"><a href="/trival/servlet/HandleShowscenicspot?name=<%=uri %>" style="color:black;"><%out.print(uri); %></a></div>
  			<div class="introduce">
  			<%
  			n=introduce.indexOf("#");
    		show=introduce.substring(0,n);
    		introduce.delete(0,n+1);
    		out.print(show);
  			 %>
  			</div>
  			<div class="row">
  			<%
  			n=photouri.indexOf("#");
    		show=photouri.substring(0,n);
    		photouri.delete(0,n+1);
    		if(show.equals("天津")||show.equals("北京")){
    		show="京津";
    		}
  			 %>
  				<div class="col-sm-4 col-sm-offset-2" style="weight:400px;height:300px;"><img width="100%" height="100%" class="img-rounded" src="http://localhost:8080/trival/images2/<%=show %>/<%=uri %>1.jpg"/></div>
  				<div class="col-sm-4" style="weight:400px;height:300px;"><img width="100%" height="100%" class="img-rounded" src="http://localhost:8080/trival/images2/<%=show %>/<%=uri %>2.jpg"/></div>
  			</div>
  		
  		<%} %>
  		<%if(showroutine.getOk()==false){ %>
  		<div><%out.print(showroutine.getBacknews()); %></div>
  		<%} %>
  		<%if(login!=null&&login.getSuccess()==true){ %>
     		<form action="/trival/servlet/HandleRoutineComment1?city=<%=showroutine.getCity() %>&tablenumber=<%=showroutine.getTablenumber() %>&number<%=showroutine.getNumber() %>" method="post" style="margin-top:30px;">
     			<div class="form-group">
     					<select class="form-control" name="score"> 
      					<option value="" selected>为该路线打分</option> 
      					<option value="1">1分</option> 
      					<option value="2">2分</option> 
      					<option value="3">3分</option> 
      					<option value="4">4分</option>
      					<option value="5">5分</option>  
      					</select>
	     				<textarea class="form-control" placeholder="请输入您的评论" rows="5" name="comment"></textarea>
	     				<div class="input-group-btn">
	  						<button type="submit" type="button" class="btn btn-default"  id="ok">提交</button>
	  					</div>
	  					
     			</div>
     		</form>
     		<%} else {%>
     			<div style="font-size:30px;">登陆后可评论</div>
    		<%} %>
    		<%StringBuffer result=new StringBuffer(showroutine.getResult());
    		for(int i=0;i<showroutine.getN();i++){ %>
    			<div style="margin-top:5px">
      		<span><%int m=result.indexOf("#");
      		show=result.substring(0,m);
      		result.delete(0,m+1);
      		out.print(show+":");
      	 	%></span>
      		<span><%m=result.indexOf("#");
      		show=result.substring(0,m);
      		result.delete(0,m+1);
      		out.print(show); %></span></br>
      		<span><%m=result.indexOf("#");
      		show=result.substring(0,m);
      		result.delete(0,m+1);
      		out.print(show); %></span>
      		</div>
    		
    		<%} %>
			
			
  	</div>
  </body>
</html>
