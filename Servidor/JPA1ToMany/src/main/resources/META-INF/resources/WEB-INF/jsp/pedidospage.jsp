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

<c:forEach items="${pedidos}" var="pedido">
	<tr>
		<td>${pedido.id}</td>
		<td>${pedido.total}</td>
		<td>${pedido.fecha}</td>
		<td>${pedido.cliente.dni }</td>
		<td>${pedido.cliente.nombre }</td>
		<td>${pedido.cliente.email }</td>
	</tr>
</c:forEach>
</table>






</body>
</html>