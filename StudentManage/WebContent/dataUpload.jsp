<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		margin:0 auto;
		position: relative;
	}
	.form input{
		margin-left: 70px;
		margin-top: 50px;
	}
	h3{
		margin:100px auto;
		margin-left:100px;
		display: inline-block;
	}
	.d1{
		margin-left: 80px;
	}
</style>
</head>
<body>
	<%
		String str="";
		Cookie[] cookies= request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if("uu".equals(cookies[i].getName())){
				str=cookies[i].getValue();
			}
		}
	%>
	<div class="d">
	<span>欢迎：</span>
	<div style="width:100px; height:100px; border-radius:50%; overflow:hidden; margin-right: 20px" class="d1">
		<c:if test="${not empty info}">
			<img width="100px" height="100px" src="${info}" alt="图片路径错误,无法加载"/>
		</c:if>
	</div>
	<div class="form">
		<form action="${pageContext.request.contextPath}/dataUploadAction" method="post" enctype="multipart/form-data">
			上传者:<input type="text" name="username" value="<%=str%>"/><br>
			资料上传:<input type="file" name="file"/><br>
			<input type="submit" value="提交"/>
		</form>
	</div>
	</div>
</body>
</html>