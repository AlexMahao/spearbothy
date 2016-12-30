<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/header.css">
<link rel="stylesheet" type="text/css" href="/css/base.css" />
<link rel="stylesheet" type="text/css" href="/css/bloglist.css" />
<link type="text/css" rel="stylesheet" href="/css/animate.css">
<script type="text/javascript" src="/js/base.js"></script>
<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="/js/jquery.aniview.js"></script>
<script type="text/javascript" src="/js/jquery.cookie.js"></script>
<script type="text/javascript" src="/js/alert.js"></script>
<script>

	
	// 类型
	var type ;
	// page对象
	var pageBean = {
			"currentPage":0,
			"pageSize":10,
			"isHasNext":true
	};

	$(document).ready(function() {
		// 请求分页数据
		type = getQueryString("type");
		
		getBlogType();
		
		
	});
	
	function getBlogType(){
		
		if(!pageBean.isHasNext){
			return;
		}
		
		params = {
				"page":pageBean.currentPage+1,
				"rows":pageBean.pageSize,
				"type":type
		}
		
		$.post("/getBlogsByType.action",params,function(data){
			var result = JSON.parse(data);
			if(result.code==code_success){
				pageBean = result.data;
				parseData(pageBean.data);
			}
		});
	}
	
	function parseData(data){
		var container ="";
		for(var i = 0 ; i<data.length;i++){
			
			var blog = data[i];
			var bloghtml = "<div class='item aniview' ss='"+blog.id+"' data-av-animation='fadeInUp'> ";
			
			var bloghtml = bloghtml+"<div class='biankuang biankuang_1'></div>";
			var bloghtml = bloghtml+"<div class='biankuang biankuang_2'></div>";
			var bloghtml = bloghtml+"<div class='biankuang biankuang_3'></div>";
			var bloghtml = bloghtml+"<div class='biankuang biankuang_4'></div>";
			
			
			bloghtml = bloghtml+"<div class='left_date'>"+blog.createTime.substring(8,10)+"<span>Dec</span></div>";
			
			bloghtml = bloghtml +"<div class='left_detail'>";
			bloghtml = bloghtml +"<div class='list_title'><a>"+blog.title+"</a></div>";

			bloghtml = bloghtml +"<div class='list_info'>发布时间：<span>"+blog.createTime.substring(0,10)+"</span> 阅读次数：<span>"+blog.browseCount+"</span></div>";

			bloghtml = bloghtml +"<div class='list_brief'><a >暂无摘要记录</a></div>";
			bloghtml = bloghtml +"</div><div style='clear: both;'></div></div>";
			$("#container_content").html($("#container_content").html()+bloghtml);
			
		}
		$(".item").click(function(index){
			toBlogDetail($(this).attr("ss"));
		});
		// 初始化动画
		$('.aniview').AniView();
		
		$('.item').hover(
				function () {
				  var obj = $(this);
					biankuang(obj);
				},
				function () {
				  var obj = $(this);
					biankuang1(obj);
				});
	}
	
	function toBlogDetail(id){
		location.href = "/ui_redArticle?id="+id;
	}
</script>
</head>
<body>
	<%@include file="header.jsp"%>

	<div class="container " >
		<div id="container_content">

		</div>
	</div>
	
	<script type="text/javascript">
//边框效果--移入
function biankuang(obj){
    $(obj).find('.biankuang_1').stop(true).animate({
        height:$(obj).height()+60+'px'
    },300)
    $(obj).find('.biankuang_2').stop(true).delay(300).animate({
        width:'908px'
    },300)
    $(obj).find('.biankuang_3').stop(true).animate({
        height:$(obj).height()+60+'px'
    },300)
    $(obj).find('.biankuang_4').stop(true).delay(300).animate({
        width:'908px'
    },300)
}
//边框效果--移出
function biankuang1(obj){
    $(obj).find('.biankuang_1').stop(true).delay(100).animate({
        height:'0px'
    },100)
    $(obj).find('.biankuang_2').stop(true).animate({
        width:'0px'
    },100)
    $(obj).find('.biankuang_3').stop(true).delay(100).animate({
        height:'0px'
    },100)
    $(obj).find('.biankuang_4').stop(true).animate({
        width:'0px'
    },100)
}
//触发

</script>
</body>
</html>