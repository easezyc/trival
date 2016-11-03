<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="myservlet.control.mybean.data.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
       
    <title>经典路线</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="http://localhost:8080/trival/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://localhost:8080/trival/bootstrap/jquery/jquery.min.js"></script>	
    <script src="http://localhost:8080/trival/bootstrap/js/bootstrap.min.js"></script>
	<script "text/javascript">
	$(document).ready(function(){
	$("img").wrap("<div></div>");
	$("img").parent().addClass('col-sm-6'); 
	});	
	</script>
	<style type="text/css">
	h1{
	text-align:center;
	font-size:30px;
	font-weight:bold;
	left: 50%;
	}
	p{
	font-size:20px;
	fonnt-weight:lighter ;
	text-indent: 2em;
	}
	img{
	height:100%;
	width:100%;
	border-radius: 20px; 
	}
	article>div{
	height:300px;
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
  	<div class="container" style="margin-top:100px;">
  	
    <%routinecomment routinecomment=(routinecomment)session.getAttribute("routinecomment");
    StringBuffer article=routinecomment.getArticle();
    out.print(article.toString());
    int number=routinecomment.getNumber();
    double score=routinecomment.getScore();
    request.setCharacterEncoding("utf-8");  
    %>
    </div>
    
    <div class="row">
    	<div class="col-sm-8 col-sm-offset-2" style="font-size:40px;">共计<%=number %>人评论，评分<%=score %></div>
    </div>
    <div class="row" style="margin-top:30px;">
     	<div class="col-sm-8 col-sm-offset-2">
     	<div>
     	<%String backnews=routinecomment.getBacknews();
     	out.println(backnews); %>
     	</div>
     	<%if(login!=null&&login.getSuccess()==true){ %>
     		<form action="/trival/servlet/HandleRoutineComment" method="post">
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
     			<div style="font-size:30px;font-weight:bold;">登陆后可评论</div>
    		<%} %>
				</div>
     	</div>
     	<div class="row" style="margin-top:20px;">
      	<div class="col-sm-8 col-sm-offset-2">
     <%boolean ok=routinecomment.getOk();
     String show="";
     int n=routinecomment.getNumber();
     StringBuffer result=routinecomment.getResult();
     StringBuffer newresult=new StringBuffer();
     int m=0;
     if(ok){
     for(int i=0;i<n;i++){
      %>
      <div style="margin-top:5px">
      	<span><%m=result.indexOf("#");
      	show=result.substring(0,m);
      	newresult.append(show+"#");
      	result.delete(0,m+1);
      	out.print(show+":");
      	 %></span>
      	<span><%m=result.indexOf("#");
      	show=result.substring(0,m);
      	newresult.append(show+"#");
      	result.delete(0,m+1);
      	out.print(show); %></span></br>
      	<span><%m=result.indexOf("#");
      	show=result.substring(0,m);
      	newresult.append(show+"#");
      	result.delete(0,m+1);
      	out.print(show); %></span>
      	</div>
      <%}
      routinecomment.setResult(newresult);
      }
       %>
      
     </div>
  </body>
</html>
