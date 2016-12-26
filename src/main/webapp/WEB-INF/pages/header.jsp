<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css" />

<script type="text/javascript" src="/js/base.js"></script>
<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/header.css" />
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript">
	$("document").ready(function(){
		var user = getUserFromCookie();
		if(user==null){
			$(".header_login").html("<a href='ui_login'>登陆</a> <a href='ui_register'>注册</a>")
		}else{
			$(".header_login").html("<span>欢迎 "+user.name+"</span><a href='javascript:toedit()'>写文章</a><a href='javascript:'>个人信息</a><a href='javascript:exit()'>退出登陆</a>");
		}
	})
	
	function exit(){
		$.removeCookie('user');
		location.href="/ui_index"
	}
	
	function toedit(){

		location.href = "/ueditor/index.jsp";
	}
	
</script>
</head>
<body>
<div class="header_content">
		<div class="header_top">
				<div class="header_title">
					<h1 >SpearBothy</h1>
				</div>
				<div class="header_right">
					<div class="header_login">
						<a href="/ui_login">登陆</a> <a href="/ui_register">注册</a>
					</div>
				</div>
			</div>
		<div class="header_menu">
				<ul>
					<li><a href="default.asp">首页</a></li>
					<li><a href="news.asp">JAVA</a></li>
					<li><a href="contact.asp">Android</a></li>
					<li><a href="about.asp">IOS</a></li>
					<li><a href="about.asp">心语心情</a></li>
					<li><a href="about.asp">关于我们</a></li>
					<li><a href="about.asp">留言</a></li>
				</ul>
			</div>

		<hr  class="header_undeline" />
	</div>

</body>
</html>