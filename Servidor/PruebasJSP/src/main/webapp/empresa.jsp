<%-- 
    Document   : empresa.jsp
    Created on : 11 dic 2023, 11:56:30
    Author     : dw2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <c:if test="${sessionScope.empresa==null}">        
            <c:redirect url="alta_empresa.jps" />
        </c:if>
        <c:if test="${sessionScope.empresa!=null}">
            <h2><c:out value="${sessionScope.empresa.nombre}" /></h2>
            <h3><c:out value="${sessionScope.empresa.beneficio}" /></h3>            
            
            <h3>PLANTILLA</h3>
            <table>
                <tr><th>NOMBRE</th><th>DINERO</th></tr>
                <c:forEach items="${sessionScope.empresa.trabajadoresUtiles()}" var="trab" varStatus="estado" >
                    <form method="post" action="ServletEmpresa">
                    <tr>
                        <td><c:out value="${trab.nombre}"/></td>
                        <td><c:out value="${trab.dinero} €"/></td>
                        <input type="hidden" name="iTrabajador" value="${estado.index}"/>
                        <td><input type="number" name="horas" value="TRABAJAR" /></td>
                        <td><input type="submit" name="trabajartrabajador" value="TRABAJAR" /></td>
                    </tr>
                    </form>
                </c:forEach>
                
            </table>
            
            <jsp:include page="alta_trabajador.jsp" />
              
              <hr/>
              <h2>TRABAJAR EMPRESA</h2>
            <form method="post" action="ServletEmpresa">
                <input type="number" name="horas" /><!-- comment -->
                <input type="submit" name="trabajarempresa" value="TRABAJAR" />
            </form> 
        </c:if>
        
           
            <
        
    </body>
</html>
