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
	<tr>
		<th>TITULO</th>
		<th>AFORO</th>
		<th>FECHA</th>
		<th>ASISTENTES</th>
		<th></th>
	</tr>
	<c:forEach items="${mapaPonencias}" var="ponencia">
		<tr>
			<td>${ponencia.key.titulo}</td>
			<td>${ponencia.key.aforo}</td>
			<td>${ponencia.key.fecha}</td>
			<td>${ponencia.value} asistentes</td>
			<td><a href="/organizarPonencia/${ponencia.key.titulo}">ORGANIZAR PONENCIA</a></td>
		</tr>
	</c:forEach>
	<tr>
		<form:form  method="post" action="nuevaPonencia" modelAttribute="ponencia">	
		<td><form:input path="titulo"/></td>
		<td><form:input path="aforo"/></td>
		<td><form:input path="fecha"/></td>
		<td>0 asistentes    <input type="submit" name="nuevaPonencia" value="AÑADIR"></td>
		</form:form>
	</tr>
	
	</table>
</body>
</html>