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
		<td>${empleado.id}</td>
		<td>${empleado.nombre}</td>
		<td>${empleado.salario}</td>
		<td>${empleado.fecha_alta}</td>
		<td>${empleado.ciudad}</td>
		<td>${empleado.region}</td>
	</tr>
</c:forEach>

	<tr>
		<form:form modelAttribute="nuevoEmpleado" method="post" action="aniadirEmpleado"  >
			<td></td>
			<td><form:input path="nombre"/></td>
			<td><form:input type="number" path="salario"/></td>
			<td><form:input type="date" path="fecha_alta"/></td>
			<td><form:select path="ciudad" items="${nombres_ciudades}"/></td>
			<td><form:radiobuttons path="region" items="${regiones}" value="N"/></td>
			<td><input type="submit" name="submitNuevoEmp" value="AÑADIR" />
		</form:form>
	</tr>



</table>



</body>
</html>