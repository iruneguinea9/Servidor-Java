
        <form method="post" action="ServletEmpresa">          
            <input type="text" name="nombre"  />  
            <input type="number" name="dinero" />           
            <input type="submit" value="AÑADIR TRABAJADOR" name="nuevotrabajador" />            
        </form>
        <c:if test="${param.errornuevotrab!=null}">
            Trabajador repetido o empresa llena    
        </c:if>
