<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="TextCommunication.property.User" %>
<% User user = (User) session.getAttribute("user");%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		ERROR PAGE!<br>
		ID:<%=user.getId() %><br>
		PASS:<%=user.getPass()%><br>
		LOGIN:<%=user.getLogin()%><br>
		<a href="/Beihic/JSP/Enter.jsp">BACK!</a>
	</body>
</html>
