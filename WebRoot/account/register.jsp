<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="http://localhost:8080/trival/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="http://localhost:8080/trival/bootstrap/jquery/jquery.min.js"></script>
    <script src="http://localhost:8080/trival/bootstrap/js/bootstrap.min.js"></script>
    <title>注册</title>
	<style type="text/css">
	
	 .loginbox {
            width: 100%;
            max-width: 500px;
            height:450px;
            position: absolute;
            top: 50%;
            margin-top: -200px;
            padding: 20px 20px 20px 20px;            
            /*设置负值，为要定位子盒子的一半高度*/
        }
	 @media screen and (min-width:500px) {
            .loginbox {
                left: 50%;
                /*设置负值，为要定位子盒子的一半宽度*/
                margin-left: -250px;
            }
        }	
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
	</style>
  </head>
  
  <body>
  <div class="firstpage" id="firstpagephoto">
<div class="container">
  <div class="loginbox panel panel-default">
   <form action="/trival/servlet/HandleRegister" method="post" class="bs-example bs-example-form" role="form">
       <div class="input-group">
         <span class="input-group-addon">昵称</span>
         <input id="name" type="text" name="name" class="form-control" placeholder="请输入姓名">
      </div></br></br>
      <div class="input-group">
         <span class="input-group-addon">电话</span>
         <input id="phone" type="text" name="phone" class="form-control" placeholder="请输入电话号码">
      </div></br></br>
      <div class="input-group">
         <span class="input-group-addon">密码</span>
         <input id="password" type="password" name="password" class="form-control" placeholder="请输入密码">
      </div></br></br>
      <div class="input-group">
         <span class="input-group-addon">确认密码</span>
         <input id="checkpassword" type="password" name="checkpassword" class="form-control" placeholder="请再次输入密码">
      </div></br></br>
     
      <div class="input-group">
         <span class="input-group-addon">邮箱</span>
         <input id="mail" type="text" name="email" class="form-control" placeholder="请输入邮箱">
      </div></br></br>
		<div class="col-xs-4 col-xs-offset-5">
      <div class="btn-group btn-group-sm">
  		<button id="ok" type="submit" type="button" class="btn btn-default">确认</button>
  		</div>
		</div>
      </form>

    </div>
    </div>
    </div>
  </body>
</html>
