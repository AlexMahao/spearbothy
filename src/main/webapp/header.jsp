<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/base.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />

<script type="text/javascript">
	$("document").ready(function(){
		var cookie = getCookie("user");
		alert(cookie.substring(1,cookie.length-1));	
		var json = JSON.parse(""+cookie.substring(1,cookie.length-1));
		alert(json.name);
		
		if(cookie==""){
			$(".header_top").html("<a href='register_and_login.jsp'>登陆</a> <a href='register.jsp'>注册</a>")
		}else{
			$(".header_top").html("欢迎 "+JSON.parse(cookie.substring(1,cookie.length-1)).name+"<a href='javascript:exit()'>退出登陆</a>");
		}
	})
	
	
</script>
</head>
<body>
	<div class="header_content">
		<h1 style="float: left;">SpearBothy</h1>
		<div style="float: right;">
			<div class="header_top">
				
			</div>
			<div>
				<ul class="header_menu">
					<li><a href="default.asp">首页</a></li>
					<li><a href="news.asp">JAVA</a></li>
					<li><a href="contact.asp">Android</a></li>
					<li><a href="about.asp">IOS</a></li>
					<li><a href="about.asp">关于我们</a></li>
					<li><a href="about.asp">留言</a></li>
				</ul>
			</div>
		</div>
	
	</div>
	<hr  class="header_undeline" />

</body>
</html>