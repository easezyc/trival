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
    .hid{
    height:194px;
    width:194px;
    position:absolute;
    background-color:black;
    left:0px;
    bottom:0px;
    border-radius:12px;
    opacity:0;
    transition: 1s;
    color:white;
    font-size:20px;
    text-align:center;
    }
    .hid:hover{
    opacity:0.7;
    }
    .zzsc {
	width:200px;
	height:200px;
	margin:auto;
	border: 3px solid #dedede;
	border-radius:15px;	
	position:relative;
	}	
	.cityname{
	font-size:50px;
	}
	.cityinstruction{
	font-size:18px;
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
  	Searchroutine searchroutine=(Searchroutine)session.getAttribute("searchroutine");
  	StringBuffer name=new StringBuffer(searchroutine.getName().toString());
  	StringBuffer introduce=new StringBuffer(searchroutine.getIntroduce().toString());
  	StringBuffer routine=new StringBuffer(searchroutine.getRoutine().toString());
  	StringBuffer routineshow=new StringBuffer();
  	int n=0;
  	String name1=new String();
  	String show=new String();
  	StringBuffer routinenumber=new StringBuffer(searchroutine.getRoutinenumber());
  	int m=0,m2=0,count=0;
  	String z;
  	int city= Integer.parseInt(searchroutine.getCity());
  	StringBuffer tablenumber=new StringBuffer(searchroutine.getTablenumber());
  	StringBuffer day=new StringBuffer(searchroutine.getDay());
  	
  	 %>
  	<div class="container" style="margin-top:60px;">
  		<% for(int i=0;i<city;i++){%>
  			<div style="text-align:center;" class="cityname">
  				<% n=name.indexOf("#");
    			name1=name.substring(0,n);
    			name.delete(0,n+1);
    			out.print(name1);
    			n=day.indexOf("#");
    			show=day.substring(0,n);
    			day.delete(0,n+1);
    			out.print(show);
    			n=tablenumber.indexOf("#");
    			z=tablenumber.substring(0,n);
    			tablenumber.delete(0,n+1);
    			
    			n=routinenumber.indexOf("#");
    			m= Integer.parseInt(routinenumber.substring(0,n));
    			m2=12/m;
    			routinenumber.delete(0,n+1);%>
  			</div>
  		<div class="row">
  			<div class="col-sm-12 cityinstruction">
  				<% n=introduce.indexOf("#");
    			show=introduce.substring(0,n);
    			introduce.delete(0,n+1);
    			out.print(show);%>
  			</div>
  		</div>
  		<br>
  		<div class="row">
  				<%				
  					n=routine.indexOf("!");
  					StringBuffer troutine=new StringBuffer(routine.substring(0,n));
  					routine.delete(0,n+1);
  					count=0;
  					while((n=troutine.indexOf("*"))>=0)
  					{
  					count++;					
    				show=troutine.substring(0,n);
    				troutine.delete(0,n+1);
    				routineshow.append(show);
  					n=routineshow.indexOf("#");
    				show=routineshow.substring(0,n);
    				routineshow.delete(0,n+1);
    				if(m2<3){m2=3;}
  				%>
  				<div class="col-sm-<%=m2 %>">
  					<a href="/trival/servlet/HandleShowroutine2?number=<%=show%>&name=<%=name1 %>&tablenumber=<%=z%>">
  						<div class="zzsc">
  							<div class="hid"><div style="margin-top:80px;">点击查看路线</div></div>
  							<div class="zzsc3">
  							<div style="font-size:17px;color:black;text-align:center;position:relative;">
  							<%
  							out.print("路线"+count);
  							 %>
  							</div>
  								<div style="font-size:15px;color:black;margin:5px;">					 			
  										<%
  										n=routineshow.indexOf("#");
  										show=routineshow.substring(0,n);
    										routineshow.delete(0,n+1);
    										%>
    									<div style="color:red;">该路线得分：<%out.println(show);%></div>
    										<%
  										while((n=routineshow.indexOf("#"))>=0)
    										{show=routineshow.substring(0,n);
    										routineshow.delete(0,n+1);
    										%>
    									<div>	
    									<%
    									out.println(show);
  										 %> 									
  										</div>
  									<%} %>
  								</div>
  					  		</div>
  						</div>	
  					</a>		 	
  				</div>
  				<%} %> 				
  				
  		</div>
  		<%} %>
  	</div>
  </body>
</html>
