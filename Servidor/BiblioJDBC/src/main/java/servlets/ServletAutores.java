
package servlets;

import beans.Autor;
import beans.Libro;
import daos.DaoBiblio;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ServletAutores extends HttpServlet {
   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAutores</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAutores at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
                
        HttpSession s = request.getSession();
        s.setAttribute("mapaAutores", DaoBiblio.mapaAutores());
        s.setAttribute("mapaFechas", DaoBiblio.mapaAutorFechaPrestamo());
       
        response.sendRedirect("autores.jsp");
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession s = request.getSession();
        
       
        if (request.getParameter("borrarlibro")!=null){
            
            int idautor=Integer.parseInt(request.getParameter("autor"));
            String isbn=request.getParameter("libro");
            DaoBiblio.borrarLibro(isbn);
            
            //MODO 1:
            //Borrar del mapa de sesión el libro isbn del autor de id idautor
            // y redirigir al jsp
            
           
            LinkedHashMap<Autor,ArrayList<Libro>> mapa=                   
                    (LinkedHashMap<Autor,ArrayList<Libro>>)
                    s.getAttribute("mapaAutores");
             
             
             ArrayList<Libro> libros=mapa.get(new Autor(idautor));
             int i=libros.indexOf(new Libro(isbn));
             libros.remove(i);
            
             response.sendRedirect("autores.jsp");
             
             
             //MODO 2: Volver a consultar
            doGet(request, response);
        }
      
    }

   
}
