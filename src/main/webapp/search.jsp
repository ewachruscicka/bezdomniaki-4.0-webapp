<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%
if (request.getMethod().equals("POST")){
	if (request.getMethod().equals("POST") && request.getParameter("login") != "" && request.getParameter("password") != "") {
		request.getSession().setAttribute("user", request.getParameter("login"));
	} 
	else {
		response.sendRedirect("login.jsp");
	}
}
%>

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorator="layout">

<head>
<title>Bezdomniaki</title>
</head>

<body bgcolor="dee4ea">
	<%@include file="header.jsp"%>
	<div align="center">
		<h1>
			Wyszukiwarka psów <span id="the-title" layout:fragment="pageTitle" />
		</h1>
		<form action="list2.jsp" method="post">
			Wpisz nazwę miejscowości: <input type="text" name="city" value="" /><br />
			<br /> <input type="submit" value="Szukaj" />
		</form>
	</div>
</body>

</html>
