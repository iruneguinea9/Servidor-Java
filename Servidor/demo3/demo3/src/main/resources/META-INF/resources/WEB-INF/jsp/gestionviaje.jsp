<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Viaje a ${viajeorganizar.lugar}
 en ${viajeorganizar.dias} dias ,
 ${viajeorganizar.paradas.size()} paradas </h3>
 <ol>
 <c:forEach items="${viajeorganizar.paradas}" var="parada">
 	<li>${parada}</li>
 </c:forEach>
</ol>
 

<form method="post" action="/aniadeParada">
	<label>AÑADIR PARADA</label>
	<input type="text" name="parada" />
	<input type="submit" name="aniadeparada" value="AÑADIR" />
</form>


</body>
</html>