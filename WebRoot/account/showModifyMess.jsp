<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="myservlet.control.mybean.data.ModifyMessage" %>
<jsp:useBean id="modify" type="myservlet.control.mybean.data.ModifyMessage" scope="request"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="refresh" content="3;url=http://localhost:8080/trival/index.jsp" />
	<link href="http://localhost:8080/trival/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://localhost:8080/trival/bootstrap/jquery/jquery.min.js"></script>
    <script src="http://localhost:8080/trival/bootstrap/js/bootstrap.min.js"></script>
    <title>修改用户信息</title>
    <style type="text/css">
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
    .loginbox {
            width: 100%;
            max-width: 500px;
            height:200px;
            position: absolute;
            top: 50%;
            margin-top: -150px;
            padding: 20px 10px 20px 10px;            
            /*设置负值，为要定位子盒子的一半高度*/
        }
	 @media screen and (min-width:500px) {
            .loginbox {
                left: 45%;
                /*设置负值，为要定位子盒子的一半宽度*/
                margin-left: -200px;
            }
        }
  	}
  	</style>
  </head> 
  <body>
	<div class="firstpage" id="firstpagephoto">
		<div class="container">
			<div class="loginbox panel panel-default">
				<div class="col-sm-10 col-sm-offset-1">
					<div style="font-size:30px">
    				<jsp:getProperty name="modify" property="backnews"/>
    				</div>
    				<div style="font-size:30px">
    				新电话：<jsp:getProperty name="modify" property="newphone"/>
    				</div>
    				<div style="font-size:30px">
    				新邮箱：<jsp:getProperty name="modify" property="newemail"/>   				
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
  </body>
</html>
