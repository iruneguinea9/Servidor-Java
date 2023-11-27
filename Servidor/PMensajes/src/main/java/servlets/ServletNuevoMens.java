package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import beans.AlmacenMensajes;
import beans.Mensaje;


public class ServletNuevoMens extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if (request.getParameter("nuevo")!=null) {
			
			Mensaje m=new Mensaje();
			m.setEmisor(request.getParameter("emisor"));
			m.setTexto(request.getParameter("texto"));
			m.setFecha(new java.util.Date());
			m.setaFavor(0);
			m.setEnContra(0);
			
			
			AlmacenMensajes.aniadirMensaje(m);		
			
			
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			
			pw.write("<p><a href='mensajes.jsp'>VER MENSAJES</a></p>");
			
			pw.close();
		
		
		
		
		
		
		}
		
		
	}

}
