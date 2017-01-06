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
	function replay(obj) {

		$parent = $(obj).parentsUntil(".text")

		if ($parent.find(".commit").size() > 0) {
			$(obj).css("color", "#777");

			$parent.children(".commit").remove();
		} else {
			$(obj).css("color", "#333");

			$parent
					.append("<div class='commit'><div class='avatar'><img src='${pageContext.request.contextPath}/image/no_avatar.jpg'></img></div><div class='text'><div class='form'><textarea placeholder='说的什么吧'></textarea></div><p><input class='submit' type='button' value='提交'/></p></div></div>");

		}

	}
	
	$("document").ready(function(){
		
		var params = {
				"commentType":"message"
		};
		
		$.post("${pageContext.request.contextPath}/getMessages.action", params, function(data) {
			// 获取相应结果
			var result = JSON.parse(data);
			if (result.code == code_success) {
				var array = result.data;
				for(var i = 0 ; i<array.length;i++ ){
					var message = array[i];
					
					var html = "<div class='message'><div class='avatar'><img src='${pageContext.request.contextPath}/image/no_avatar.jpg'></img></div>"
							+"<div class='text'><p class='nickname'>"+message.user.name+"</p>"
							+"<p class='main'>"+message.commentContent+"</p>"
							+"<p class='hint'><span>"+message.createTime.substring(0,4)+"年"+message.createTime.substring(5,7)+"月"
							+message.createTime.substring(5,7)+"日"+"</span>"
							+"<a href='javascript:void(0)' onclick='replay(this)'><span class='icon_replay'></span>回复</a> <a href='#'><span class='icon_top'></span>顶</a> <a href='#'><span></span></a>"
							+"</p></div></div>";
					
					$(".content_message").append(html);
				}
				
				
				
			} else if (result.code == code_toast) {
				$.alert(result.msg);
			}

		});
		
	})

	// 提交留言
	function leaveMessage(obj) {
		$user = getUserFromCookie();

		var $form = $(obj).parents("#form");
		var content = $form.find("textarea").val();

		// 1， 判断用户是否登陆
		if ($user == null) {
			$.alert("您为登陆，暂时无法发表留言");
			return;
		}

		if (content == "" || content == null) {
			$.alert("请先输入留言在发表");
			return;
		}

		var params = {
			"userId" : getUserFromCookie().id,
			"commentType" : "message",
			"content" : content,
			"contentDesc" : "暂无描述"
		};

		$.post("${pageContext.request.contextPath}/leaveMessage.action", params, function(data) {
			// 获取相应结果
			var result = JSON.parse(data);
			if (result.code == code_success) {
				 location.reload() ;
			} else if (result.code == code_toast) {
				$.alert(result.msg);
			}

		});

	}
</script>
</head>



<body style="background: #eee;">

	<%@include file="header.jsp"%>


	<div class="content">
		
		

<%-- 
		<div class="message">
			<div class="avatar">
				<img src="${pageContext.request.contextPath}/image/no_avatar.jpg"></img>

			</div>

			<div class="text">
				<p class="nickname">马昊</p>

				<p class="main">这是评论的主体内容</p>

				<p class="hint">
					<span>2016年3月15日</span> <a href="javascript:void(0)"
						onclick="replay(this)"><span class="icon_replay"></span>回复</a> <a
						href="#"><span class="icon_top"></span>顶</a> <a href="#"><span></span></a>
				</p>
			</div> --%>
		<div class="content_message">
		
		</div>


		<div class="commit">

			<div class="avatar">
				<img src="${pageContext.request.contextPath}/image/no_avatar.jpg"></img>

			</div>

			<div class="text">
				<form id="form">
					<div class="form">

						<input type="text" style="display: none;" name="userId"
							value="javascript:getUserFromCookie().id" /> <input type="text"
							style="display: none;" name="commentType" value="message" /> <input
							type="text" style="display: none;" name="commentDesc"
							value="暂无描述" />
						<textarea name="content" placeholder="说的什么吧"></textarea>

					</div>

					<p>
						<input class="submit" type="button" onclick="leaveMessage(this)"
							value="提交" />

					</p>
				</form>
			</div>
		</div>

	</div>


</body>
</html>