<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="keywords" content="博客，Android,Java,资源，论坛，开发者，程序员">
<meta name="description" content="个人博客，记录日常技术文章，心情文章。">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>矛屋</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/message.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/comment.css">
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
					.append("<div class='commit'><div class='avatar'><img src='${pageContext.request.contextPath}/image/no_avatar.jpg'></img></div><div class='text'><form id='form'><div class='form'><textarea placeholder='说的什么吧'></textarea></div><p><input class='submit' onclick='leaveComment(this)' type='button' value='提交'/></p></form></div></div>");

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
					var html = setCommentHTML(message);
					$(".content_message").append(html);
					setComment(message.comments,$(".content_message>.message:eq("+i+")"));
				}
			} else if (result.code == code_toast) {
				$.alert(result.msg);
			}

		});
		
	})
	
	
	// 设置评论的和列表对象
	function setComment(comments,$obj){
		if(comments.length>0){
			for(var i = 0 ; i<comments.length;i++ ){
				message = comments[i];
				//writeObj(message.user);
				var shtml = setCommentHTML(message);
				$obj.find(".text").append(shtml);
				setComment(message.comments, $obj.find(".message:eq("+i+")"));
				
			}
		}
	}
	
	function writeObj(obj){ 
		 var description = ""; 
		 for(var i in obj){ 
		 var property=obj[i]; 
		 description+=i+" = "+property+"\n"; 
		 } 
		 alert(description); 
		} 
	
	
	function setCommentHTML(message){
		return "<div class='message'><div class='avatar'><img src='"+getUserAvater(message.user.avater)+"'></img></div>"
		+"<div class='text' id='text'><p class='id' style='display:none'>"+message.id+"</p>"+"<p class='nickname'>"+message.user.name+"</p>"
		+"<p class='main'>"+message.commentContent+"</p>"
		+"<p class='hint'><span>"+message.createTime.substring(0,4)+"年"+message.createTime.substring(5,7)+"月"
		+message.createTime.substring(5,7)+"日"+"</span>"
		+"<a href='javascript:void(0)' onclick='replay(this)'><span class='icon_replay'></span>回复</a> <a href='#'><span class='icon_top'></span>顶</a> <a href='#'><span></span></a>"
		+"</p></div></div>";
	}

	// 回复评论
	function leaveComment(obj) {
		$user = getUserFromCookie();

		var $form = $(obj).parents("#form");
		var content = $form.find("textarea").val();
		var id = $form.parents("#text").find(".id").html();
		
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
			"commentType" : "comment",
			"id":id,
			"content" : content,
			"contentDesc" : "暂无描述"
		};

		$.post("${pageContext.request.contextPath}/leaveComment.action", params, function(data) {
			// 获取相应结果
			var result = JSON.parse(data);
			if (result.code == code_success) {
				 location.reload() ;
			} else if (result.code == code_toast) {
				$.alert(result.msg);
			}

		});

	}
	
	
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

		$.post("${pageContext.request.contextPath}/leaveComment.action", params, function(data) {
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
		
		<div><h1>留言板</h1></div>

		<div class="content_message">
		
		</div>


		<div class="commit">

			<div class="avatar">
				<img id="submitImg" src=""></img>
				<script type="text/javascript">
					var user = getUserFromCookie();
					if(user==null){
						$("#submitImg").attr("src","${pageContext.request.contextPath}/image/no_avatar.jpg")
					}else{
						$("#submitImg").attr("src",user.avater);
					}
					
				</script>
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

<%@include file="bottom.jsp"%>

</body>
</html>