<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="myservlet.control.mybean.data.*" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>       
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="http://localhost:8080/trival/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://localhost:8080/trival/bootstrap/jquery/jquery.min.js"></script>	
    <script src="http://localhost:8080/trival/bootstrap/js/bootstrap.min.js"></script>
    <script "text/javascript">
    $(document).ready(function(){
  $("#photo1").hover(function(){
    $("#instroction1").fadeToggle(500);
  });
});
 $(document).ready(function(){
  $("#photo2").hover(function(){
    $("#instroction2").fadeToggle(500);
  });
});
 $(document).ready(function(){
  $("#photo3").hover(function(){
    $("#instroction3").fadeToggle(500);
  });
});
    </script>
	<style type="text/css">
	.firstpage-bg{
	height:aoto;
	min-height:700px;
	width:100%;
	position:relative;
	background-position:center center;
	background-size:cover;
	}
	#firstbackground{
	background-image:url("http://localhost:8080/trival/images/index1.jpg");
	}
	.title{
	margin-top:100px;
	width:100%;
	color:white;
	font-size:50px;
	text-align:center;
	font-weight:bolder;
	}
	.firstcenter{
	margin-top:100px;
	text-align:center;
	}
	.photo{
	width:200px;
	height:200px;
	position:relative;
	}
	.jiaozhu{
	background-color:black;
	height:100px;
	width:100%;
	position:relative;
	background-position:center center;
	background-size:cover;
	}
	.contactus{
	padding-top:30px;
	font-size:20px;
	color:#D9D919;
	}
	.phone{
	font-size:15px;
	color:#D9D919;
	}
	.text {
	width:200px;
	height:auto;
	background-color:#000;
	FILTER:alpha(opacity=60);
	opacity:0.7;
	-moz-opacity:0.7;
	position:absolute;
	left:0px;
	bottom:0px;
	}
	.imgtext {
	width:200px;
	height:auto;
	float:left;
	padding:5px;
	color:#fff;
	font-size:20px;
	line-height:200%;
	}
	.zzsc {
	width:200px;
	height:200px;
	margin:auto;
	position:relative;
	}
	.instroction{
	width:200px;
	height:200px;
	background-color:#000;
	opacity:0.5;
	-moz-opacity:0.5;
	position:absolute;
	left:0px;
	bottom:0px;
	}
	.instroctiontext{
	width:120px;
	height:120px;
	margin:30px;
	font-size:20px;
	color:white;
	font-weight:bolder;
	}
	</style>
  </head>
  
  <body>
  <%session.removeAttribute("show1");
  session.removeAttribute("show"); %>
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
  		<% ShowByPage showbean1=null;
   	 try{
			showbean1=(ShowByPage)session.getAttribute("show");
			if(showbean1!=null){
				session.removeAttribute("show");
			}
		}
		catch(Exception exp){
		}%>
	
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
	<div class="firstpage">
		<div class="firstpage-bg" id="firstbackground">
			<div class="container">
				<div class="title">
					自由行联盟欢迎您
				</div>
				<div class="firstcenter">
					<div class="row">
						<a href="http://localhost:8080/trival/searchscenicspot/searchscenicspot.jsp">
							<div class="col-sm-4">
							<div class="zzsc"  id="photo1">					
								<img src="http://localhost:8080/trival/images/index2.jpg" class="photo img-rounded" id="photo1">
								<div class="instroction" id="instroction1" style="display:none">
								<div class="instroctiontext">点击这里您可以搜索景点信息</div>
								</div>
								<div class="text">
									<div class="imgtext">搜索景点</div>
								</div>
								</div>								
							</div>							
						</a>
						<a href="/trival/searchroutine/searchroutineindex.jsp">
							<div class="col-sm-4">
								<div class=" zzsc" id="photo2">
								<img src="http://localhost:8080/trival/images/index3.jpg" class="photo img-rounded">
								<div class="instroction" id="instroction2" style="display:none">
								<div class="instroctiontext">点击这里您可以按照您的需求找到旅游路线</div>
								</div>
								<div class="text">
									<div class="imgtext">搜索路线</div>
								</div>
								</div>
							</div>
						</a>
						<a href="/trival/showroutine/routineindex.jsp">
							<div class="col-sm-4">
								<div class=" zzsc" id="photo3">
								<img src="http://localhost:8080/trival/images/index4.jpg" class="photo img-rounded">
								<div class="instroction" id="instroction3" style="display:none">
								<div class="instroctiontext">点击这里您可以查看一些经典的旅游路线</div>
								</div>
								<div class="text">
									<div class="imgtext">查看经典路线</div>
								</div>
								</div>
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="jiaozhu">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3">
			 		<div class="contactus">如果你对我们感兴趣，请联系我们。</div>
					<div class="phone">电话：17888842296</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	
  </body>
</html>
