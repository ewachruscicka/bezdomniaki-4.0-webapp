<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page
	import="org.junit.internal.runners.model.EachTestNotifier,pl.bezdomniaki.*,pl.bezdomniaki.dao.*,pl.bezdomniaki.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
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
			<font color="red"><%=	request.getAttribute("komunikat")%></font> <br>
			Znalezione psy (TagLibs): <span id="the-title"
				layout:fragment="pageTitle" />
		</h1>
	</div>
	<div align="center" layout:fragment="content">

		<%
			Pies[] listaPsow = (Pies[]) request.getAttribute("listaPsow");
		%>

		<br /> <Br />
		<table border="1" cellpadding="5">

			<tr>
				<th></th>
				<th>Id</th>
				<th>Imie</th>
				<th>Data przyjecia</th>
				<th>Nr chipa</th>
				<th></th>
				<th></th>
			</tr>

			<c:forEach var="pies" items="${listaPsow}" varStatus="loopCounter">
				<td>${loopCounter.count}</td>
				<td>${pies.getId()}</td>
				<td>${pies.getImie()}</td>
				<td>${pies.getDataPrzyjecia()}</td>
				<td>${pies.getNrChipa()}</td>
				<td><input type="button" name="edit" value="Edytuj" onclick="Edytuj(${pies.getId()});" ></td>
				<td><input type="button" name="delete" value="Usuń" onclick="Usun(${pies.getId()});" ></td>
				</tr>
			</c:forEach>

		</table>
		<br /> <a href='add.jsp'>Dodaj psa</a><br /> <br /> <a
			href='search.jsp'>Powrót do wyszukiwania</a><br />
	</div>
</body>

</html>