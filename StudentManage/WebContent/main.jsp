<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
			 *{
				margin: 0;
				padding: 0;
			}
			#d{
				width: 700px;
				margin: 0 auto;
			}
			#d1{
				position: relative;
				width: 500px;
				height:460px;
				margin: 0 auto;
				background-color: #BAF0FB;
				margin-bottom: 20px;
			}
			#d2{
				background-color: aqua;
				width: 300px;
				height: 280px;
				margin: 10px auto;
				display: none;
				position: relative;
			}
			table{
				margin: 0 auto;
			}
			table,thead,tbody,tr,td,th{
				border-collapse: collapse;
				border: 1px black solid;
				
			} 
		 	td,th{
				width: 70px;
			} 
			input{
				margin: 20px 50px;
			}
			.none{
				border: 1px black solid;
				background-color:violet;
				height: 25px;
				width: 25px;
				position: absolute;
				top: 0;
				right: 0;
			}
			.search{
				position: absolute;
				top: 0;
				right: 0;
			}
			h3{
				margin-left:100px;
				display: inline-block;
			}
		</style>
</head>
<body>
	<jsp:include page="map.jsp"></jsp:include>
	<jsp:include page="bar.jsp"></jsp:include>
	
	<c:if test="${ not empty username}">
	<h3>欢迎：</h3>
	<div id="d">
	<div style="width:100px; height:100px; border-radius:50%; overflow:hidden; margin-right: 20px">
		<c:if test="${not empty info}">
			<img width="100px" height="100px" src="${info}" alt="图片路径错误,无法加载"/>
		</c:if>
	</div>
	
	
	<div id="d1">
		<button class="add">添加</button>
		<button class="search"><a href="${pageContext.request.contextPath}/limitSelectStudentAction?startPage=1">查询</a></button>
			<c:if test="${not empty page.students}">
			<table>
				<thead>
					<th>sid</th>
					<th>姓名</th>
					<th>年龄</th>
					<th>性别</th>
					<th>操作</th>
				</thead>
				<tbody>
				<c:forEach var="student" items="${page.students}">
				<tr>
					<td>${student.sid}</td>
					<td>${student.sname}</td>
					<td>${student.sage}</td>
					<td>${student.ssex}</td>
					<td><a href="#">删除</a></td>
				</tr>
				</c:forEach>
				</tbody>	
			</table>
			
			<center>
			<c:if test="${page.thisPage!=1}">
				<a href="${pageContext.request.contextPath}/limitSelectStudentAction?startPage=1">首页</a>
				<a href="${pageContext.request.contextPath}/limitSelectStudentAction?startPage=${page.thisPage-1}">上一页</a>
			</c:if>
			<span>${page.thisPage}</span>	
			<c:if test="${page.thisPage!=page.endPage}">
				<a href="${pageContext.request.contextPath}/limitSelectStudentAction?startPage=${page.thisPage+1}">下一页</a>
				<a href="${pageContext.request.contextPath}/limitSelectStudentAction?startPage=${page.endPage}">尾页</a>
			</c:if>
			</center>
			
			</c:if>
			
			<div id="d2">
				<button class="none">X</button>
				<form action="${pageContext.request.contextPath}/addStudentServlet">
					<input type="text" placeholder="请输入学号" name="sid"/><br />
					<input type="text" placeholder="请输入姓名" name="sname"/><br />
					<input type="text" placeholder="请输入年龄" name="sage"/><br />
					<input type="radio" name="sex" value="男" />男
					<input type="radio" name="sex" value="女"/>女<br />
					<input type="submit" id="ok" value="添加">
				</form>
			</div>
			
	</c:if>
</body>

<script type="text/javascript">
		var btn=document.getElementsByClassName("add")[0];
		var d2=document.getElementById("d2");
		btn.onclick=function(){
			d2.style.display="block";
		}
		var ok=document.getElementById("ok");
		var none=document.getElementsByClassName("none")[0];
		var tbody=document.getElementsByTagName("tbody")[0];
		var inputs= document.getElementsByTagName("input");
		ok.onclick=function(){
			d2.style.display="none";
			var tr=document.createElement("tr");
			for(var i=0;i<3;i++){
				var td=document.createElement("td");
				td.innerText=inputs[i].value;
				tr.appendChild(td);
			}
			var count=0;
			var sex=document.getElementsByName("sex");
			for(var i=0;i<sex.length;i++){
				if(sex[i].checked){
					var td=document.createElement("td");
					var value=sex[i].value;
					td.innerText=value;
					tr.appendChild(td);
					count=1;
				}
			
			}
			if(count==0){
				alert("请选择性别，否则不能提交");
				d2.style.display="block";
				return;
				
			}
			var td=document.createElement("td");
			td.innerHTML="<a href='#'>删除</a>";
			tr.appendChild(td);
			tbody.appendChild(tr);
			
			var removes=document.getElementsByTagName("a");
			for(var i=1;i<removes.length;i++){
				removes[i].onclick=function(){
					var tr=this.parentNode.parentNode;
					tbody.removeChild(tr);
					var td=tr.childNodes[0];
					var sid=td.innerText;
					this.setAttribute("href","/StudentManage/deleteStudentBySid?sid="+sid);
				}
			} 
		}
		var removes=document.getElementsByTagName("a");
		for(var i=1;i<removes.length;i++){
			removes[i].onclick=function(){
				var tr=this.parentNode.parentNode;
				tbody.removeChild(tr);
				var td=tr.childNodes[1];
				var sid=td.innerText;
				this.setAttribute("href","/StudentManage/deleteStudentBySid?sid="+sid);
			}
		} 
		none.onclick=function(){
			d2.style.display="none";
		}
		
		//轮播图
		num=1;
		function changeimg(num){
			var target= document.getElementById("lunbo");
			if(num==1){
				target.setAttribute("src","img/01-3.jpg");
			}else if(num==2){
				target.setAttribute("src","img/01-4.jpg");
			}else{
				target.setAttribute("src","img/01-1.jpg");
			}
		}
		function test(){
			changeimg(num);
			num++;
			if(num==4){
				num=1;
			} 
		
		}
		setInterval("test()",2000);
	</script>
</html>
