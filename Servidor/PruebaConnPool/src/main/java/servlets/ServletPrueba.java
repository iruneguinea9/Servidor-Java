/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package servlets;

import dao.DaoHospital;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 *
 * @author dw2
 */
public class ServletPrueba extends HttpServlet {
   
   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      HashMap<Integer, String> mapa=DaoHospital.medicos();
		
		
		response.getWriter().print("n medicos" + mapa.size());
		response.getWriter().print(", mapa: " + mapa.toString());
    } 

    

}
