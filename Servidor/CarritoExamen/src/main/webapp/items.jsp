<%-- 
    Document   : items
    Created on : 18 ene 2024, 12:38:45
    Author     : dw2
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ITEMS POR VENTAS</h1>
        
         <table>
            <tr>
                <th>ITEM</th>
		<th>PRECIO</th>
                <th>VENTAS</th>
            </tr>
            <c:forEach items="${sessionScope.mapaItems}" var="par">
                <%-- mapaItems tiene HashMap<Item,Integer> --%>
                <tr>
                    <td><c:out value="${par.key.getNombre()}"/></td>
                    <td><c:out value="${par.key.getPrecio()}"/>€</td>
                    <td><a href="ServletItems?ItemSelec=${par.key.getId()}"><c:out value="${par.value}"/> uds.</a>
                    
                               <jsp:include page="infoVentas.jsp?idItem=${par.key.getId()}" />

                    </td>
                    
                    </td>                    
                </tr>                
            </c:forEach>
         </table>
    </body>
</html>
