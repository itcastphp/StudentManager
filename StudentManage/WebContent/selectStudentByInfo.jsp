<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.List" import="com.qfedu.domain.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	table,th,td,tr{
		border: 1px solid black;
		border-collapse: collapse;
	}
	div{
		margin:0 500px;
	}
</style>
<script type="text/javascript">
	onload=function(){
		var tbody=document.getElementsByTagName("tbody")[0];
		var as=document.getElementsByTagName("a");
		for(var i=0;i<as.length;i++){
			as[i].onclick=function(){
				var tr=this.parentNode.parentNode;
				tbody.removeChild(tr);
				var td=tr.childNodes[1];
				var sid=td.innerText;
				this.setAttribute("href","/StudentManage/deleteStudentBySid?sid="+sid);
			}
		}
	}
</script>
</head>
<body>
	<div>
	<form action="/StudentManage/selectStudentByInfo">
		<h2>根据姓名和性别进行模糊查询</h2>
		<input type="text" name="info" placeholder="请输入关键字"/>
		<input type="submit" value="提交">
	</form>
	<%
		List<Student> students=(List<Student> )request.getAttribute("students");
	%>
	<table>
		<thead>
			<%
				if(students!=null&&students.size()>0){
			%>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>删除</th>
			<%
				}
			%>
		</thead>
		<tbody>
			<%
				for(int i=0;students!=null&&i<students.size();i++){
					Student student=students.get(i);
			%>
			<tr>
				<td><%=student.getSid() %></td>
				<td><%=student.getSname() %></td>
				<td><%=student.getSage() %></td>
				<td><%=student.getSsex() %></td>
				<td><a href="/StudentManage/deleteStudentBySid">删除</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	</div>
</body>
</html>