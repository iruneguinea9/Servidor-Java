/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package servlets;

import dao.ClienteDAO;
import beans.Cliente;
import dao.KeysDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author dw2
 */
public class ServletRegistro extends HttpServlet {
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletRegistro</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletRegistro at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String usuario = request.getParameter("inpUser");
        String pass = request.getParameter("inpPass");
        String domicilio = request.getParameter("inpDomi");
        String telf = request.getParameter("inpTelf");
        String email = request.getParameter("inpEmail");
        if(ClienteDAO.buscaCliente(email)){
            //si ya hay email no registra
        }
        else{
            Cliente c = new Cliente(KeysDAO.siguienteID("clientes"),usuario,pass, domicilio,telf,email);
            System.out.print("aqui");
            ClienteDAO.guardaCliente(c);
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
