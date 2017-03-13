<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="app.exam.fileEntity.filmEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>film_list</title>
</head>
<body>
	<%	Object user = request.getSession().getAttribute("user");
		if (user == null) {
			String msg = "请登录！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{%>
	<table border="1" cellspacing="0" cellpadding="5" align="left">
		<tr>
			<td >file_id</td>
			<td >title</td>
			<td >description</td>
			<td >name</td>
		</tr>
		<% List<filmEntity> list= (ArrayList<filmEntity>) request.getAttribute("list") ;
		   Iterator<filmEntity> it=list.iterator();
		   while(it.hasNext()){ 
			   filmEntity film=it.next();
		%>		
		<tr>
			<td ><%= film.getFilm_id() %></td>
			<td ><%= film.getTitle() %></td>
			<td ><%= film.getDescription() %></td>
			<td ><%= film.getLan().getName() %></td>
			<td ><a href="${pageContext.request.contextPath}/film_update.jsp?id=<%film.getFilm_id(); %>" >修改数据</a></td>
			<td ><a href="${pageContext.request.contextPath}/film_delServlet?id=<%film.getFilm_id(); %>" >删除数据</a></td>
		</tr>
		<%} %>
	</table>
		
		
		
		
		
		
		
		
       <%} %>
</body>
</html>