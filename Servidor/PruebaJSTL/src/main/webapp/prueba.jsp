<%-- 
    Document   : prueba.jsp
    Created on : 18 dic 2023, 10:12:06
    Author     : dw2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${sessionScope.puntos==null}">
    <jsp:forward page="Servlet1"/>
</c:if>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
       
        <c:choose>
            <c:when test="${param.titulo!=null}">               
                <h2>${param.titulo}</h2> 
            </c:when>
            <c:otherwise>
                <h2>TITULO DESCONOCIDO</h2>
            </c:otherwise>   
            
            
        </c:choose> 
        
        
        
       
        
        <table>
        <c:forEach items="${puntos}" var="punto">
            
            <tr>
                <td><c:out value="${punto.x}" /></td>
                <td>${punto.x}</td>
            </tr>
        </c:forEach>
        </table>
        
        
        
        
        <h1>Mapa de ubicacioes</h1>
        
        <table>
            <c:forEach items="${applicationScope.ubicaciones}" var="par">
            
            <tr>
                <td><c:out value="${par.key}"/></td>
                <td><c:out value="${par.value.infoPunto()}"/></td>
            </tr>
        </c:forEach>
        </table>
        
        
        
    </body>
</html>
