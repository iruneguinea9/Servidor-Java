package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashSet;

import beans.AlmacenMensajes;
import beans.Mensaje;
import beans.Resultado;


public class ServletVotar extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Resultado r=new Resultado();
		if (request.getParameter("indMG")!=null)
		{
			HttpSession s=request.getSession();  //Crear sesión o recuperarla
			
			if (s.getAttribute("gustos")==null)
				s.setAttribute("gustos",new HashSet<Integer>());
			
			HashSet<Integer> setGustos=(HashSet<Integer>) s.getAttribute("gustos");
			setGustos.add(Integer.parseInt(request.getParameter("indMG")));		
			
		}		
		
		if (request.getParameter("ind")!=null)
		{
			try {
				int i=Integer.parseInt(request.getParameter("ind"));
				Mensaje m=AlmacenMensajes.getLstMsgs().get(i);
				if (request.getParameter("afavor")!=null)
					m.votarAFavor();
				if (request.getParameter("encontra")!=null)
					m.votarEnContra();
				
				r.setOk(true);
				r.setMotivo("Opinion guardada");		
				
			}
			catch (NumberFormatException  | IndexOutOfBoundsException e) {
				r.setOk(false);
				r.setMotivo("Mensaje no existente...");
			}		
		}
		request.setAttribute("resultado", r);
		request.getRequestDispatcher("mensajes.jsp").forward(request, response);
		
	
	}

	
	

}
