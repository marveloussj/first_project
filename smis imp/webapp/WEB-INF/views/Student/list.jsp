<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理系统</title>
</head>
<body>
	<h1>学生管理系统</h1>
	欢迎:${sessionScope.USER_IN_SESSION.username}<br/>
	<a href="/login.jsp">注销(安全退出)</a><br/>
	<a href="/student?cmd=edit">添加学生</a>
	<form action="/student" method="post">
	姓名:<input name="studentName" value=${ qo.studentName}>
	年龄<input name="minAge" type="number" value=${ qo.minAge}>
	~<input name="maxAge" type="number" value=${ qo.maxAge}>
	<input type="submit" value = "查询">
	</form>
	<table border="1" width="70%" cellpadding="0" cellspacing="0">

		<tr>
			<th>序号</th>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="stu" varStatus="vs">
			<tr style="background: ${vs.count%2==0?'gray':''}">
				<td>${vs.count}</td>
				<td>${stu.id}</td>
				<td>${stu.name}</td>
				<td>${stu.age}</td>
				<td><a href="/student?cmd=edit&id=${stu.id}">编辑</a>|<a href="/student?cmd=delete&id=${stu.id}">删除</a></td>
			</tr>
		</c:forEach>



	</table>
</body>
</html>