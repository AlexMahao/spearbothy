<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文章查看</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/base.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/readArticle.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/editormd.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/alert.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>

<script type="text/javascript">
	$(function() {
		var id = getQueryString("id");
		var params = {
			"blogId" : id
		};
		$.post("${pageContext.request.contextPath}/getBlogDetail.action", params, function(data) {
			// 结果回调
			var result = JSON.parse(data);
			if (result.code == code_success) {

				$(".maincontent #title").text(result.data.title);
				$(".maincontent #id").text(result.data.id);
				$author = $("#authorhref");
				$author.text(result.data.user.name);
				$("#md").html(result.data.content);
			} else if (result.code == code_toast) {
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
				<li><a href="${pageContext.request.contextPath}/ui_index">去首页</a></li>
			</ul>
		</div>

	</div>

	<div class="maincontent">
		<span id="id" style="display:none"></span>
		<span id="title"></span> <span id="author">作者：<a
			id="authorhref" href="#"></a></span>

		<div id="md" class="markdown-body editormd-preview-container"></div>
	</div>

<%-- <div id="cloud-tie-wrapper" style="width:60%;margin: auto;" class="cloud-tie-wrapper"></div>
<script src="https://img1.ws.126.net/f2e/tie/yun/sdk/loader.js"></script>
<script>
		var cloudTieConfig = {
		  sourceId: getQueryString("id"),
		  productKey: "f3aa18e63c664c88ad359b14614b5db3",
		  target: "cloud-tie-wrapper"
		};
		var yunManualLoad = true;
		Tie.loader("aHR0cHM6Ly9hcGkuZ2VudGllLjE2My5jb20vcGMvbGl2ZXNjcmlwdC5odG1s", true);
</script> --%>
<div class="ds-thread" data-thread-key="javascript:getQueryString('id')" data-title="请替换成文章的标题" data-url="javascript:location.href"></div>
<!-- 多说评论框 end -->
<!-- 多说公共JS代码 start (一个网页只需插入一次) -->
<script type="text/javascript">
var duoshuoQuery = {short_name:"spearbothy"};
	(function() {
		var ds = document.createElement('script');
		ds.type = 'text/javascript';ds.async = true;
		ds.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') + '//static.duoshuo.com/embed.js';
		ds.charset = 'UTF-8';
		(document.getElementsByTagName('head')[0] 
		 || document.getElementsByTagName('body')[0]).appendChild(ds);
	})();
	</script>

</body>
</html>