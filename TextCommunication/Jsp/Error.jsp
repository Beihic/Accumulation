<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="TextCommunication.property.User" %>
<% User user = (User) session.getAttribute("user");%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel=stylesheet href="JSP/css/Header.css">
		<link rel=stylesheet href="JSP/css/Footer.css">
		<link rel=stylesheet href="JSP/css/Base.css">
		<title>ErrorPage</title>
	</head>
	<body>
		<%@ include file="/JSP/Header.jsp"%>
		<div>
			ERROR PAGE!<br>
			ID:<%=user.getId() %><br>
			PASS:<%=user.getPass()%><br>
			LOGIN:<%=user.getLogin()%><br>
			<a href="/Beihic/JSP/Enter.jsp">BACK!</a>
		</div>
		<%@ include file="/JSP/Footer.jsp"%>
	</body>
</html>
