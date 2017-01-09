<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
 <script type="text/javascript" src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" data-appid="101378506" data-redirecturi="http://spearbothy.com/spearbothy/notify" charset="utf-8"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/base.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/alert.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>

<script type="text/javascript">
	$("document").ready(function() {
		if (QC.Login.check()) {
			QC.api("get_user_info").success(function(s) {//成功回调
				console.log(s);
				QC.Login.getMe(function(openId, accessToken) {
					
					$.post('${pageContext.request.contextPath}/qqOauth.action', {
						name : s.data.nickname,
						openid : openId,
						otype : 1,
						token : accessToken,
						avater:s.data.figureurl_qq_1
					}, function(data, status) {
						if (status == "success") {
							alert(s.data.nickname + "恭喜你,登录成功!");
							$.cookie("user",encodeURI(JSON.stringify(result.data)));
							location.href = "${pageContext.request.contextPath}/ui_index";
						} else {
							alert("获取用户信息成功！登录失败！");
							location.href = "${pageContext.request.contextPath}/ui_index";
						}
					})
				})
			}).error(function(f) {//失败回调
				alert("获取用户信息失败！登录失败！");
				location.href = "${pageContext.request.contextPath}/ui_index";
			}).complete(function(c) {//完成请求回调
				//alert("获取用户信息完成！");
			});
		} else {
			alert("请登录！");
			/* location.href = "${pageContext.request.contextPath}/ui_index"; */
		}

	})
</script>
</head>
<body >
	登陆中。。请稍后
	
	<!-- 所有操作在后台请求 -->
</body>
</html>

