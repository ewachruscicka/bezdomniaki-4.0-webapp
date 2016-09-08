<%@page import="org.junit.internal.runners.model.EachTestNotifier,pl.bezdomniaki.*,pl.bezdomniaki.dao.*,pl.bezdomniaki.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

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
			Znalezione psy: <span id="the-title" layout:fragment="pageTitle" />
		</h1>
	</div>
	<div align="center"layout:fragment="content">
		<br />
		<Br />
		<table border="1" cellpadding="5">
			<tr>
				<th></th>
				<th>Id</th>
				<th>Imię</th>
				<th>Data przyjęcia</th>
				<th>Nr chipa</th>
				<th>Nazwa schroniska</th>
				<th>Miejscowość</th>
			</tr>
			<%
			String miejscowosc = request.getParameter("city");
			BezdomniakiDTO bezdomniaki = new BezdomniakiDTO();
			Pies[] listaPsow = bezdomniaki.getPsy(miejscowosc);
		%>
			<% 
			int i=0;
				for (Pies pies : listaPsow) { %>
			<tr>
				<td><%= i+1%></td> 
				<td><%=pies.getId()%></td>
				<td><%=pies.getImie()%></td>
				<td><%=pies.getDataPrzyjecia()%></td>
				<td><%=pies.getNrChipa()%></td>
			</tr>
			<%
			i++;}
			%>
		</table>
		<br/>
		<a href='search.jsp'>Powrót do wyszukiwania</a><br/>

	</div>
</body>

</html>