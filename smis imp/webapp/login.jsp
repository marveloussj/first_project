<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<script type="text/javascript">
function changeCode(){
	document.getElementById("safecode").src="/codeutil?"+new Date().getTime();
}
</script>
</head>
<body>
<% 
	session.invalidate();
%>
<h1>用户登录</h1>
<span style="color: red">${errormsg}</span>
<form action="/login" method="post">
<input name="username" required placeholder="用户名"><br/>
<input name="password" type="password" required placeholder="密码"><br/>
<input name="safecode" placeholder="验证码" required> <img alt="" id ="safecode" src="/codeutil" onclick="changeCode()"><br/>
<input type="submit" value="登录">
</form>

</body>
</html>