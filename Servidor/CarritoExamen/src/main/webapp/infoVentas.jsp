<%-- 
    Document   : infoVentas
    Created on : 18 ene 2024, 13:08:35
    Author     : dw2
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.DaoExam"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
            <c:if test="${not empty param.ItemSelec && param.ItemSelec eq param.idItem}">
                <ul>         
             <c:forEach var="pedido" items="${sessionScope.pedidos}">
                 <li>
                     ${pedido.pedido.cliente.nombre}, ${pedido.pedido.fecha} &ensp;<b>${pedido.cantidad} uds.</b>
                 </li>  
             </c:forEach>
          </ul>
            </c:if>
    </body>
</html>
