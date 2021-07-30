<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel=stylesheet href="css/Header.css">
		<link rel=stylesheet href="css/Footer.css">
		<link rel=stylesheet href="css/Base.css">
		<link rel=stylesheet href="css/Enter.css">
		<title>Beihic</title>
	</head>
	<body>
		<%@ include file="/JSP/Header.jsp"%>
		<div>
			<div id="TCheader">TextCommunication</div>
			<form action="/Beihic/LoginController" method="post">
				ID:<input type="number" name="id"><br>
				PASS:<input type="password" name="pass"><br>
				<input type="submit" value="SUBMIT">
			</form>
		</div>
		<div id="register">
			<a href="/Beihic/JSP/Register.jsp">REGISTER!</a>
		</div>
		<%@ include file="/JSP/Footer.jsp"%>
	</body>
</html>
