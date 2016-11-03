<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="myservlet.control.mybean.data.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="http://localhost:8080/trival/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://localhost:8080/trival/bootstrap/jquery/jquery.min.js"></script>	
    <script src="http://localhost:8080/trival/bootstrap/js/bootstrap.min.js"></script>  
    <title>查看路线</title>
	<style type="text/css">
	.col-sm-4{
	border:1px solid;
	border-radius:25px;
	font-size:25px;
	font-weight:40px;
	}
	.name>a{
	font-size:15px;
	font-weight:20px;
	color:black;
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
    <div class="container" style="margin-top:50px;">
    <div style="text-align:center;font-size:80px;font-weight:300;">经典路线</div>
    	<div class="row">
    		<div class="col-sm-4">
    			<div style="text-align:center;">北京</div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=北京/1.txt">北京七日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=北京/2.txt">古都专线一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=北京/3.txt">精品线路两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=北京/4.txt">文化一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=北京/5.txt">京津五日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=北京/6.txt">北京两日游</a></div>
    		</div>
    		
    		<div class="col-sm-4">
    			<div style="text-align:center;">河北</div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=河北/1.txt">秦皇岛一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=河北/2.txt">张家口三日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=河北/3.txt">承德两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=河北/4.txt">唐山清东陵两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=河北/5.txt">保定两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=河北/6.txt">沕沕水生态风景区一日游</a></div>
    		</div>
    		<div class="col-sm-4">
    			<div style="text-align:center;">河南</div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=河南/1.txt">少林寺龙门石窟一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=河南/2.txt">郑州两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=河南/3.txt">新乡八里沟一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=河南/4.txt">洛阳伏牛山滑雪一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=河南/5.txt">安阳一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=河南/6.txt">开封一日游</a></div>
    		</div>
    		<div class="col-sm-4">
    			<div style="text-align:center;">山东</div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=山东/1.txt">济南两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=山东/2.txt">济南泰安三日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=山东/3.txt">胶东半岛四日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=山东/4.txt">临沂两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=山东/5.txt">青岛两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=山东/6.txt">淄博枣庄两日游</a></div>
    		</div>
    		<div class="col-sm-4">
    			<div style="text-align:center;">山西</div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=山西/1.txt">云冈石窟恒山两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=山西/2.txt">太原两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=山西/3.txt">晋中两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=山西/4.txt">临汾两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=山西/5.txt">运城一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=山西/6.txt">太原到五台山两日游</a></div>
    		</div>
    		<div class="col-sm-4">
    			<div style="text-align:center;">湖北</div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=湖北/1.txt">恩施大峡谷、腾龙洞、土司城两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=湖北/2.txt">武汉两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=湖北/3.txt">神农架两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=湖北/4.txt">宜昌两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=湖北/5.txt">武汉市区两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=湖北/6.txt">丹江口两日游</a></div>
    		</div>
    		<div class="col-sm-4">
    			<div style="text-align:center;">辽宁</div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=辽宁/1.txt">沈阳滑雪一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=辽宁/2.txt">沈阳市区一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=辽宁/3.txt">大连一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=辽宁/4.txt">葫芦岛两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=辽宁/5.txt">丹东中朝边境一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=辽宁/6.txt">本溪两日游</a></div>
    		</div>
    		<div class="col-sm-4">
    			<div style="text-align:center;">天津</div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=天津/1.txt">海河世纪钟广场意式风情街一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=天津/3.txt">天津二日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=天津/2.txt">天津三日游</a></div>
    		</div>
    		<div class="col-sm-4">
    			<div style="text-align:center;">上海</div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=上海/1.txt">上海一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=上海/2.txt">上海市区两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=上海/3.txt">沪杭四日游</a></div>
    		</div>
    		
    		<div class="col-sm-4">
    			<div style="text-align:center;">内蒙古</div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=内蒙古/1.txt">玉龙沙湖一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=内蒙古/2.txt">鄂尔多斯两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=内蒙古/3.txt">呼伦贝尔草原一日游</a></div>
    		</div>
    		<div class="col-sm-4">
    			<div style="text-align:center;">黑龙江</div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=黑龙江/1.txt">哈尔滨市区一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=黑龙江/2.txt">齐齐哈尔一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=黑龙江/3.txt">牡丹江雪乡两日游</a></div>
    		</div>
    		<div class="col-sm-4">
    			<div style="text-align:center;">吉林</div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=吉林/1.txt">长白山一日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=吉林/2.txt">长春两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=吉林/3.txt">集安市一日游</a></div>
    		</div>
    		<div class="col-sm-4">
    			<div style="text-align:center;">安徽</div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=安徽/1.txt">黄山两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=安徽/2.txt">天柱山两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=安徽/3.txt">九华山一日游</a></div>
    		</div>
    		<div class="col-sm-4">
    			<div style="text-align:center;">浙江</div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=浙江/1.txt">乌镇西塘古镇两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=浙江/2.txt">西湖、西溪湿地、宋城两日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=浙江/3.txt">千岛湖一日游收</a></div>
    		</div>
    		<div class="col-sm-4">
    			<div style="text-align:center;">江苏</div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=江苏/1.txt">苏州园林太湖古镇三日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=江苏/2.txt">淮扬文化三日游</a></div>
    			<div class="name"><a href="/trival/servlet/HandleRoutine?uri=江苏/3.txt">南京三日游</a></div>
    		</div>
    	</div>
    </div>
  </body>
</html>
