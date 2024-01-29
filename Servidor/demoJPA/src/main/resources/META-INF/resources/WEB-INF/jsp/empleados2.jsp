<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>

<c:forEach items="${empleados}" var="empleado">
	<tr>
	<form method="post" action="/subirSueldo/${empleado.id}">
		<td>${empleado.id}</td>
		<td>${empleado.nombre}</td>
		<td>${empleado.salario}</td>
		<td>${empleado.fecha_alta}</td>
		<td>${empleado.ciudad}</td>
		<td>${empleado.region}</td>
		<td>
			<select name="porc" />
				<option value="10">10%</option>
				<option value="20">20%</option>
				<option value="50">50%</option>
			</select>
		</td>
		<td><input type="submit" name="submitSubirSalario" value="SUBIR SALARIO" />
	</form>
	</tr>
</c:forEach>

	

</table>



</body>
</html>