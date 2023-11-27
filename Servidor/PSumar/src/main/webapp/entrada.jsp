<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%

	if (request.getParameter("error")!=null)
	{
		out.print("<h2>Selecciona algún radio</h2>");
	}




%>

<form method="post" action="ServletOp">
	<label>Elige tipo de operación a practivar</label>
	<input type="radio" name="op" value="sumar">SUMAR
	<input type="radio" name="op" value="restar">RESTAR
	<input type="submit" name="submitop" value="ENTRAR" />	
</form>


</body>
</html>