<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta charset="utf-8" />
<title>发表博客</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/editormd.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/meditor.css" />
	<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/base.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/alert.js"></script>
</head>
<body>
	<div id="layout">
		<div style="width: 90%;margin: 20px auto 0 auto;">
			<input placeholder="请输入标题" type="text" id = "title"
				style="width: 80%; height: 50px; display: block; outline: none; border: none; padding-left: 20px; font-size: 30px; float: left;">
			
			<input
				style="    width: 60px;
    			height: 40px; margin-left: 30px; float: right;"
			type="button" value="发表" onclick="submitReady()" />
		</div>
		<div id="test-editormd">
			<textarea style="display: none;"></textarea>
		</div>
		
	</div>

	<script src="js/editormd.js"></script>
	<script type="text/javascript">
		var testEditor;

		$(function() {
			testEditor = editormd("test-editormd", {
				width : "90%",
				height: 840,
				syncScrolling : "single",
				path : "lib/",
				imageUpload : true,
				imageFormats : [ "jpg", "jpeg", "gif", "png", "bmp", "webp" ],
				imageUploadURL : "${pageContext.request.contextPath}/uploadfile",
				saveHTMLToTextarea : true,
				toolbarIcons :function(){
					return  [
					         "undo", "redo", "|", 
					            "bold", "del", "italic", "quote", "ucwords", "uppercase", "lowercase", "|", 
					            "h1", "h2", "h3", "h4", "h5", "h6", "|", 
					            "list-ul", "list-ol", "hr", "|",
					            "link",  "image", "code", "preformatted-text", "code-block", "table", "datetime",   "|",
					            "goto-line", "watch", "preview", "fullscreen","search", "|",
					            "help"
					        ];
				}
			});			 
		});
		
		function submitReady(){
			// 准备提交，获取编辑内容，
			var content ;
			var mdContent = testEditor.getMarkdown();
			if(mdContent.length>140){
				content = mdContent.substring(0,140);
			}else{
				content = mdContent;
			}
			
			$("#overView").val(content);
			$("#supernatant").css("display","block");
			
		}
		
		
		 function submit() {
				
				$user = getUserFromCookie();
				
				var title;
				var type;
				var content;
				var overView;
				
				// 1， 判断用户是否登陆
				if($user==null){
					$.alert('您未登陆，无法发表文章',function(){
						  location.href = "${pageContext.request.contextPath}/ui_index";
					});
					return;
				}
				
				// 2,获取文章标题，判断是否为null
				title = $("#title").val();
				if(title==null||title==""){
					$.alert("请输入标题");
					return;
				}
				
				type = $("#type option:selected").val();
			 
				
				  var params = {
						"userid":$user.id,
						"title":title,
						"type":type,
						"content":testEditor.getHTML(),
						"isMarkdown":true,
						"mdContent":testEditor.getMarkdown(),
						"digestContent":$("#overView").val()
				};
				$.post("${pageContext.request.contextPath}/publishArticle.action",params,function(data){
					// 获取相应结果
					var result = JSON.parse(data);
					if(result.code==code_success){
						$.alert(result.msg,function(){
							location.href = "${pageContext.request.contextPath}/ui_index";
						})
					}else if(result.code==code_toast){
						$.alert(result.msg);
					}
				}) 
				 
			}
		 
		 function off() {
			 $("#supernatant").css("display","none");
		}
	</script>
	
	<div id="supernatant" >
	
		<div>
			<span class="off" onclick="off()"></span>		
			<div class="type">
			<span>选择文章类型：</span>
			<select name='type' id="type" >
				<option value="android" selected>Android</option>
				<option value="server">Server</option>
				<option value="java">JAVA</option>
				<option value="breast">心语心情</option>
			</select></div>
			<p style="margin-top: 10px;">添加文章摘要：</p>
			<textarea id="overView"   placeholder="添加摘要(1-150字)"></textarea>
			<div><input class="submit" type="submit" onclick="submit()" value="发表"/></div>
		</div>
	
	</div>
	<script type="text/javascript">
		$("#supernatant").css("height",$(window).height()+"px");
	
	</script>
</body>
</html>