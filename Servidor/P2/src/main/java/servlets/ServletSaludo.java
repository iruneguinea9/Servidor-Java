package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ServletSaludo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String saludo="hola,";
		String hora=request.getParameter("hora");
		if (hora!=null)
		{
			if (Integer.parseInt(hora)>15)
				saludo+=" buenas tardes!";
			else
				saludo+=" buenos dias!";
		}
		
		PrintWriter pw=response.getWriter();
		pw.print("<body><p>"+ saludo+"</p></body>");
		
		
	}


	
	
	

}
