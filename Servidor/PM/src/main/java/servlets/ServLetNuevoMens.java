package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import beans.Mensaje;
import beans.AlmacenMensajes;

/**
 * Servlet implementation class ServLetNuevoMens
 */
public class ServLetNuevoMens extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServLetNuevoMens() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("nuevo")!=null) {
			Mensaje m = new Mensaje();
			m.setEmisor(request.getParameter("emisor"));
			m.setTexto(request.getParameter("texto"));
			m.setFecha(new java.util.Date());
			m.setaFavor(0);
			m.setEnContra(0);
			
			AlmacenMensajes.aniadirMensaje(m);
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.write("<p><a href='mensajes.jsp'></a></p>");
		}
		else {
			
		}
	}

}
