/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package servlets;

import beans.Empresa;
import beans.Trabajador;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
 

public class ServletEmpresa extends HttpServlet {  
   
@Override
	public void init() throws ServletException {
		
		super.init();
		HashMap<String,Empresa> mapEmpresas=new HashMap<String,Empresa>();
		this.getServletContext().setAttribute("mapa_empresas", mapEmpresas);
		
	}
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	if (request.getParameter("listaempresas")!=null)
    		response.sendRedirect("lista_empresas.jsp");
      
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        //Procede de alta_empresa.jsp
        if (request.getParameter("nuevaempresa")!=null)
        {
                String nombre=request.getParameter("nombre");
                int beneficio=Integer.parseInt(request.getParameter("beneficio"));
                
                
                HashMap<String,Empresa> map=(HashMap<String, Empresa>)
                		this.getServletContext().getAttribute("mapa_empresas");
                
                Empresa e=new Empresa(nombre, beneficio);
                if (map.containsKey(nombre) || (beneficio<0)){
                
                    request.setAttribute("empresaERR",e );
                    request.setAttribute("error","Datos de empresa erroneos");         
                    request.getRequestDispatcher("alta_empresa.jsp").forward(request, response); 
                }
                else{
                    request.getSession().setAttribute("empresa",e);
                    map.put(nombre, e);
                    response.sendRedirect("empresa.jsp");
                }
                        
        }
        
        
        //Procede de empresa.jsp  / botón "TRABAJAR EMPRESA"
        if (request.getParameter("trabajarempresa")!=null)
        {
            Empresa e=(Empresa) request.getSession().getAttribute("empresa");
            e.trabajar(Integer.parseInt(request.getParameter("horas")));
            response.sendRedirect("empresa.jsp");
        }
        
        //Procede de empresa.jsp  / botón "TRABAJAR TRABAJADOR"
        if (request.getParameter("trabajartrabajador")!=null)
        {
            Empresa e=(Empresa) request.getSession().getAttribute("empresa");
            int horas=Integer.parseInt(request.getParameter("horas"));
            int i=Integer.parseInt(request.getParameter("iTrabajador"));
         
            Trabajador t=(Trabajador)(e.getPlantilla()[i]);
            t.trabajar(horas);
            response.sendRedirect("empresa.jsp");
            
        }
        
        //Procede de alta_trabajador.jsp para dar de alta el trabajador en la empresa en sesión
        if (request.getParameter("nuevotrabajador")!=null)
        {
             Empresa e=(Empresa) request.getSession().getAttribute("empresa");
             if (e==null)
                 response.sendRedirect("alta_empresa.jsp");
             else{
                 
                 String nombre=request.getParameter("nombre");
                 int dinero=Integer.parseInt(request.getParameter("dinero"));
                 
                 Trabajador t=new Trabajador(nombre, dinero);
                 boolean aniadido=e.aniadirTrabajador(t);  
                 
                 if (!aniadido)
                     response.sendRedirect("empresa.jsp?errornuevotrab");
                 else
                     response.sendRedirect("empresa.jsp");
             }
                  
            
            
            
        }
        
    }

   

   

}
