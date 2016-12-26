<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>发表博客</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<script type="text/javascript" charset="utf-8" src="ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor.all.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/base.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/alert.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">

</script>

</head>
<body>
	<div>
		<div>
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
		<script id="editor" type="text/plain"
			style="width:100%;height:1000px;clear:both;"></script>
	</div>


	<script type="text/javascript">
		//实例化编辑器
		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
		var ue = UE.getEditor('editor', {
			toolbars : [ [ 'undo', 'redo', '|', 'bold',
					'italic', 'underline', 'fontborder', 'strikethrough',
					'superscript', 'subscript', 'formatmatch', 'autotypeset',
					'|', 'forecolor', 'backcolor', 'insertorderedlist',
					'insertunorderedlist', '|',
					'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
					'justifyleft', 'justifycenter', 'justifyright',
					'justifyjustify', '|', 'link', 'unlink', '|', 'imagenone',
					'imageleft', 'imageright', 'imagecenter', '|',
					'simpleupload', 'insertcode', '|', 'horizontal',
					'date', 'time', 'spechars', '|', 'inserttable',
					'deletetable', 'insertparagraphbeforetable', 'insertrow',
					'deleterow', 'insertcol', 'deletecol', 'mergecells',
					'mergeright', 'mergedown', 'splittocells', 'splittorows',
					'splittocols', 'charts', '|', 'searchreplace' ] ]
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
			
			if(!ue.hasContents()){
				$.alert("请输入文章内容");
				return;
			} 
			
			content = ue.getContent();// 获取内容
			
			var params = {
					"userid":$user.id,
					"title":title,
					"type":type,
					"content":ue.getContent()
			};
			$.post("/publishArticle",params,function(data){
				// 获取相应结果
				var result = JSON.parse(data);
				if(result.code==code_success){
					$.alert(result.msg,function(){
						location.href = "ui_index";
					})
				}else if(result.code==code_toast){
					$.alert(result.msg);
				}
			})
			
		}
	</script>
</body>
</html>