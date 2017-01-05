<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>关于我们</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/message.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/alert.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/base.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>

<script type="text/javascript">
	
	
	function replay(obj){
		$parent = $(obj).parentsUntil(".text")
		
	
		if($parent.find(".commit").size()>0){
			$parent.children(".commit").remove();
		}else{
			$parent.append("<div class='commit'><div class='avatar'><img src='${pageContext.request.contextPath}/image/no_avatar.jpg'></img></div><div class='text'><div class='form'><textarea placeholder='说的什么吧'></textarea></div><p><input class='submit' type='button' value='提交'/></p></div></div>");
			
		}
	
	}
</script>
</head>



<body style="background: #eee;">

	<%@include file="header.jsp"%>


	<div class="content">
		<div class="message">
			<div class="avatar">
				<img src="${pageContext.request.contextPath}/image/no_avatar.jpg"></img>

			</div>

			<div class="text">
				<p class="nickname">马昊</p>

				<p class="main">这是评论的主体内容</p>

				<p class="hint">
					<span>2016年3月15日</span> <a href="javascript:void(0)" onclick="replay(this)"><span class="icon_replay"></span>回复</a>
					<a href="#"><span class="icon_top"></span>顶</a> <a href="#"><span></span></a>
				</p>
			</div>


		</div>

		<div class="message">
			<div class="avatar">
				<img src="${pageContext.request.contextPath}/image/no_avatar.jpg"></img>

			</div>

			<div class="text">
				<p class="nickname">马昊</p>

				<p class="main">这是评论的主体内容</p>

				<p class="hint">
					<span>2016年3月15日</span> <a href="javascript:void(0)" onclick="replay(this)"><span class="icon_replay"></span>回复</a>
					<a href="#"><span class="icon_top"></span>顶</a> <a href="#"><span></span></a>
				</p>
			</div>
		</div>
		
		
		<div class="message">
			<div class="avatar">
				<img src="${pageContext.request.contextPath}/image/no_avatar.jpg"></img>

			</div>

			<div class="text">
				<p class="nickname">马昊</p>

				<p class="main">这是评论的主体内容</p>

				<p class="hint">
					<span>2016年3月15日</span> <a href="javascript:void(0)" onclick="replay(this)"><span class="icon_replay"></span>回复</a>
					<a href="#"><span class="icon_top"></span>顶</a> <a href="#"><span></span></a>
				</p>
			</div>
		</div>
		
		
		<div class="commit">

			<div class="avatar">
				<img src="${pageContext.request.contextPath}/image/no_avatar.jpg"></img>

			</div>

			<div class="text">
				<div class="form">
					<textarea placeholder="说的什么吧"></textarea>
				</div>

				<p>
					<input class="submit" type="button" value="提交"/>

				</p>
			</div>
		</div>
		
	</div>


</body>
</html>