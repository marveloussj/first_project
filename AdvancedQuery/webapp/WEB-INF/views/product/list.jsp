<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>货品显示列表</title>
</head>

<body>
	<h1>商品信息管理</h1>
	<table border="1" cellpadding="0" cellspacing="0" width="90%"
		style="text-align: center; background-color: #A52A2A;">
		<tr>
			<th>货品编号</th>
			<th>货品名称</th>
			<th>货品品牌</th>
			<th>货品分类</th>
			<th>供&nbsp;应&nbsp;商</th>
			<th>零&nbsp;售&nbsp;价</th>
			<th>成&nbsp;本&nbsp;价</th>
			<th>折&emsp;&emsp;扣</th>
		</tr>
		<c:forEach items="${list}" var="pro">
			<tr style="background-color: #FAEBD7;">
				<td>${pro.id}</td>
				<td>${pro.productName}</td>
				<td>${pro.brand}</td>
				<td>
					<c:choose>
						<c:when test="${pro.dir_id==2}">无线鼠标</c:when>
						<c:when test="${pro.dir_id==3}">有线鼠标</c:when>
						<c:when test="${pro.dir_id==4}">游戏鼠标</c:when>
					</c:choose>
				</td>
				<td>${pro.supplier}</td>
				<td>${pro.salePrice}</td>
				<td>${pro.costPrice}</td>
				<td>${pro.cutoff}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>