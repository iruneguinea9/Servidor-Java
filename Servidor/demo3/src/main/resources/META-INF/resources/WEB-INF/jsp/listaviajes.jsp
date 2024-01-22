<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<th>LUGAR</th>
		<th>DIAS</th>
		<th>KMS</th>
	</tr>
	<c:forEach items="${lstviajes}" var="viaje">
		<tr>
			<td>${viaje.lugar}</td>
			<td>${viaje.dias}</td>
			<td>${viaje.kms}</td>
			<td><a href="/borrarViaje?lugar=${viaje.lugar}">BORRAR VIAJE</a></td>
			<td><a href="/editarViaje?lugar=${viaje.lugar}">EDITAR VIAJE</a></td>
		</tr>
	</c:forEach>
	<tr>
		<form method="post" action="/nuevoviaje">
			<td><input type="text" name="lugar"></td>
			<td><input type="number" name="dias"></td>
			<td><input type="number" name="kms"></td>
			<td><input type="submit" name="nuevoviaje" value="AÑADIR"></td>
		</form>
	</tr>
</table>
${erroraniadir}
</body>
</html>