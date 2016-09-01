<%@page
	import="org.junit.internal.runners.model.EachTestNotifier,pl.bezdomniaki.*,pl.bezdomniaki.dao.*,pl.bezdomniaki.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorator="layout">

<head>
<title>Bezdomniaki</title>
</head>

<body bgcolor="dee4ea">
	<div align="center">
		<h1>
			Bezdomniaki - logowanie <span id="the-title"
				layout:fragment="pageTitle" />
		</h1>
		<form action="search.jsp" method="post">
			Login: <input type="text" name="login" value="" /><br />
			<br /> Hasło: <input type="password" name="password" value="" /><br />
			<br /> <input type="submit" value="Zaloguj" />
		</form>
	</div>
</body>
</html>
