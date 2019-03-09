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
    <%
		String name=(String)session.getAttribute("username");
		if(name!=null){
			response.sendRedirect("/StudentManage/index.jsp");
		}
		
	%>
	<%
		String str="";
		Cookie[] cookies= request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if("uu".equals(cookies[i].getName())){
				str=cookies[i].getValue();
			}
		}
	%>
	<div class="form">
	<h3>欢迎进入登录页面</h3>
	<form action="${pageContext.request.contextPath}/loginServlet" method="post">
		username:<input type="text" name="username" value="<%=str%>"><br>
		password:<input type="password" name="password"><br>
		<input type="checkbox" name="auto" value="yes">是否自动登录
		<input type="checkbox" name="nameauto" value="ok" checked="checked">是否记住用户名 <br>
		<input type="submit" value="登录">
	</form>
	</div>
</body>
	
</html>