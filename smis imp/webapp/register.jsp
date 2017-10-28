<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
<h1>用户注册</h1>
<form action="/register" method="post" enctype="multipart/form-data">
<input name="username" placeholder="用户名" required="required" /><br/>
<input type="file" name="headImg" /><br/>
<input type="submit" value="注册" /><br/>
</form>

</body>
</html>