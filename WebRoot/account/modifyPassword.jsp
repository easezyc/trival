<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改密码</title>
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
  <body>
  <div class="firstpage" id="firstpagephoto">
	<div class="container">
		<div class="loginbox panel panel-default">
			<div class="col-sm-10 col-sm-offset-1">
			<div style="font-size:15px;color:blue;">请输入当前密码和新的密码</div>
    		<form action="/trival/servlet/HandlePassword" method="post">
    			<div class="input-group">
         			<span class="input-group-addon">当前密码</span>
        				 <input id="phone" type="password" class="form-control" name="oldpassword" placeholder="输入您的当前密码"></div></br>
        	    <div class="input-group">
        			 <span class="input-group-addon">新密码</span>
         				<input id="password" type="password" class="form-control" name="newpassword" placeholder="输入新的密码">
      			</div>
      			<br>
				<div class="btn-group btn-group-sm">
  					<button id="ok" type="submit" type="button" class="btn btn-default">确认</button>
  				</div>
   			 </form>
   			 </div>
		</div>
		</div>
	</div>
  </div>  
  </body>
</html>
