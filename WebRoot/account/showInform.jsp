<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <jsp:useBean id="login" type="myservlet.control.mybean.data.Login" scope="session"/>
    <title>用户信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="http://localhost:8080/trival/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://localhost:8080/trival/bootstrap/jquery/jquery.min.js"></script>
    <script src="http://localhost:8080/trival/bootstrap/js/bootstrap.min.js"></script>
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
    					昵称<jsp:getProperty name="login" property="name"/>
    				</div>
    				<div style="font-size:30px">
    					手机<jsp:getProperty name="login" property="phone"/>
    				</div>
    				<div style="font-size:30px">
   						 邮箱<jsp:getProperty name="login" property="mail"/>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
  </body>
</html>
