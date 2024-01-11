
package servlets;

import beans.Prestamo;
import daos.DaoBiblio;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;


public class ServletDevolver extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletDevolver</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletDevolver at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession s = request.getSession();
        //recoger libros sin devolver
        ArrayList<Prestamo> prestamos=DaoBiblio.obtenerLibrosSinDevolver(); 
        s.setAttribute("sinDevolver", prestamos);
        if(s.getAttribute("marcadosDevolver")==null){
            s.setAttribute("marcadosDevolver", new ArrayList<Prestamo>());
        }
        if(request.getAttribute("accion")!=null){
            ArrayList<Prestamo> marcadosDevolver =(ArrayList<Prestamo>)s.getAttribute("marcadosDevolver");
            marcadosDevolver.add(DaoBiblio.prestamoPorId(Integer.parseInt((String) request.getAttribute("id"))));
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("devoluciones.jsp");
        dispatcher.forward(request, response);
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
