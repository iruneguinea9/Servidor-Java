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
        <ol>
        <c:forEach var="sinDevolver" items="${sessionScope.sinDevolver}">
            <li>${sinDevolver.titulo} dias prestado</li>
        </c:forEach></ol>
    </body>
</html>
