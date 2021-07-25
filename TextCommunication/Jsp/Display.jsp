<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="TextCommunication.property.User,TextCommunication.property.Coment,java.util.List"%>
<% User user = (User) session.getAttribute("user");
   List<Coment> comentList = (List<Coment>) application.getAttribute("coment");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		HERE IS MAIN PAGE!<br>
		ID:<%= user.getId()%><br>
		NAME:<%= user.getName()%><br>
		PASS:<%= user.getPass()%><br>
		LOGIN:<%= user.getLogin()%><br>
		<a href="/Beihic/JSP/Enter.jsp">BACK?</a>
		<div>
			<form action="/Beihic/ComentController" method="post">
				<input type="submit" value="RELOAD!">
			</form>
			<form action="/Beihic/LogoutController" method="post" >
				<input type="submit" value="LOGOUT!">
			</form>
		</div>
		<div>
			<form action="/Beihic/DisplayController" method="post">
				COMENT:<input type="text" name="coment">
				<input type="submit" value="submit">
			</form>
		</div>
		<div>
			<% for(Coment coment : comentList){%>
				<p>TIME:<%=coment.getTimestamp()%>
				ID:<%=coment.getId()%>
				NAME:<%=coment.getName()%><br>
				COMENT:<%=coment.getComent()%>
				</p>
			<%}%>
		</div>
	</body>
</html>
