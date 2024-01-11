<%-- 
    Document   : devoluciones
    Created on : 9 ene 2024, 13:21:23
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
        <h1>Libros sin devolver</h1>
        <table>
            <c:forEach var="sinDevolver" items="${sessionScope.sinDevolver}">
                <tr>
                    <td>${sinDevolver.titulo}, ${sinDevolver.getDiasPrestado()} dias prestado</td>
                    <td>
                        <a href="ServletDevolver?accion=marcar&id=${sinDevolver.id}">MARCAR DEVOLUCIÓN</a>
                    </td>
                </tr>        
            </c:forEach>
        </table>
        <c:if test="${not empty sessionScope.marcadosDevolver}">
           <p>prueba</p>
        </c:if>
    </body>
</html>
