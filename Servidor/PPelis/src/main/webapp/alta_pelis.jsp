<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>ALTA DE PELICULAS EN EL CINE</h2>

<% if (request.getAttribute("error")!=null) 
	out.print("<p>"+ request.getAttribute("error") + "</p>");
%>
<form method="POST" action="ServletAltaPelis">
	Pelicula <input type="text" name="nombre" />
	Entradas <input type="number" name="entradas" />
	<input type="submit" name="aniadir" value="A�ADIR" />
</form>


<%

	if (session.getAttribute("mapapelis")!=null){		
		
		HashMap<String,Integer> mapa=(HashMap<String,Integer>)
				session.getAttribute("mapapelis");
		
		out.print("<table><tr><th>NOMBRE</th><th>ENTRADAS</th></tr>");		
		
		for (String nombre:mapa.keySet())
		{
			int entradas=mapa.get(nombre);
			out.print("<tr><td>"+nombre+"</td>"
						+"<td>"+entradas+"</td></tr>");
			
		}
		out.print("</table>");
		
		out.print("<p><a href='ServletAltaPelis?guardar'>GUARDAR</a>");
	}



%>

</body>
</html>