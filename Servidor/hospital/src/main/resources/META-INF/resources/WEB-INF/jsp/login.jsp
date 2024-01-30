<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>LOGIN MEDICO</h1>
	<form method="post" action="/loginMedico">
	<table>	
		<tr>
			<td>USER</td>
			<td><input type="text" name="user"/></td>
		</tr>
		<tr>
			<td>PASSWD</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr><td><input type="submit" name="submitLogin" value="ENTRAR" /></td></tr>		
	</table>
	</form>
	<h3>${error}</h3>
</body>
</html>