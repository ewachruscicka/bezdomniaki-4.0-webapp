<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
	if (request.getParameter("login") != null && request.getParameter("password") != null) {
		request.getSession().setAttribute("user", request.getParameter("login"));
		response.sendRedirect("search.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bezdomniaki</title>
</head>
<body>
</body>
</html>