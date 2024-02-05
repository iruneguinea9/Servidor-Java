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
			
				<td>${consulta.idpaciente}</td>
				<td>${consulta.fecha}</td>
				<td>${consulta.motivo}</td>	
				
				<c:choose>
						<c:when test="${consulta.esFechaPasada()}">
							<td></td><td><a href="/anular/${consulta.id}">ANULAR</a> </td>
						</c:when>
						<c:otherwise>
							<form method="post" action="/guardarDiagnostico">
								<input type="hidden" name="idConsulta" value="${consulta.id}"/>
								<td><input type="text" name="diagnosticoInput" placeholder="${consulta.diagnostico}" /></td>
								<td><input type="submit" name="guardarDiagnostico" value="GUARDAR"/></td>
							</form>		
						</c:otherwise>
					</c:choose>
					
				
						 
		</tr>
		</c:forEach>
	</table>
</body>
</html>