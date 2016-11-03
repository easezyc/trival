<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="myservlet.control.mybean.data.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>搜索景点</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="http://localhost:8080/trival/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://localhost:8080/trival/bootstrap/jquery/jquery.min.js"></script>	
    <script src="http://localhost:8080/trival/bootstrap/js/bootstrap.min.js"></script>
	<style type="text/css">
	#p1{
	font-size:60px;
	color:black;
	text-align:center;
	font-weight:bolder;
	}
	#p2{
	font-size:30px;
	color:black;
	text-align:center;
	font-weight:bold;
	}
	.name{
	font-size:30px;
	color:black;
	font-weight:bold;
	text-decoration: underline;
	}
	.introduction{
	font-size:15px;
	color:#888888;
	}
	</style>
	
  </head>
  
  <body>
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
  		<a class="navbar-brand" href="http://localhost:8080/trival/" class="return" id="w"><strong>首页</strong></a>
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
      <li><a href="/trival/searchscenicspot/searchscenicspot.jsp" class="return">搜索景点</a></li>
  		<li><a href="/trival/searchroutine/searchroutineindex.jsp" class="return">搜索路线</a></li>
  		<li><a href="/trival/showroutine/routineindex.jsp" class="return">查看经典路线</a></li>
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
  	   ShowByPage showbean=(ShowByPage)session.getAttribute("show");
  		if(showbean==null){
  	 %>
		<div class="row" style="margin-top:100px;margin-bottom:50px;">
			<div class="col-sm-4 col-sm-offset-4">
				<p id="p1">自由行联盟</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4 col-sm-offset-4">
				<p id="p2">搜索景点</p>
			</div>
		</div>
  		
  			<form action="/trival/servlet/HandleScenicspot"  method="post"  class="bs-example bs-example-form" role="form">
  			<div class="row" >
  			<div class="col-sm-6 col-sm-offset-3">
  				<div class="input-group">
  					<input type="text" class="form-control" name="scenicspotname">
  					<div class="input-group-btn">
  						<button type="submit" type="button" class="btn btn-default"  id="ok">搜索</button>
  					</div>
  				</div></br>
  				</div>
  		</div>
  		<div class="row">
  				<div class="col-sm-3 col-sm-offset-3">		
  				<select class="form-control" name="sheng"> 
      					<option value="" selected>选择省或直辖市</option> 
      					<option value="河北">河北</option> 
      					<option value="河南">河南</option> 
      					<option value="湖北">湖北</option> 
      					<option value="辽宁">辽宁</option>
      					<option value="北京">北京</option> 
      					<option value="天津">天津</option> 
      					<option value="上海">上海</option> 
      					<option value="山东">山东</option>
      					<option value="山西">山西</option>   
      					<option value="内蒙古">内蒙古</option>
      					<option value="黑龙江">黑龙江</option>
      					<option value="吉林">吉林</option>
      					<option value="浙江">浙江</option>
      					<option value="安徽">安徽</option>  
      					<option value="江苏">江苏</option>  
      			</select>
      			</div>
      	</div>
			</form>
			
  			
  	<%}
  	else { %>
  	<div class="row"  style="margin-top:100px;">
			<div class="col-sm-4 col-sm-offset-2">
				<p id="p2">搜索景点</p>
			</div>
	</div>
  	<div class="row"">
  			<div class="col-sm-6 col-sm-offset-1">
  			<form action="/trival/servlet/HandleScenicspot"  method="post"  class="bs-example bs-example-form" role="form">
  				<div class="input-group">
  					<input type="text" class="form-control" name="scenicspotname">
  					<div class="input-group-btn">
  						<button type="submit" type="button" class="btn btn-default"  id="ok">搜索</button>
  					</div>  					
  				</div>
  				</br>
  	<div class="row">
  			<div class="col-sm-4">
  				<select  class="form-control" name="sheng"> 
      					<option value="" selected>选择省或直辖市</option> 
      					<option value="河北">河北</option> 
      					<option value="河南">河南</option> 
      					<option value="湖北">湖北</option> 
      					<option value="辽宁">辽宁</option>
      					<option value="北京">北京</option> 
      					<option value="天津">天津</option> 
      					<option value="上海">上海</option> 
      					<option value="山东">山东</option>
      					<option value="山西">山西</option>
      					<option value="内蒙古">内蒙古</option>
      					<option value="黑龙江">黑龙江</option>
      					<option value="吉林">吉林</option>
      					<option value="浙江">浙江</option>
      					<option value="安徽">安徽</option>   
      				</select>
      		</div>
      </div>
			</form>
  			</div>
  			
  		</div>
  	<% if(showbean!=null&&showbean.getSuc()){ %>
	<div class="row">
		<div class="col-sm-10">
    <%
    	StringBuffer result=new StringBuffer(showbean.getPresentpageresult().toString());
    	int n=0;
    	String show=new String();
    	int number=showbean.getNowpage();
    	for(int i=0;i<number;i++){
    	n=result.indexOf("#");
    	show=result.substring(0,n);
    	result.delete(0,n+1);
    	%>
    	<a href="/trival/servlet/HandleShowscenicspot?name=<%=show %>">
    		<div class="name">
    	<% 
    	out.print(show);
    	n=result.indexOf("#");    	
    	show=result.substring(0,n);
    	result.delete(0,n+1); 	
    	%>
    		</div>
    	</a>
    	<span style="font-size:20px;color:black;font-weight:20;"><% out.print(show);
    	n=result.indexOf("#");    	
    	show=result.substring(0,n);
    	result.delete(0,n+1);  %></span>
    	<span><%out.print(show); %></span>
    	<%
    	n=result.indexOf("#");
    	show=result.substring(0,n);
    	result.delete(0,n+1);
    	%>
    		<div class="introduction">
    	<%
    	out.print(show);
    	}    	
     %>
     		</div>
    	</div>
	</div>
    <% }
    else { 
		String result=showbean.getBacknews();
		out.print(result.toString());
      } %>
  	<%}
  	
  	 %>
  <%if(showbean!=null&&showbean.getSuc()){
  int pageallcount=showbean.getPageallcount();
  	int showpage=showbean.getShowpage(); %>	 
  </br>
  <div class="row">
  <div class="col-sm-8 col-sm-offset-2">
  <div style="color:black;">总页数：<%=pageallcount %>页</div>
  <ul class="pagination">
  <%if(showpage!=1){ %>
    <li>
      <a href="/trival/servlet/HandleShowByPage?showpage=<%=(showpage-1)%>" aria-label="Previous">
        <span aria-hidden="true">上一页</span>
      </a>
    </li>
    <%}
    int j=(showpage+3<pageallcount)?showpage+3:pageallcount;
    for(int i=(showpage-3>1)?showpage-3:1;i<=j;i++){
    if(i==showpage){%>
    <li class="active"><a href="/trival/servlet/HandleShowByPage?showpage=<%=showpage%>"><%=i %></a></li>
    <%} 
    else{%>
    <li><a href="/trival/servlet/HandleShowByPage?showpage=<%=i%>"><%=i %></a></li>
    <%} %>
    <%} %>
    <%if(showpage!=pageallcount){ %>
    <li>
      <a href="/trival/servlet/HandleShowByPage?showpage=<%=(showpage+1)%>" aria-label="Next">
        <span aria-hidden="true">下一页</span>
      </a>
    </li>
    <%} %>

    <li>
			<form class="bs-example bs-example-form" action="/trival/servlet/HandleShowByPage" method="post" role="form">
    			<div class="input-group">
					<input type="text" class="form-control" name="showpage" placeholder="请输入页码">
					<div class="input-group-btn">
						<button type="submit" class="btn btn-default" type="button" id="ok">跳转</button>
					</div>
				</div>
			</form>		
	</li>
  </ul>
  </div>
  </div>
<%} %>

  			
	</div>
	
  </body>
</html>
