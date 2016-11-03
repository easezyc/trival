<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="myservlet.control.mybean.data.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>查看景点</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="http://localhost:8080/trival/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://localhost:8080/trival/bootstrap/jquery/jquery.min.js"></script>	
    <script src="http://localhost:8080/trival/bootstrap/js/bootstrap.min.js"></script>
    <style type="text/css">
    .name{
    text-align:center;
    font-size:60px;
    font-color:black;
    font-weight:bold;
    }
    .introduction{
    font-size:20px;
    font-color:black;
    text-indent: 2em;
    }
    </style>
  </head>
  
  <body>
  <%
  request.setCharacterEncoding("utf-8");
    Comment comment=(Comment)session.getAttribute("comment");
    String name=comment.getName();
    String province=comment.getProvince();
    String introduction=comment.getIntroduction();
    %>
  <div class="container">
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
      <li><a href="/trival/servlet/HandleExit?uri=/trival/searchscenicspot/searchscenicspot.jsp">注销</a></li>
      </ul>
      </li>
      <li><a href="/trival/searchscenicspot/searchscenicspot.jsp">搜索景点</a></li>
  		<li><a href="/trival/searchroutine/searchroutineindex.jsp">搜索路线</a></li>
  		<li><a href="/trival/showroutine/routineindex.jsp">查看经典路线</a></li>
   </ul>
<%}
else{ %>  	 
  		<ul class="nav navbar-nav">
  		<li><a href="/trival/account/login.jsp?uri=/trival/servlet/HandleShowscenicspot&name=<%=name %>">登录</a></li>
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
     StringBuffer result=new StringBuffer();
     result=comment.getResult();
     String show="";
     
     int n=comment.getNumber();
     int m=0;
     double score=comment.getScore();
     %>
    <div class="row" style="margin-top:150px;">
    	<div class="col-sm-8 col-sm-offset-2">
    		<p class="name">
    <%
    out.print(name);
     %>
     		<p>
     		<div class="introduction">
     <%
    out.print(introduction);
     %>
     		</div>
     		</br>
     		<div style="text-align:center;font-size:20px;">共记<%=n %>人点评，景点得分为<%=score %></div>
     	</div>
     </div>
     <% String image1,image2;
     if(province.equals("北京")||province.equals("天津")){
     province="京津";
     image1="http://localhost:8080/trival/images2/"+province+"/"+name+"1.jpg";
     image2="http://localhost:8080/trival/images2/"+province+"/"+name+"2.jpg";
     }
     else {
     image1="http://localhost:8080/trival/images2/"+province+"/"+name+"1.jpg";
     image2="http://localhost:8080/trival/images2/"+province+"/"+name+"2.jpg";
     }
     %>
     <div class="row">
     <div style="weight:400px;height:300px;" class="col-sm-4 col-sm-offset-2"><img class="img-rounded" src="<%=image1 %>" width="100%" height="100%"/></div>
     <div style="weight:400px;height:300px;" class="col-sm-4"><img class="img-rounded" src="<%=image2 %>" width="100%" height="100%"/></div>
     </div>
     
        <div class="row" style="margin-top:30px;">
     	<div class="col-sm-8 col-sm-offset-2">
     	 <div>
     	<%String backnews=comment.getBacknews();
     	out.println(backnews); %>
     	</div>
     	<%if(login!=null&&login.getSuccess()==true){ %>
     		<form action="/trival/servlet/HandleComment?name=<%=name %>" method="post">
     			<div class="form-group">
     					<select class="form-control" name="score"> 
      					<option value="" selected>为该景点打分</option> 
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
				</div>
     	</div>
     </div>
     <div class="row" style="margin-top:20px;">
      	<div class="col-sm-8 col-sm-offset-2">
     <%boolean ok=comment.getOk();
     StringBuffer newresult=new StringBuffer();
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
      comment.setResult(newresult);
      }
       %>
      </div>
      </div>
      
     
     
  </body>
</html>
