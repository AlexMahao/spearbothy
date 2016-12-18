<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<span  style="background-color:red"><s:property value="#session.user.username" /></span>
		<span  style="background-color:black"><s:property value="#request.user.username" /></span>
		<span  style="background-color:gray"><s:property value="#application.user.username" /></span>
		<span  style="background-color:blue"><s:property value="password" /></span>
		<s:debug></s:debug>
	</h1>
</body>
</html>