

package servlets;

import beans.Libro;
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

/**
 *
 * @author dw2
 */
public class ServletPrestamos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPrestamos</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPrestamos at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   HttpSession s = request.getSession();
   ArrayList<Libro> libros = DaoBiblio.obtenerLibros();
   s.setAttribute("libros", libros);
   RequestDispatcher dispatcher = request.getRequestDispatcher("prestamos.jsp");
   dispatcher.forward(request, response);
}




protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  HttpSession s = request.getSession();
  String[] librosSeleccionados = request.getParameterValues("librosSeleccionados");

  if (librosSeleccionados != null && librosSeleccionados.length > 0) {
      for (String isbn : librosSeleccionados) {
          DaoBiblio.prestarLibro(isbn);
      }
      s.removeAttribute("error");
  } else {
      s.setAttribute("error", "No se ha seleccionado ningún libro");
  }

  response.sendRedirect("prestamos.jsp");
}



}
