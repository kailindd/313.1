<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/loginServlet"
		method="post">
				<table border="1" cellspacing="0" width="500xp" height="200xp" cellpadding="5" align="center">
			<tr>
				<td colspan="2" align="center">登陆界面</td>
			</tr>
			<tr>
				<td>请输入姓名：</td>
				<td><input type="text" name="name"></input>  </td>
			</tr>
			
			<tr>
			    <td></td>
				<td><input type="submit" value="登陆"></input> </td>
			</tr>
		</table>
	</form>

</body>
</html>