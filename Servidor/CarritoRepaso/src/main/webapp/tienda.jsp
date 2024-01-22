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
	<h1>Tienda</h1>
	<c:if test="${productos == null}">
		<jsp:forward page="ServletAgregarLineaPedido"></jsp:forward>
	</c:if>
		<table>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Cantidad</th>
				<th>Añadir</th>
			</tr>
			<c:forEach items="${productos}" var="item">
                            <tr>
                                <td>${item.value.id}</td>
                                <td>${item.value.nombre}</td>
                                <td>${item.value.precio}</td>
                                
                                    <form action="ServletAgregarLineaPedido" method="post">
                                        <td><input type="number" name="inpCantidad" value="0"></td>
                                        <td>
                                        <input type="hidden" name="id" value='${item.value.id}'/>
                                        <input type="submit" value="Añadir al carro" name="btnAniadir"> </td>
                                    </form>
                               
                            </tr>
                         </c:forEach>

		</table>

	<form action="cesta.jsp">
		<button type="submit" name="btnVerCesta">Ver cesta</button>
	</form>
	<form action="checkout.jsp">
		<button type="submit" name="btnHacerPedido">Hacer pedido</button>
	</form>
	<form action="ServletListarPedidos">
		<button type="submit" name="btnPedidos">Mis pedidos</button>
	</form>
</body>
</html>