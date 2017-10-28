<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${stu==null?"添加":"编辑"}学生</title>
</head>
<body>
<h1>${stu==null?"添加":"编辑"}学生</h1>
<form action="${pageContext.request.contextPath}/student?cmd=saveOrUpdate" method="post">
<input name="id" type="hidden" value="${stu.id}"><br/>
姓名:<input name="name" value="${stu.name}" required><br/>
年龄:<input name="age" type="number" value="${stu.age}" required><br/>
<input type="submit" value='${stu==null?"添加":"编辑"}学生'>

</form>

</body>
</html>