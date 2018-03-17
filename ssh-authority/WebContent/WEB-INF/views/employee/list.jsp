<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/authority/basic_layout.css" rel="stylesheet" type="text/css">
<link href="style/authority/common_style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
<script type="text/javascript" src="js/jquery/jquery.js"></script>
<script type="text/javascript" src="js/authority/commonAll.js"></script>
<script type="text/javascript" src="js/artDialog/artDialog.js?skin=blue"></script>
<script type="text/javascript" src="js/system/userinfo.js"></script>
<script type="text/javascript" src="js/common_page.js"></script>
<title>PSS-账户管理</title>
<style>
	.alt td{ background:black !important;}
</style>
</head>
<body>
	<s:form id="searchForm" action="employee" method="post">
		<div id="container">
			<div class="ui_content">
				<div class="ui_text_indent">
					<div id="box_border">
						<div id="box_top">搜索</div>
						<div id="box_center">
							姓名/邮箱
							<s:textfield cssClass="ui_input_txt02" name="queryObject.keyword" />
							所属部门
							<s:select list="#depts"  listKey="id" listValue="name" name="queryObject.deptId" cssClass="ui_select01" headerKey="-1" headerValue="--全部--"></s:select>
							</div>
						<div id="box_bottom">
							<input type="button" value="查询" class="ui_input_btn01 page_btn"/>
							<input type="button" value="新增" class="ui_input_btn01 btn_input" data-href='<s:url action="employee_input" />'/> 
					
						</div>
					</div>
				</div>
			</div>
			<div class="ui_content">
				<div class="ui_tb">
					<table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
						<tr>
							
							<th>编号</th>
							<th>用户名</th>
							<th>EMAIL</th>
							<th>年龄</th>
							<th>部门</th>
							<th>角色</th>
							<th></th>
						</tr>
						
						<tbody>
							<s:iterator value="#result.result" var="u">
								<tr>
									<td><s:property value="#u.id"/></td>
									<td><s:property value="#u.userName"/></td>
									<td><s:property value="#u.email"/></td>
									<td><s:property value="#u.age"/></td>
									<td><s:property value="#u.dept.name"/></td>
									<td><s:property value="#u.getRoleNames"/></td>
									<td>
										<s:a action="employee_input"><s:param name="employee.id" value="#u.id"/>编辑</s:a>
										<s:a action="employee_delete"><s:param name="employee.id" value="#u.id"/>删除</s:a>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<%@include file="../../views/common/common_page.jsp" %>
			</div>
		</div>
	</s:form>
</body>
</html>
