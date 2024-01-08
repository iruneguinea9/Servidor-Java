<%-- 
    Document   : prestamos
    Created on : 8 ene 2024, 10:43:58
    Author     : dw2
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Libro" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>JSP Page</title>
   </head>
   <body>
       <c:if test="${not empty sessionScope.error}">
           <p style="color: red;">${sessionScope.error}</p>
       </c:if>
       <form action="ServletPrestamos" method="post">
           <table>
               <c:forEach var="libro" items="${sessionScope.libros}">
                  <tr>
                      <td><input type="checkbox" name="librosSeleccionados" value="${libro.isbn}"></td>
                      <td>${libro.titulo}</td>
                      <td>${libro.genero}</td>
                      <td>${libro.paginas} páginas</td>
                  </tr>
               </c:forEach>
           </table>
           <input type="submit" value="TOMAR PRESTADOS">
       </form>
   </body>
</html>
