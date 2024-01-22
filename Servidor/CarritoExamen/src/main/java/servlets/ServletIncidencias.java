/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package servlets;

import beans.Incidencia;
import beans.Pedido;
import dao.DaoExam;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author dw2
 */
public class ServletIncidencias extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletIncidencias</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletIncidencias at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession s = request.getSession();
        HashMap<Pedido,ArrayList<Incidencia>> mapa =DaoExam.mapaPedidos();
        //System.out.print("llegan los pedidos? "+mapa.size());
        s.setAttribute("mapa",mapa);       
        response.sendRedirect("incidencias.jsp");
        
        
        /* ------- ELIMINAR ---------*/
        if (request.getParameter("eliminar")!=null){
           ArrayList<String> eliminables =  (ArrayList<String>) s.getAttribute("eliminables");
            boolean exito = DaoExam.eliminarIncidencias(eliminables,Integer.parseInt(request.getParameter("eliminar")));
            if(exito){
                 doGet(request, response);
            }
        }
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession s = request.getSession();
        /*-------- AÑADIR ----------*/
        if (request.getParameter("aniadir")!=null){
            // queremos añadir nueva incidencia
            String descripcion = request.getParameter("descIncidencia");
            int idpedido=Integer.parseInt(request.getParameter("idpedido"));
            Incidencia in = new Incidencia();
            in.setDescripcion(descripcion);
            in.setIdpedido(idpedido);
            boolean exito = DaoExam.grabarIncidencia(in);
            
            if(exito){
                s.setAttribute("laNueva", descripcion);
                doGet(request, response);
            }
            else{
                s.setAttribute("error", idpedido);
                response.sendRedirect("incidencias.jsp");
            }
        }
        /*-------- ELIMINAR ----------*/
        if (request.getParameter("eliminar")!=null){
            String[] elim = request.getParameterValues("check");
            ArrayList<String> eliminables = new ArrayList<String>();
            for(String st : elim){
                eliminables.add(st);
            }
            s.setAttribute("laNueva", null);
            s.setAttribute("eliminables", eliminables);
            response.sendRedirect("incidencias.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
