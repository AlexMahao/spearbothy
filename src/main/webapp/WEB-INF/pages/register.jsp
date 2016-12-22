<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/register.css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/alert.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript">

	function checkForm() {
		
		var $username = $("#username").val();
		var $email = $("#email").val();
		var $password = $("#password").val();
		var $repassword = $("#repassword").val(); 
		
		if($username==""){
			$.alert("用户名不能为空");
			return;
		}
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		
		if(!filter.test($email)){
			$.alert("请输入符合格式的邮箱地址");
			return;
		}
		
		
		if($password==""||$password==null||$repassword==""||$repassword==null){
			$.alert("请输入密码或重复输入");
			return;
		}
		if($password!=$repassword){
			$.alert("两次密码输入不一致");
			return;
		}
		
		 $.post("register",$("form:first").serialize(),function(data){
			var result = JSON.parse(data);
			if(result.code==code_success){
				$.cookie("user",encodeURI(JSON.stringify(result.data)));
				location.href = "ui_index";
			}else if(result.code==code_toast){
				$.alert(result.msg);
			}
		}) 
	}
	
	 
</script>
</head>

<body id="register">
	<div class="wrapper">
		<h1>注册</h1>
		<form >
			<div class="border">
				<div class="padding">
					<h2>USERNAME</h2>
					<label> <input type="text" id="username" name="username"
						class="txt_input txt_input2" placeholder="请输入用户名">
					</label>
					<h2>EMAIL</h2>
					<label> <input type="text" name="email" id="email"
						class="txt_input" placeholder="请输入邮箱">
					</label>

					<h2>PASSWORD</h2>
					<label> <input type="password" name="password" id="password"
						class="txt_input" placeholder="请输入密码">
					</label>
					<h2>REPASSWORD</h2>
					<label> <input type="password" name="repassword"
						id="repassword" class="txt_input" placeholder="再次输入密码">
					</label> <label> <input class="submit" type="button" onclick="checkForm()"
						value="SIGN-IN">
					</label>
		<form>
		<p class="forget">
			<a href="#">已有账号？去登陆</a>
		</p>
		<div></div>
	</div>
</body>

</html>