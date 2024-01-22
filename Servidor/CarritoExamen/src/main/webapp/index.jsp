<%-- 
    Document   : index.jsp
    Created on : 18 ene 2024, 10:51:11
    Author     : dw2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EXAMEN IRUNE</title>
    </head>
    <body>
        <input type="radio" name="rg" value="Incidencias de pedidos" onclick="<c:set var="aDonde" scope="request" value="ServletIncidencias"/>  "/>
        <label>Incidencias de pedidos</label><br/>

        
        <input type="radio"  name="rg" value="Items más vendidos" onclick="<c:set var="aDonde" scope="request" value="ServletItems"/>  "/>
        <label>Items más vendidos</label><br/>

        <c:if test="${aDonde==null}">
           <c:set var="error" scope="request" value="Selecciona alguna de las opciones"/>  
           <button name="entrar" value="ENTRAR" action="index.jsp"/>
        </c:if>
        <button name="entrar" value="ENTRAR" onclick="${aDonde}" />
    </body>
</html>
