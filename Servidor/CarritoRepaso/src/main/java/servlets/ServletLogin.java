/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package servlets;

import dao.ClienteDAO;
import beans.Cliente;
import beans.Item;
import dao.PedidoDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Map;

/**
 *
 * @author dw2
 */
public class ServletLogin extends HttpServlet {
  
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String email = request.getParameter("email");
        String contra = request.getParameter("contra");
        Cliente c = ClienteDAO.buscaCliente(email, contra);
        Map<Integer, Item> mapa = PedidoDAO.todosItems();
        if(c!=null){
            HttpSession s = request.getSession();
            s.setAttribute("cliente", c);
            s.setAttribute("productos", mapa);
             response.sendRedirect("tienda.jsp");
        }
        else{
             response.sendRedirect("login.jsp");
        }

    } 

 
    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
