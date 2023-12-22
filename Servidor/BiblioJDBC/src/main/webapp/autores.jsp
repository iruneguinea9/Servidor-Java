<%-- 
    Document   : autores
    Created on : 21 dic 2023, 12:08:47
    Author     : dw2
--%>

<%@page import="utils.Util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:if test="${sessionScope.mapaAutores==null}">
    <jsp:forward page="ServletAutores"></jsp:forward>    
</c:if>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>AUTORES</h1>
        <table>
            <c:forEach items="${mapaAutores}" var="par">
                <form method="post" action="ServletAutores">
                <input type="hidden" name="autor" value="${par.key.id}"
                <tr>
                    <td><c:out value="${par.key.nombre}"/></td>
                    <td>                        
                        <select name="libro">
                            <c:forEach items="${par.value}" var="libro">
                                <option value="${libro.isbn}">${libro.titulo}</option>                                
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <input type="submit" name="borrarlibro" value="BORRAR LIBRO" />
                    </td>
                    <td>
                        <label>
                            <c:set var="fecha" scope="request" value="${mapaFechas.get(par.key.id)}"  />
                         
                           <%=
                               Util.strFecha((java.util.Date)request.getAttribute("fecha"))
                           %>                           
                           
                        </label>
                    </td>
                    <td>                        
                        ${ Util.strFecha(mapaFechas.get(par.key.id))}
                    </td>
                    
                    
                </tr> 
                </form>
            </c:forEach>    
        </table>
        
        
    </body>
</html>
