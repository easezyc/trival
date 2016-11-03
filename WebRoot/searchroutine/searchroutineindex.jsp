<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="myservlet.control.mybean.data.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>搜索路线</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="http://localhost:8080/trival/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://localhost:8080/trival/bootstrap/jquery/jquery.min.js"></script>	
    <script src="http://localhost:8080/trival/bootstrap/js/bootstrap.min.js"></script>
    <style type="text/css">
    .introduce{
	font-size:15px;
	color:#888888;
	}
	.sheng{
	font-size:20px;
	color:black;
	font-weight:20;
	}
	.cityname{
	font-size:30px;
	color:black;
	font-weight:bold;
	text-decoration: underline;
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
  	   	ShowByPage2 showbean=(ShowByPage2)session.getAttribute("show1");
  		if(showbean==null){
  	%>
  	<div class="container">
  		<div style="margin-top:100px;text-align:center;font-size:80px;color:black;font-weight:bold;">自由行联盟</div>
  		<div style="text-align:center;font-size:40px;color:black;">搜索路线</div>
  		<form class="bs-example bs-example-form" method="post" action="/trival/servlet/HandleSearchroutine">
  		<div class="row">
  			<div class="col-sm-8 col-sm-offset-2">
  				<div class="input-group">
  					<input type="text" class="form-control" name="shi" placeholder="请输入城市名字*此项可不填">
  					<div class="input-group-btn">
  						<button type="submit" type="button" class="btn btn-default"  id="ok">搜索</button>
  					</div>
  				</div>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-4">
  				<div style="font-size:20px;">
  				
  				<span>选择省份</span>
  				<span>此项可不填</span>
  				</div>
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
  			<div class="col-sm-4">
  				<div style="font-size:20px;">
  					<span>选择几日游</span>
  					<span style="color:red;">此项必选</span>
  				</div>
  				<select class="form-control" name="time"> 
      					<option value="" selected>选择几日游</option>
      					<option value="1">一日游</option>
      					<option value="2">两到三日游</option>
      					<option value="3">四到六日游</option>
      			</select>
  			</div>
  			<div class="col-sm-4">
  				<div style="font-size:20px;">
  					<span>选择旅游几个城市</span>
  					<span style="color:red;">此项必选</span>
  				</div>
  				<select class="form-control" name="city"> 
      					<option value="" selected>选择旅游几个城市</option>
      					<option value="1">一个城市</option>
      					<option value="2">两个城市</option>
      					<option value="3">三个城市</option>
      			</select>
  			</div>
  		</div>
  	</form>
  	</div>
  	
  	<%
  		}
  		else{
  	 %>
  	
  
  	<div class="container">
  		<div style="margin-top:60px;font-size:30px;color:black;font-weight:bold;">搜索路线</div>
  		<form class="bs-example bs-example-form"  method="post" action="/trival/servlet/HandleSearchroutine">
  		<div class="row">
  			<div class="col-sm-6">
  				<div class="input-group">
  					<input type="text" class="form-control" name="shi" placeholder="请输入城市名字*此项可不填">
  					<div class="input-group-btn">
  						<button type="submit" type="button" class="btn btn-default"  id="ok">搜索</button>
  					</div>
  				</div>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-sm-3">
  				<div style="font-size:20px;">
  				
  				<span>选择省份</span>
  				<span>此项可不填</span>
  				</div>
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
      			</select>
  			</div>
  			<div class="col-sm-3">
  				<div style="font-size:20px;">
  					<span>选择几日游</span>
  					<span style="color:red;">此项必选</span>
  				</div>
  				<select class="form-control" name="time"> 
      					<option value="" selected>选择几日游</option>
      					<option value="1">一日游</option>
      					<option value="2">二到三日游</option>
      					<option value="3">四到六日游</option>
      			</select>
  			</div>
  			<div class="col-sm-3">
  				<div style="font-size:20px;">
  					<span>选择旅游几个城市</span>
  					<span style="color:red;">此项必选</span>
  				</div>
  				<select class="form-control" name="city"> 
      					<option value="" selected>选择旅游几个城市</option>
      					<option value="1">一个城市</option>
      					<option value="2">两个城市</option>
      					<option value="3">三个城市</option>
      			</select>
      			
  			</div>
  		</div>
  	</form><br>
  	
  	
	<%
		Boolean ok=showbean.getSuc();
  		if(ok==false){
  		String backnews=showbean.getBacknews();
  		out.println(backnews);
  		}
  		else {
  		StringBuffer name=new StringBuffer(showbean.getName().toString());
  		StringBuffer introduce=new StringBuffer(showbean.getIntroduce().toString());
  		StringBuffer timemark=new StringBuffer(showbean.getTimemark().toString());
  		String city=showbean.getCity();
  		String time=showbean.getTime();
  		String timename="";
  		String show="";
  		int n=0;
  		int citynumber=0;
  		int number=showbean.getNowpage();
  		if(time.equals("1")){timename="一日游";}
  		else if(time.equals("2")){timename="两到三日游";}
  		else if(time.equals("3")){timename="四到六日游";}
  		if(city.equals("1")){citynumber=1;}
  		else if(city.equals("2")){citynumber=2;}
  		else if(city.equals("3")){citynumber=3;}
  		String name1="",name2="",name3="",timemark1="",timemark2="",timemark3="";
  		for(int j=0;j<number;j++){
  		if(city.equals("1")){
		n=name.indexOf("#");
    	name1=name.substring(0,n);
    	name.delete(0,n+1);
  		%>
  		<a href="/trival/servlet/HandleShowroutine1?name1=<%=name1 %>" class="cityname">
	<%		
    	out.print(name1);
				
		out.print(timename);
		n=name.indexOf("#");
    	show=name.substring(0,n);
    	name.delete(0,n+1);
		%>
		</a>
		<div>得分<%out.print(show); %></div>
		<%}if(city.equals("2")){			
			n=name.indexOf("#");
    		name1=name.substring(0,n);
    		name.delete(0,n+1);
    		n=name.indexOf("#");
    		name2=name.substring(0,n);
    		name.delete(0,n+1);
    		n=timemark.indexOf("#");
    		timemark1=timemark.substring(0,n);
    		timemark.delete(0,n+1);
    		n=timemark.indexOf("#");
    		timemark2=timemark.substring(0,n);
    		timemark.delete(0,n+1);
    	 %>
    	<a href="/trival/servlet/HandleShowroutine1?name1=<%=name1 %>&name2=<%=name2 %>&timemark1=<%=timemark1 %>&timemark2=<%=timemark2 %>" class="cityname">
    	<%
    	out.print(name1+name2);		
		out.print(timename);
		n=name.indexOf("#");
    	show=name.substring(0,n);
    	name.delete(0,n+1);
		%>
    	</a>
    	<div>得分<%out.print(show); %></div>
    	<%}
    		if(city.equals("3")){
			n=name.indexOf("#");
    		name1=name.substring(0,n);
    		name.delete(0,n+1);
    		n=name.indexOf("#");
    		name2=name.substring(0,n);
    		name.delete(0,n+1);
    		n=name.indexOf("#");
    		name3=name.substring(0,n);
    		name.delete(0,n+1);
    		n=timemark.indexOf("#");
    		timemark1=timemark.substring(0,n);
    		timemark.delete(0,n+1);
    		n=timemark.indexOf("#");
    		timemark2=timemark.substring(0,n);
    		timemark.delete(0,n+1);
    		n=timemark.indexOf("#");
    		timemark3=timemark.substring(0,n);
    		timemark.delete(0,n+1);
    	 %>
    	 <a href="/trival/servlet/HandleShowroutine1?name1=<%=name1 %>&name2=<%=name2 %>&name3=<%=name3 %>&timemark1=<%=timemark1 %>&timemark2=<%=timemark2 %>&timemark3=<%=timemark3 %>" class="cityname">
    	 <%
    	 out.print(name1+name2+name3);		
		out.print(timename);
		n=name.indexOf("#");
    	show=name.substring(0,n);
    	name.delete(0,n+1);
    	  %>
    	 </a>
    	 <div>得分<%out.print(show); %></div>
    	 <%} %>
    	 
		<div>
			<%
				for(int k=0;k<citynumber;k++)
				{
			 %>
			 		<span class="sheng"><% 
			 		n=introduce.indexOf("#");
    				show=introduce.substring(0,n);
    				introduce.delete(0,n+1);
    				out.print(show);
			 		%></span>
			 		<span class="shi"><%
			 		n=introduce.indexOf("#");
    				show=introduce.substring(0,n);
    				introduce.delete(0,n+1);
    				out.print(show);
			 		 %></span>
			 		<div class="introduce"><%
			 		n=introduce.indexOf("#");
    				show=introduce.substring(0,n);
    				introduce.delete(0,n+1);
    				out.print(show);
			 		 %></div>
			 <% } %>
		</div>
  		<%
  			}
   		}%>
   		
   		</div>
   		<%
  		} %>
  		<%if(showbean!=null&&showbean.getSuc()){
  int pageallcount=showbean.getPageallcount();
  	int showpage=showbean.getShowpage(); %>	 
  <br>
  <div class="row">
  <div class="col-sm-8 col-sm-offset-2">
  <div style="color:black;">总页数：<%=pageallcount %>页</div>
  <ul class="pagination">
  <%if(showpage!=1){ %>
    <li>
      <a href="/trival/servlet/HandleShowByPage2?showpage=<%=(showpage-1)%>" aria-label="Previous">
        <span aria-hidden="true">上一页</span>
      </a>
    </li>
    <%}
    int j=(showpage+3<pageallcount)?showpage+3:pageallcount;
    for(int i=(showpage-3>1)?showpage-3:1;i<=j;i++){
    if(i==showpage){%>
    <li class="active"><a href="/trival/servlet/HandleShowByPage2?showpage=<%=showpage%>"><%=i %></a></li>
    <%} 
    else{%>
    <li><a href="/trival/servlet/HandleShowByPage2?showpage=<%=i%>"><%=i %></a></li>
    <%} %>
    <%} %>
    <%if(showpage!=pageallcount){ %>
    <li>
      <a href="/trival/servlet/HandleShowByPage2?showpage=<%=(showpage+1)%>" aria-label="Next">
        <span aria-hidden="true">下一页</span>
      </a>
    </li>
    <%} %>

    <li>
			<form class="bs-example bs-example-form" action="/trival/servlet/HandleShowByPage2" method="post" role="form">
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
  </body>
</html>
