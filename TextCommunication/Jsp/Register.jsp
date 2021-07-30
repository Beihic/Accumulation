<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel=stylesheet href="css/Header.css">
		<link rel=stylesheet href="css/Footer.css">
		<link rel=stylesheet href="css/Base.css">
	</head>
	<body>
		<%@ include file="/JSP/Header.jsp"%>
		<form action="/Beihic/RegisterController" method="post">
			ID:<input type="number" name="id"><br>
			NAME:<input type="text" name="name"><br>
			PASS:<input type="password" name="pass"><br>
			CONFIRM PASS:<input type="password" name="conPass" ><br>
			<input type="submit" value="REGISTER!">
		</form>
		<a href="/Beihic/JSP/Enter.jsp">BACK!</a>
		<%@ include file="/JSP/Footer.jsp"%>
	</body>
</html>
