<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>tienda</title>
</head>
<body>
	<h1>Carro</h1>
        <c:set var="total" value="${0}"/>
	<c:if test="${carro == null}">
		<jsp:forward page="ServletUpdateLineaPedido"></jsp:forward>
	</c:if>
	<form action="ServletUpdateLineaPedido" method="post">
		<table>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Num</th>
			</tr>
			<c:forEach var="entry" items="${carro.getLineasPedido()}">
                            <tr>
                                <td><c:out value="${entry.id}"/></td> <!-- Id -->
                                <td><c:out value="${entry.item.nombre}"/></td> <!-- Nombre -->
                                <td><c:out value="${entry.item.precio}"/></td> <!-- Precio -->
                                <td><c:out value="${entry.cantidad}"/></td> <!-- Num -->
                            </tr>
                           <c:set var="total" value="${total + entry.cantidad * entry.item.precio}"/>
                         </c:forEach>
                        <tr>
                           <td colspan="3" align="right"><strong>Total:</strong></td>
                           <td><strong><c:out value="${total}"/></strong></td>
                        </tr>

		</table>
	</form>
</body>
</html>