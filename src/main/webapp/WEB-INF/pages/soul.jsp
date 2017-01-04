<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>关于我们</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/soul.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/alert.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/base.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>

<script type="text/javascript">
	var num = 0;

	$("document").ready(function () {
		// 初始化动画
		//$("p:first").fadeIn("slow");
		/*alert($("p").size());*/
		setInterval(fadeIn,1000);
	});

	function fadeIn(){
		var $p = $("span");
		if(num>$p){
			 Window.clearInterval();
			return;
		}

		$("span:eq("+num+")").fadeIn(1000);
		num++;
	}

</script>
</head>



<body style="background: #eee;">

<%@include file="header.jsp"%>


	<div class="navi">
		<ul>
			<li><a href="ui_soul" class="active">网站之魂</a></li>
			<li><a href="ui_about">关于我们</a></li>
		</ul>
		
		
	</div>

		<div class="content">
			<h2>茅屋为秋风所破歌</h2>
			<!-- <p>八月秋高风怒号，</p>
			<p>卷我屋上三重茅。 </p>
			<p>茅飞渡江洒江郊，</p>
			<p>高者挂罥长林梢，</p>
			<p>下者飘转沉塘坳。</p>
			<br/>

     		<p>南村群童欺我老无力，</p>
     		<p>忍能对面为盗贼，</p>
     		<p>公然抱茅入竹去。</p>
     		<p>唇焦口燥呼不得，</p>
     		<p>归来倚杖自叹息。</p>
     		<br/>
     		<p>俄顷风定云墨色，</p>
     		<p>秋天漠漠向昏黑。</p>
     		<p>布衾多年冷似铁，</p>
     		<p>娇儿恶卧踏里裂。</p>
     		<p>床头屋漏无干处，</p>
     		<p>雨脚如麻未断绝。</p>
     		<p>自经丧乱少睡眠，</p>
     		<p>长夜沾湿何由彻?</p>
     		<br/>
     		<p>安得广厦千万间，</p>
     		<p>大庇天下寒士俱欢颜，</p>
     		<p>风雨不动安如山！</p>
     		<p>呜呼！何时眼前突兀见此屋，</p>
     		<p>吾庐独破受冻死亦足！</p>  -->
     		<!-- 
     		<p>八月秋高风怒号，卷我屋上三重茅。茅飞渡江洒江郊，</p> -->
     		<p>
     		<span>八月秋高风怒号，</span>
			<span>卷我屋上三重茅。 </span>
			<span>茅飞渡江洒江郊，</span>
			<span>高者挂罥长林梢，</span>
			<span>下者飘转沉塘坳。</span>
			</p>
			<p>
     		<span>南村群童欺我老无力，</span>
     		<span>忍能对面为盗贼，</span>
     		<span>公然抱茅入竹去。</span>
     		<span>唇焦口燥呼不得，</span>
     		<span>归来倚杖自叹息。</span>
     		</p>
     		<p>
     		<span>俄顷风定云墨色，</span>
     		<span>秋天漠漠向昏黑。</span>
     		<span>布衾多年冷似铁，</span>
     		<span>娇儿恶卧踏里裂。</span>
     		<span>床头屋漏无干处，</span>
     		<span>雨脚如麻未断绝。</span>
     		<span>自经丧乱少睡眠，</span>
     		<span>长夜沾湿何由彻?</span>
     		</p>
     		<p>
     		<span>安得广厦千万间，</span>
     		<span>大庇天下寒士俱欢颜，</span>
     		<span>风雨不动安如山！</span>
     		<span>呜呼！何时眼前突兀见此屋，</span>
     		<span>吾庐独破受冻死亦足！</span>
			</p>
		</div>


</body>
</html>