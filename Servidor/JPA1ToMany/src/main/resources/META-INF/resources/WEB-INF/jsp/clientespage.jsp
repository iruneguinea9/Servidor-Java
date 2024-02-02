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

<c:forEach items="${clientes}" var="cliente">
	<tr>
		<td>${cliente.dni}</td>
		<td>${cliente.nombre}</td>
		<td>${cliente.email}</td>
		<td>
			<c:if test="${cliente.pedidos.size() > 0 }" >
				<table>
				<c:forEach items="${cliente.pedidos}" var="pedido">			
					<tr>
						<td>${pedido.total} €</td>
						<td>${pedido.fecha} €</td>					
					</tr>
				</c:forEach>	
				</table>
			</c:if>
			<c:if test="${cliente.pedidos.size() == 0 }" >
				SIN PEDIDOS
			</c:if>
		</td>
	</tr>
</c:forEach>
</table>






</body>
</html>