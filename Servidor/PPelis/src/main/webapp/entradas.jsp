<%@page import="java.util.HashMap"%>
<%@page import="beans.Peli"%>
<%@page import="java.util.ArrayList"%>
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



	ArrayList<Peli> listapelis=(ArrayList<Peli>) 
								session.getAttribute("listapelis");
	if (listapelis==null)
		response.sendRedirect("ServletEntradas");


	out.print("<table>");
	
	
	for (Peli peli: listapelis){
		out.print("<form method='post' action='ServletEntradas'>");
		out.print("<tr>");
		
		out.print("<input type='hidden' name='nombre' value='"+peli.getNombre()+"'/>");
		out.print("<td>"+peli.getNombre()+"</td>");
		out.print("<td>"+peli.getEntradas()+"</td>");
		out.print("<td><select name='entradas'>");	

		int compradas=0;
		int topeEntradas=peli.getEntradas();
		if (session.getAttribute("mapaentradas")!=null) 
		{
			HashMap<String,Integer> mapa=(HashMap<String,Integer>)
					session.getAttribute("mapaentradas");
			if (mapa.containsKey(peli.getNombre())){
				topeEntradas=topeEntradas-mapa.get(peli.getNombre());
				compradas=mapa.get(peli.getNombre());
			}
		}				
		
		
		for (int cont=1; cont<=topeEntradas; cont++){
			out.println("<option value='"+cont+"'/>"+cont);			
		}
		
		out.print("</select></td>");
		out.print("<td><input type='submit' name='aniadir' value='A�ADIR'/></td>");		
		out.print("<td>"+compradas+ " compradas</td>");	
		out.print("</tr>");
		out.print("</form>");		
	}
	
	
	
	out.print("</table>");



%>

</body>
</html>