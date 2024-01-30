<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONSULTAS</title>
</head>
<body>
	<c:out value="${sessionScope.medico.getNombre()} - ${sessionScope.medico.getEspecialidad()}"/>

	<h2>TUS CONSULTAS</h2>
	
	<table>
		<tr>
			<th>DNI PACIENTE</th>
			<th>FECHA</th>
			<th>MOTIVO</th>
			<th>DIAGNÓSTICO</th>
			<th></th>
		</tr>
		<c:forEach items="${consultas}" var="consulta">
		<tr>
			<form method="post" action="/guardarConsulta">
				<td>${consulta.dni}</td>
				<td>${consulta.fecha}</td>
				<td>${consulta.motivo}</td>	
				<td></td>		
				<td><input type="submit" name="guardarDiagnostico" value="GUARDAR"/></td>
			</form>					 
		</tr>
		</c:forEach>
	</table>
</body>
</html>