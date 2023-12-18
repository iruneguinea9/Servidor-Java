<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="beans.AlmacenPalabras"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Palabra secreta</title>
<style>
	.container{
		align-items:center;
		align-content:center;		
		justify-content:center;
	}
	td{
		border:1px solid black;
	}
</style>
</head>
<body>
<div class="container">
		<% 
			HttpSession s=request.getSession();
                        if(s.getAttribute("cualEra")!=null){
                        out.print("<p>Has fallado! la palabra era: "+s.getAttribute("cualEra")+"</p>");
                    }
			ArrayList<Integer> reveladas =(ArrayList<Integer>) s.getAttribute("reveladas");
			out.print("<table>");
			out.print("<tr>");
			// recoger la palabra aleatoria y crear celdas
			String palabra = (String)s.getAttribute("palabra");
			for(int i =0;i<palabra.length();i++){
				if(reveladas!=null && reveladas.contains(i)){
					out.print("<td>"+palabra.charAt(i)+"</td>");
				}
				else{
					out.print("<td><a href='ServletPalabra?indice="+i+"'>VER</a></td>");
				}
				
			}
			out.print("</tr>");
			out.print("</table>");
			
			
			// vidas restantes
			int vidas = (int)s.getAttribute("vidas");
			out.print("<ul><li>");
			out.print("Vidas restantes:");
			out.print(vidas);
			out.print("</li>");		
			out.print("<form method='post' action='ServletPalabra'>");		
			//formulario tu respuesta
			out.print("<li>Tu respuesta: ");		
			out.print("<input type='text' name='rpta'/>");
			out.print("<input type='submit' name='submit' value='COMPROBAR'/>");
			out.print("</li>");		
			out.print("</form>");		
			out.print("</ul>");
		%>
	
	</div>
                
                <%
                    

                    %>
</body>
</html>