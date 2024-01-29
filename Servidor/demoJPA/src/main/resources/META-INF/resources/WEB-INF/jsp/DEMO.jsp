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

<c:forEach items="${todosviajeros}" var="viajero">
	<tr>
		<td>${viajero.nombre}</td>
		<td>${viajero.edad}</td>
		<td>${viajero.pais}</td>
	</tr>
</c:forEach>
</table>


<h2>NUEVO VIAJERO</h2>

<table>
		<form:form  method="post" action="aniadirViajero" modelAttribute="viajero">	
			<tr>
				<td><form:input path="nombre"/></td>
				<td><form:errors path="nombre" /></td>
			</tr>
			<tr>
				<td><form:input path="edad"/></td>	
				<td><form:errors path="edad" /></td>
			</tr>
			<tr>
				<td><form:select path="pais" items="${arrPaises}" 
									itemLabel="nombre" 
									itemValue="codigo"/> 
									 </td>	
				<td><form:errors path="pais" /></td>
			</tr>
			<tr><td><input type="submit" name="aniadirviajero" value="AÑADIR" /></td></tr>
		
		</form:form>
</table>		



</body>
</html>