package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import beans.CarroCompra;
import beans.LineaPedido;
import dao.KeysDAO;
import dao.PedidoDAO;

/**
 * Servlet implementation class ServletAgregarLineaPedido
 */
@WebServlet(name = "ServletAgregarLineaPedido", urlPatterns = {"/ServletAgregarLineaPedido"})
public class ServletAgregarLineaPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAgregarLineaPedido() {
        super();
        // TODO Auto-generated constructor stub
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
		// viene aqui porque ha pedido algo de la tienda
                int cant =Integer.parseInt(request.getParameter("inpCantidad"));
                int id = Integer.parseInt(request.getParameter("id"));
                
                LineaPedido l = new LineaPedido();
                l.setCantidad(cant);
                l.setItem(PedidoDAO.buscarItemId(id));
                l.setId(KeysDAO.siguienteID("lineaspedido"));
                HttpSession session = request.getSession(); //retoma la sesion
                CarroCompra carro = (CarroCompra) session.getAttribute("carro");
                if(carro == null){
                    session.setAttribute("carro", new CarroCompra());
                    carro = (CarroCompra) session.getAttribute("carro");
                }
                // Añadir la nueva LineaPedido al carro
                carro.aniadeLinea(l);
                session.setAttribute("carro", carro);
                //PedidoDAO.guardarLineaPedido(l);
                response.sendRedirect("tienda.jsp");
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		
	}

}
