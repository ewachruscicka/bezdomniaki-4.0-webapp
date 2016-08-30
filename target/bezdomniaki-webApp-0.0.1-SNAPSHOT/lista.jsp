<%@page import="org.junit.internal.runners.model.EachTestNotifier,pl.bezdomniaki.*,pl.bezdomniaki.dao.*,pl.bezdomniaki.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorator="layout">

<head>
<title>Wyświetl psy</title>
</head>

<body bgcolor="dee4ea">
	<div align="center">
		<h1>
			Znalezione psy: <span id="the-title" layout:fragment="pageTitle" />
		</h1>
	</div>
	<div align="center"layout:fragment="content">
		<br />
		<Br />
		<table border="1" cellpadding="5">
		<%
		
		BezdomniakiDTO bezdomniaki = new BezdomniakiDTO();
		String miejscowosc = request.getParameter("city");
		out.write("<p>"+miejscowosc+"</p>");
		Pies [] listaPsow = bezdomniaki.getPsy(miejscowosc);
		
		%>
			<tr>
				<th>Id</th>
				<th>Imię</th>
				<th>Data przyjęcia</th>
				<th>Nr chipa</th>
				<!--  <th>Nazwa schroniska</th>
				<th>Miejscowość</th>-->
			</tr>
			<% for (Pies pies : listaPsow) { %>
			<tr>
				<td><%= pies.getId()%></td>
				<td><%= pies.getImie()%></td>
				<td><%= pies.getDataPrzyjecia()%></td>
				<td><%= pies.getNrChipa()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<br />
		<a href='index.jsp'>Powrót do wyszukiwania</a><br />
		<br />

	</div>
</body>
</html>