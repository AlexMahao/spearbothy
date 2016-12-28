<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文章查看</title>
<script type="text/javascript" src="/js/base.js"></script>
<link rel="stylesheet" type="text/css" href="/css/base.css" />
<link rel="stylesheet" type="text/css" href="/css/readArticle.css">
<link rel="stylesheet" href="/css/editormd.css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/alert.js"></script>

<script type="text/javascript" src="js/jquery.cookie.js"></script>

<script type="text/javascript">
	$(function() {
		var id = getQueryString("id");
		var params = {
			"blogId" : id
		};
		$.post("/getBlogDetail.action", params, function(data) {
			// 结果回调
			var result = JSON.parse(data);
			if(result.code==code_success){
				
				$(".maincontent #title").text(result.data.title);
				$author =  $("#authorhref");
				$author.text(result.data.user.name);
				$("#md").html(result.data.content);
			}else if(result.code==code_toast){
				$.alert(result.msg);
			}
		});
	})
</script>
</head>
<body>
	<div class="mheader">
		<div class="content">
			<h2>茅屋</h2>

			<ul>
				<li><a href="javascript:history.back(-1)">返回</a></li>
				<li><a href="/ui_index">去首页</a></li>
			</ul>
		</div>

	</div>

	<div class="maincontent">

		<span id="title"></span> <span id="author">作者：<a id="authorhref"
			href="#"></a></span>

		<div id="md" class="markdown-body editormd-preview-container">
		
		</div>
	</div>

</body>
</html>