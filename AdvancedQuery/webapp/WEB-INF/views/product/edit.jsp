<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>货品编辑界面</title>
</head>
<body>
	<h1>货品编辑</h1>
	<form
		action="${pageContext.request.contextPath}/product?cmd=saveOrUpdate"
		method="post">
		<!-- 隐藏域,将id的值隐藏在表单中提交到后台 -->
		<input type="hidden" name="id" value="${pro.id}" />
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>货品名称</td>
				<td><input type="text" name="productName"
					value="${pro.productName}" /></td>
			</tr>
			<tr>
				<td>货品品牌</td>
				<td><input type="text" name="brand" value="${pro.brand}" /></td>
			</tr>
			<tr>
				<td>供&nbsp;应&nbsp;商</td>
				<td><input type="text" name="supplier" value="${pro.supplier}" /></td>
			</tr>
			<tr>
				<td>零&nbsp;售&nbsp;价</td>
				<td><input type="text" name="salePrice"
					value="${pro.salePrice}" /></td>
			</tr>
			<tr>
				<td>成&nbsp;本&nbsp;价</td>
				<td><input type="text" name="costPrice"
					value="${pro.costPrice}" /></td>
			</tr>
			<tr>
				<td>折&emsp;&emsp;扣</td>
				<td><input type="text" name="cutoff" value="${pro.cutoff}" /></td>
			</tr>
			<tr>
				<td>货品分类</td>
				<td><select name="dir_id">
						<option value="2" ${pro.dir_id==2?"selected='selected'":""}>无线鼠标</option>
						<option value="3" ${pro.dir_id==3?"selected='selected'":""}>有线鼠标</option>
						<option value="4" ${pro.dir_id==4?"selected='selected'":""}>游戏鼠标</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
</body>
</html>