<%-- 
    Document   : incidencias.jsp
    Created on : 18 ene 2024, 11:03:49
    Author     : dw2
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incidencias</title>
    </head>
    <body>
        <table>
            <tr>
                <th>Num. pedido</th>
		<th>Total gastado</th>	
                <th>Fecha pedido</th>	
                <th>Nueva incidencia</th>
                <th>Borrar incidencias</th>
            </tr>
            <c:forEach items="${sessionScope.mapa}" var="par">
                <%--  Mapa contiene HashMap<Pedido,ArrayList<Incidencia>>--%>
                
                <tr><form method="post" action="ServletIncidencias">
                    <td>Pedido <c:out value="${par.key.getId()}"/></td>
                    <td>${par.key.getTotal()}€</td>
                    <td>${par.key.getFecha()}</td>
                    <td>Descripcion: 
                    <form method="post" action="ServletIncidencias">
                        <input type="hidden" name="idpedido" value="<c:out value="${par.key.getId()}"/>"/>
                        <input type="text" name="descIncidencia"/>
                        <input type="submit" name="aniadir" value="AÑADIR"/>
                        <br/>
                        <c:if test="${sessionScope.error==par.key.getId()}">
                            <b>*Incidencia no grabada</b>
                        </c:if>
                    </form>
                    </td>
                    <td>
                        <c:if test="${par.value.size() == 0}">
                            <b>Sin incidencias</b>  
                        </c:if>
                        <c:if test="${par.value.size() != 0}">
                          <b><c:out value="${par.value.size()}"/> incidencias</b><br/>
                          <form method="post" action="ServletIncidencias">
                              <c:forEach items="${par.value}" var="incidencia">
                                  <c:if test="${sessionScope.laNueva==incidencia.getDescripcion()}">
                                      <input type="checkbox" name="check" value="<c:out value="${incidencia.getDescripcion()}"/>"/>
                                      <label><b><c:out value="${incidencia.getDescripcion()}"/></b></label> 
                                  </c:if>
                                   <c:if test="${sessionScope.laNueva!=incidencia.getDescripcion()}">
                                       <c:if test="${!sessionScope.eliminables.contains(incidencia.getDescripcion())}">
                                            <input type="checkbox" name="check" value="<c:out value="${incidencia.getDescripcion()}"/>"/>
                                       </c:if> 
                                        <label><c:out value="${incidencia.getDescripcion()}"/></label> 
                                  </c:if>                             
                                        
                                  
                                  <br/>
                              </c:forEach>
                               <input type="submit" name="eliminar" value="ELIMINAR"/>
                               <c:if test="${sessionScope.eliminables.size()>=0}">
                                    <p><a href="ServletIncidencias?eliminar=${par.key.getId()}">BORRAR INCIDENCIAS MARCADAS</a></p>
                                </c:if>
                          </form>  
                        </c:if>
                        
                    </td>
                </tr>
                
            </c:forEach>
        </table>
        
    </body>
</html>
