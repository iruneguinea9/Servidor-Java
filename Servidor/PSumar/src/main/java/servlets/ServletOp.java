package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletOp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletOp() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("entrada.jsp");
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("submitop")!=null) {
			
			String op=request.getParameter("op");
			if (op!=null)
			{				
	request.getRequestDispatcher("ServletPregunta").forward(request, response);
		
			}
			else
			{
				response.sendRedirect("entrada.jsp?error");
			}			
		}
		
		
		
		
	}

}
