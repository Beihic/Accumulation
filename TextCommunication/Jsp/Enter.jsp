<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		<%@ include file="/JSP/Header.jsp"%>
		<div>
			<form action="/Beihic/LoginController" method="post">
				ID:<input type="number" name="id"><br>
				PASS:<input type="password" name="pass"><br>
				<input type="submit" value="SUBMIT">
			</form>
		</div>
		<a href="/Beihic/JSP/Register.jsp">REGISTER!</a>
		<%@ include file="/JSP/Footer.jsp"%>
	</body>
</html>
