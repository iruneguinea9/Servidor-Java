/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package servlets;

import beans.Punto;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author dw2
 */
public class Servlet1 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        
        HashMap<String,Punto> ubicaciones=new HashMap<String,Punto>();
        
        ubicaciones.put("Alesandro", new Punto(2,3));
        ubicaciones.put("Jon", new Punto(-2,-3));
        ubicaciones.put("Irune", new Punto(0,8));
          
        this.getServletContext().setAttribute("ubicaciones",ubicaciones);
   
        
    }
   
   
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        
        ArrayList<Punto> puntos=new  ArrayList<Punto> ();
        puntos.add(new Punto(4,5));
         puntos.add(new Punto(-4,5));
          puntos.add(new Punto(4,-5));
           puntos.add(new Punto(-4,-5));
           
           
        HttpSession s=request.getSession();
        
        s.setAttribute("puntos", puntos);
        
        
        request.getRequestDispatcher("prueba.jsp").forward(request, response);
        
        
        
   
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
    }

 

}
