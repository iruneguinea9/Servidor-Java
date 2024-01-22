package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cliente;
import dao.ClienteDAO;
import dao.PedidoDAO;


/**
 * Servlet implementation class ServletLogin
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 @Override
	    public void init(ServletConfig config) throws ServletException {
	        super.init(config);
	    }	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// SESION
		HttpSession session = request.getSession(false);
		if(session != null)   // no retoma sesiones, crea una nueva
		{
			session.invalidate();
			session = null;
		}
		session = request.getSession(true);
		
		
		// validar usuario
		boolean valido = false;
		String usuario = request.getParameter("inpUser");
		String pass = request.getParameter("inpPass");
		Cliente cliente = ClienteDAO.buscaCliente(usuario, pass);  
		if(cliente != null)     // usuario correcto
		{
			valido = true;
			request.getSession().setAttribute("user", cliente);
			request.getSession().setAttribute("productos", PedidoDAO.todosItems());
		}
		else
			request.getSession().setAttribute("mensaje", "usuario no valido");    // usuario incorrecto
		
		if(valido)  // usuario correcto
	        request.getRequestDispatcher("tienda.jsp").forward(request, response);   // va atienda.jsp
		else  
			request.getRequestDispatcher("login.jsp").forward(request, response);    // vuelve a login.jsp
		        
	}
	
	
}
