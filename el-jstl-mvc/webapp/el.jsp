<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
pageContext.setAttribute("msg","pageContext");
//request.setAttribute("msg","request");
session.setAttribute("msg","session");
application.setAttribute("msg","application");

%>
pageContext:${pageScope.msg}<br/>
requestContext:${requestScope.msg}<br/>
sessionContext:${sessionScope.msg}<br/>
applicationContext:${applicationScope.msg}<hr/>
<!-- <%=pageContext.findAttribute("msg")==null?"":pageContext.findAttribute("msg") %><br/>${msg} -->


</body>
</html>