<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>矛屋</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/alert.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/base.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>

<script type="text/javascript">
	$("document").ready(function() {
		// 文档加载完毕之后，开始请求数据

		requestList("android");
		
		requestList("java");
		
		$(".head_content ul li a:eq(0)").addClass("active");
	})

	function toBlogDetail(id){
		location.href = "${pageContext.request.contextPath}/ui_redArticle?id="+id;
	}
	
	function requestList(type) {
		// 请求Android 的标题，评论次数，查看次数
		var params = {
			"type" : type,
			"page" : 1,
			"rows" : 4
		};
		$.post("${pageContext.request.contextPath}/findBlogs", params, function(data) {
			var result = JSON.parse(data);
			if (result.code == code_success) {
				var blogs = result.data;
				var $list = $("."+type+" .right");
				var content = "";
				for (var i = 0; i < blogs.length; i++) {
					var blog = blogs[i];
					content = content
							+ "<div class='content'><span style='display:none'>"+blog.id+"</span><p class='title'>"
							+ blog.title + "</p><div class='desc'>评论（"
							+ blog.commentCount + "）  查看（" + blog.browseCount
							+ "）</div></div>"
				}

				$list.html(content);
				
				$("."+type+" div .content").click(function(){
					var id = $(this).children("span").first();
					toBlogDetail(id.text());
				});
			} else if (result.code == code_toast) {
				$.alert(result.msg);
			}
		});

	}
</script>
</head>
<body>
	<%@include file="header.jsp"%>


	<div id="index_center">

                <div id="large-header" class="banner" >
                    <canvas id="demo-canvas"></canvas>
                    <p style="    position: relative;
    top: -300px;
    width: 1200px;
    margin: 0 auto;
    text-align: center;
    color: white;
    font-size: 30px;">这个地方应该放一句很励志的话，但还没想好</p>   
                </div>
				<script src="${pageContext.request.contextPath}/js/canvas_banner.js"></script>         
	</div>

	<div id="index_content">

		<div class="java">
			<div class="left">
				<span>JAVA</span>
			</div>
			<div class="right">

			</div>
		</div>

		<div class="android">
			<div class="left">
				<span>Android</span>

			</div>
			<div class="right"></div>
		</div>



		<div class="ios">
			<div class="left">
				<span>IOS</span>

			</div>
			<div class="right">
				<div class="content">
					<p class="title">利用ViewPager实现淘宝上拉加载详情</p>
					<div class="desc">评论（0） 查看（0）</div>
				</div>
				<div class="content">
					<p class="title">利用ViewPager实现淘宝上拉加载详情</p>
					<div class="desc">评论（0） 查看（0）</div>
				</div>
				<div class="content">
					<p class="title">利用ViewPager实现淘宝上拉加载详情</p>
					<div class="desc">评论（0） 查看（0）</div>
				</div>


			</div>
		</div>
	</div>


	<div id="index_content_bottom">
		<div>
			<p class="title">心语心情</p>
		</div>

		<div>
			<p class="title">心语心情</p>
		</div>

		<div>
			<p class="title">心语心情</p>
		</div>

	</div>

</body>
</html>