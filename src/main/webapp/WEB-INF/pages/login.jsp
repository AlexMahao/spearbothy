<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/alert.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/base.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>

<script type="text/javascript">
	function login() {
		
		var $username = $("#username").val();
		var $password = $("#password").val();
		
		if($username==""){
			$.alert("请输入用户名");
			return;
		}
		
		if($password==""){
			$.alert("请输入密码");
			return;
		}
		
		$.post("${pageContext.request.contextPath}/login.action",$("form:first").serialize(),function(data){
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

<body id="login">
	<div class="wrapper">
		<h1>Login</h1>
		<div class="border">
			<form>
				<div class="padding">
					<h2>USERNAME</h2>
					<label> <input type="text" id="username" name="username"
						class="txt_input txt_input2" placeholder="Your name">
					</label>
					<h2>PASSWORD</h2>
					<label> <input type="password" name="password"
						id="password" class="txt_input" placeholder="****">
					</label>

					<p class="forget">
						<a>Forget your password?</a>
					</p>

					<label> <input class="submit" type="button"
						onclick="login()" value="SIGN-IN">
					</label>

					<div>
			</form>
		</div>
	</div>
</body>

</html>