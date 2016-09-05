<%@page	import="org.junit.internal.runners.model.EachTestNotifier,pl.bezdomniaki.*,pl.bezdomniaki.dao.*,pl.bezdomniaki.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
	
<%  request.getSession().invalidate();%>

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorator="layout">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bezdomniaki</title>
</head>
<body>
	<div align="center">
		<h1>
			Zostałeś wylogowany! <span id="the-title" layout:fragment="pageTitle" />
		</h1>
		<a href='login.jsp'>Zaloguj ponownie</a><br/>
	</div>
</body>
</html>