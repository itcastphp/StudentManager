<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<style type="text/css">
		#d4{
				margin:0 auto;
				width:800px;
				/* border: 1px black solid; */
			}	
		video{
			margin-left: 50px;
		}
	</style>
</head>
<body>	
		<jsp:include page="map.jsp"></jsp:include>
		<jsp:include page="bar.jsp"></jsp:include>
		<br>
		<hr>
		<div id="d4">
			<c:forEach var="data" items="${files}">
					<video src="${data}" controls width="200px" height="100px" alt="资源路径错误,无法加载"></video>
					<%-- <img width="100px" height="100px" src="${data}" alt="图片路径错误,无法加载"/> --%>
			</c:forEach> 
		</div>
		<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>