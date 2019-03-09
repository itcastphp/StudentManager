<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	.form{
		background-color: #ADEFFD;
		width: 400px;
		height: 300px;
		margin: 100px auto;
		position: relative;
	}
	input{
		margin-left: 70px;
		margin-bottom: 15px
	}
</style>
</head>
<body>
	<div class="form">
	<h1>欢迎来到注册页面</h1>
	<form action="${pageContext.request.contextPath}/addUserServlet" method="post" enctype="multipart/form-data">
		nickname:<input type="text" name="nickname" placeholder="请输入昵称"/><br>
		password:<input type="password" name="password" placeholder="请输入密码"/><br>
		email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="email" name="email" placeholder="请输入Email"/><br>
		选择头像:<input type="file" name="file"/><br>
		<input type="submit" value="注册"/>
	</form>
	</div>
</body>
</html>