<%-- 
    Document   : view_cesta
    Created on : 18 ene 2024, 9:22:48
    Author     : dw2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

       <c:set var="cliente" value="${sessionScope.cliente}" />

        <form action="ServletGuardarCompra" method="post">
           <div>
               <label>Nombre: </label>
               <c:out value="${cliente.nombre}" />
           </div>
           <div>
               <label>Dirección: </label>
                <input type="text" name="domicilio" value="${cliente.domicilio}" />           
           </div>
           <div>
               <label>Teléfono: </label>
               <input type="text" name="telefono" value="${cliente.telefono}" />        
           </div>
           <div>
               <label>Email: </label>
              <input type="text" name="email" value="${cliente.email}" />        
           </div>
           <jsp:include page="view_cesta.jsp" />
           <!-- ... más campos según sea necesario ... -->
           <input type="submit" value="Realizar Pedido">
        </form>

    </body>
</html>
