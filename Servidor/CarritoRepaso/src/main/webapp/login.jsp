<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
</head>
<body>
	<h1>LOGIN</h1>
	<form method="post" action="ServletLogin">
	<table>
		<tr>
			<td><label>Email</label></td>
			<td><input name="email" type="text"></td>
		</tr>
		<tr>
			<td><label>Contraseña:</label></td>
			<td><input name="contra" type="password"></td>
		</tr>
	</table>
	<c:if test="${mensaje != null}">
		<p style="color:red;">${mensaje}</p>
	</c:if>
	<div>
		<input name="btnLogin" type="submit" value="Login">
		<input name="btnReset" type="reset" value="Reset">
		<a href="registro.jsp">REGISTRARSE</a>
	</div>		
	</form>
</body>
</html>