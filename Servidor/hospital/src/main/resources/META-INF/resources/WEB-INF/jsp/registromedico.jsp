<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar médico</title>
</head>
<body>
	<h1>REGISTRO</h1>
	<form method="post" action="/registrarMedico/${medico.id}">
		<table>
			
			<tr>
				<td>NOMBRE</td> <td>${medico.nombre}</td>
			</tr>
			<tr>
				<td>ESPECIALIDAD</td> <td>${medico.especialidad}</td>
			</tr>
			<tr>
				<td>USER</td>
				<td>
					<input type="text" name="user"/>
				</td>
			</tr>
			<tr>
				<td>PASSWD</td> 
				<td>
					<input type="password" name="password"/>
				</td>
				<td>REPITE PASSWD</td> 
				<td>
					<input type="password" name="password2"/>
				</td>
			</tr>			
		</table>
		<input type="submit" name="submitRegistrar" value="REGISTRAR" />
		</form>
</body>
</html>