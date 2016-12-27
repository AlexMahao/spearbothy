<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta charset="utf-8" />
<title>Simple example - Editor.md examples</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cssReset.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/editormd.css" />
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
			<select name='type' id="type" style='width:100px;height:30px;margin-top: 10px;font-size: 18px;' >
				<option value="android" selected>Android</option>
				<option value="ios">IOS</option>
				<option value="java">JAVA</option>
				<option value="breast">心语心情</option>
			</select>
			<input
				style="width: 80px; height: 50px; margin-left: 30px; float: right;"
			type="button" value="发表" onclick="submit()" />
		</div>
		<div id="test-editormd">
						<textarea style="display: none;">
[TOC]
			
#### Disabled options

- TeX (Based on KaTeX);
- Emoji;
- Task lists;
- HTML tags decode;
- Flowchart and Sequence Diagram;
			
#### Editor.md directory
			
editor.md/
lib/

			
```html
&lt;!-- English --&gt;
&lt;script src="../dist/js/languages/en.js"&gt;&lt;/script&gt;
			
&lt;!-- 繁體中文 --&gt;
&lt;script src="../dist/js/languages/zh-tw.js"&gt;&lt;/script&gt;
```
			</textarea>
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
				imageUploadURL : "/uploadfile",
				saveHTMLToTextarea : true
			});			 
		});
		
		 function submit() {
				
				$user = getUserFromCookie();
				
				var title;
				var type;
				var content;
				
				// 1， 判断用户是否登陆
				if($user==null){
					$.alert('您未登陆，无法发表文章',function(){
						  location.href = "/ui_index";
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
						"mdContent":testEditor.getMarkdown()
				};
				$.post("/publishArticle.action",params,function(data){
					// 获取相应结果
					var result = JSON.parse(data);
					if(result.code==code_success){
						$.alert(result.msg,function(){
							location.href = "/ui_index";
						})
					}else if(result.code==code_toast){
						$.alert(result.msg);
					}
				}) 
				 
			}
	</script>
</body>
</html>