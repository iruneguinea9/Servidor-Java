<%@page import="java.util.HashSet"%>
<%@page import="beans.Mensaje"%>
<%@page import="beans.Resultado"%>
<%@page import="beans.AlmacenMensajes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
	<%
	
		
		if (request.getAttribute("resultado")!=null)
		{
			Resultado r=(Resultado)request.getAttribute("resultado");
			String msg=r.isOk()?r.getMotivo():"ERROR " + r.getMotivo();
			out.print("<h3>"+ msg + "</h3>");
		}
	
	
		int i=0;
		for (Mensaje m: AlmacenMensajes.getLstMsgs())
		{
			out.print("<tr>");
			out.print("<td>"+ m.getEmisor() + "</td>");
			out.print("<td>"+m.resumenMensaje() + "</td>");
			out.print("<td>"+m.getaFavor() + "</td>");
			out.print("<td>"+m.getEnContra() + "</td>");	
			String enlace1="ServletVotar?ind="+i+"&afavor";
			String enlace2="ServletVotar?ind="+i+"&encontra";
			String enlace3="ServletVotar?indMG="+i;
			out.print("<td><a href='"+enlace1+"'>A FAVOR</a></td>");
			out.print("<td><a href='"+enlace2+"'>EN CONTRA</a></td>");
			out.print("<td><a href='"+enlace3+"'>ME GUSTA</a></td>");			
			out.println("</tr>");
			i++;
		}
	
	%>
	</table>
	
	
	<%
	
	if (session.getAttribute("gustos")!=null)	{		
		HashSet<Integer> gustos=(HashSet<Integer>) session.getAttribute("gustos");
		out.print("<a href='ServletVotar?guardar'>GUARDAR " + gustos.size() + " OPINIONES</a>");

	}
	%>

</body>
</html>