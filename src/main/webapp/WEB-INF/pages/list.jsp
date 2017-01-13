<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>矛屋</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bloglist.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/base.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.aniview.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/alert.js"></script>
<script>

	
	// 类型
	var type ;
	
	// 是否正在加载数据
	var isNetWork = false;
	// page对象
	var pageBean = {
			"currentPage":0,
			"pageSize":10,
			"hasNext":true
	};

	$(document).ready(function() {
		// 请求分页数据
		type = getQueryString("type");
		
		if(type=="android"){
			$(".head_content ul li a:eq(2)").addClass("active");
		}else if(type=="java"){
			$(".head_content ul li a:eq(1)").addClass("active");
		}
		
		
		getBlogType();
		
		
	});
	
	 $(window).scroll(function () {
	        var scrollTop = $(this).scrollTop();//scrollTop为滚动条在Y轴上的滚动距离。
	        var scrollHeight = $(document).height(); // 获取整个文档的高度
	        var height = $(window).height();// 获取显示区域的高度
	        if(scrollTop>height/2){
	        	getBlogType();
	        }
	 });

	
	
	function getBlogType(){
		
		if(isNetWork){
			return;
		}
		
		isNetWork = true;
		
		if(!pageBean.hasNext){
			return;
		}
		
		params = {
				"page":pageBean.currentPage+1,
				"rows":pageBean.pageSize,
				"type":type
		}
		
		$.post("${pageContext.request.contextPath}/getBlogsByType.action",params,function(data){
			isNetWork = false;
			var result = JSON.parse(data);
			if(result.code==code_success){
				pageBean = result.data;
				parseData(pageBean.data);
				/* alert($(".item[currentPage="+pageBean.currentPage+"] ").size());
				$("[currentPage="+pageBean.currentPage+"] ").hover(
						function () {
						  var obj = $(this);
							biankuang(obj);
						},
						function () {
						  var obj = $(this);
							biankuang1(obj);
						}); */
			}
			
		});
		
	/* 	$("#container_content").ajaxComplete(function(){ //待请求完成时 执行 
			// 请求完成之后获取动态加载的数据
		})  */
	}
	
	function parseData(data){
		var container ="";
		for(var i = 0 ; i<data.length;i++){
			var blog = data[i];
			
			var bloghtml = "<div class='item aniview' id='"+blog.id+"'   currentPage='"+pageBean.currentPage+"' data-av-animation='fadeInUp'> ";
			
			
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
			$("#container_content").append(bloghtml);
		
			 $("#"+blog.id).hover(
						function () {
							  var obj = $(this);
							  	
								biankuang(obj);
							},
							function () {
							  var obj = $(this);
								biankuang1(obj);
							}); 
			 
			 $("#"+blog.id).click(function(index){
					toBlogDetail($(this).attr("id"));
				});
			 $("#"+blog.id).AniView();		
		}
	}
	
	
	
	function toBlogDetail(id){
		location.href = "${pageContext.request.contextPath}/ui_redArticle?id="+id;
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

<%@include file="bottom.jsp"%> 

</body>
</html>