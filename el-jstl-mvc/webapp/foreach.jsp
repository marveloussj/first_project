<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  List list=new ArrayList();
list.add("fcc");
list.add("hlb");
list.add("sj");
request.setAttribute("list", list);

%>

<c:forEach items="${list}" var="item" varStatus="vs">
${vs.count}----${item}<br/>
</c:forEach>
</body>
</html>