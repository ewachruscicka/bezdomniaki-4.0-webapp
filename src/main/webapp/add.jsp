<%@page
	import="org.junit.internal.runners.model.EachTestNotifier,pl.bezdomniaki.*,pl.bezdomniaki.dao.*,pl.bezdomniaki.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorator="layout">

<%@include file="header.jsp"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bezdomniaki</title>
</head>

<body bgcolor="dee4ea">
	<div align="center">
		<h1>
			Dodawanie nowego psa <span id="the-title" layout:fragment="pageTitle" />
		</h1>
		<form action="Dodaj" method="get">
			<table border="1" cellpadding="5">
				<tr>
					<td>Imię:</td>
					<td><input type="text" name="imie" /></td>
				</tr>
				<tr>
					<td>Data przyjęcia (dd-mm-rrrr):</td>
					<td><input type="text" name="dataPrzyjecia" /></td>
				</tr>
				<tr>
					<td>Id schroniska:</td>
					<td><input type="text" name="idSchroniska" /></td>
				</tr>
				<tr>
					<td>Numer chipa:</td>
					<td><input type="text" name="nrChipa" /></td>
				</tr>
			</table>
			<br />
			<br /> <input type="submit" value="Utwórz" />
		</form>

	</div>
</body>
</html>