<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<script type="text/javascript">
	$("document")
			.ready(
					function() {
						var user = getUserFromCookie();
						if (user == null) {
							$(".header_login")
									.html(
											"<a href='ui_login'>登陆</a><label>|</label> <a href='ui_register'>注册</a>")
						} else {
							$(".header_login")
									.html(
											"<span>欢迎 "
													+ user.name
													+ "</span><label>|</label><a href='javascript:toedit()'>写文章</a><label>|</label><a href='javascript:'>个人信息</a><label>|</label><a href='javascript:exit()'>退出登陆</a>");
						}
					})

	function exit() {
		$.removeCookie('user');
		location.href = "/ui_index"
	}

	function toedit() {

		location.href = "/meditor/meditor.jsp";
	}
</script>

<!-- <div class="header_content">
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
	</div> -->
<div class="header">
	<div class="top">
		<div class="head_content">
			<div class="header_login">
				<a href="/ui_login">登陆</a><label>|</label> <a href="/ui_register">注册</a>
			</div>
		</div>
	</div>
	<div class="head_content">
		<a href="#"><img src="/image/logo.png" height="70"></img></a>
		<ul>
			<li><a href="ui_index">首页</a></li>
			<li><a href="ui_list?type=java">JAVA</a></li>
			<li><a href="ui_list?type=android">Android</a></li>
			<li><a href="about.asp">IOS</a></li>
			<li><a href="about.asp">心语心情</a></li>
			<li><a href="about.asp">关于我们</a></li>
			<li><a href="about.asp">留言</a></li>
		</ul>


	</div>
</div>

