<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medicos jsp</title>
</head>
<body>
	<table>
	<tr>
		<th>NOMBRE</th>
		<th>ESPECIALIDAD</th>
		<th>ESTADO_REGISTRO</th>
	</tr>
	<c:forEach items="${medicos}" var="medico">
	<tr>
	
		<td>${medico.nombre}</td>
		<td>${medico.especialidad}</td>
		<c:if test="${(medico.user==null)&&(medico.password==null)}">
			<td><a href="/registrar/${medico.id}">REGISTRAR</a></td>
		</c:if>
		<c:if test="${!((medico.user==null)&&(medico.password==null))}">
			<td>Registrado</td>
		</c:if>
		

	</tr>
	</c:forEach>
	</table>

</body>
</html>