/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package servlets;

import dao.DaoBiblio;
import jakarta.servlet.ServletConfig;
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
public class ServletPrestamos extends HttpServlet {
   private DaoBiblio bd;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        bd = new DaoBiblio();
    }
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute("libros", bd.libros());
        request.getRequestDispatcher("prestamos.jsp").forward(request, response);
    }
   
}
