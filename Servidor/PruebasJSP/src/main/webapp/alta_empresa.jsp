<%-- 
    Document   : alta_empresa
    Created on : 11 dic 2023, 11:32:53
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
        
        <% 
          out.print(request.getAttribute("empresaErr"));
            
        %>    
        <h1>ALTA EMPRESA</h1>
        <form method="post" action="ServletEmpresa">
            <label>NOMBRE</label>
            <input type="text" name="nombre"  value="${requestScope.empresaERR.nombre}"/>
            <br/><!-- comment -->
            <label>BENEFICIO INICAL</label>
            <input type="number" name="beneficio" value="${requestScope.empresaERR.beneficio}" />
            <br/>
            <input type="submit" value="AÑADIR EMPRESA" name="nuevaempresa" />            
        </form>
            
            
        <p>${requestScope.error}    </p>
            
    </body>
</html>
