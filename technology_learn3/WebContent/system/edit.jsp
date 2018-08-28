<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改java菜单信息</title>
</head>
<body> 
	<!-- 上传图片是需要指定属性 enctype="multipart/form-data" -->
	<!-- <form id="itemForm" action="" method="post" enctype="multipart/form-data"> -->
	<form id="itemForm"	action="${pageContext.request.contextPath }/insertManager.action" method="post" enctype="multipart/form-data">
修改菜单信息：
		<table width="100%" border=1>
			<tr>
				<td>id</td>
				<td><input type="text" name="id" value="${menu.id }" /></td>
			</tr>
			<tr>
				<td>父id</td>
				<td><input type="text" name="pId" value="${menu.pId }" /></td>
			</tr>
			<tr>
				<td>名称</td>
				<td><input type="text" name="name" value="${menu.name }" /></td>
			</tr>
			<tr>
				<td>链接</td>
				<td>
					<input type="text"  name="page" value="${menu.page }"/>
				</td>
			</tr>
			<tr>
				<td>文件</td>
				<td>
					<input type="file"  name="FileName"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>

	</form>
</body>

</html>