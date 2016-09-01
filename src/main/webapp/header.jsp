<%@page import="org.junit.internal.runners.model.EachTestNotifier,pl.bezdomniaki.*,pl.bezdomniaki.dao.*,pl.bezdomniaki.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorator="layout">
	
<html>
<body>
	<div align="right">
		<h5>Jesteś zalogowany jako:</h5>
		<%
			out.println((String) session.getAttribute("user"));
		%>
		<hr>
		<a href='logout.jsp'>Wyloguj</a><br/>
	</div>
</body>
</html>