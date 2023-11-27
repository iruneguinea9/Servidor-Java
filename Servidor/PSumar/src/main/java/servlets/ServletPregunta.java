package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ServletPregunta extends HttpServlet {
	
	private static final int MIN=10;
	private static final int MAX=30;
	
	private int numRandom() {		
		int num=MIN + (int)(Math.random()* (MAX-MIN+1));
		return num;
	}
	
	
	

	
	
	private void nuevaPregunta(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException {
		
		int num1=numRandom();
		int num2;
		do {
			num2=numRandom();
		}while (num1==num2);		
		
		
		String op=request.getParameter("op");
		
		String signo=null;
		switch (op)
		{
			case "sumar":signo=" + ";
						break;
			case "restar":signo=" - ";
						break;	
		}			
			
		out.print("<form method='post' action='"+ request.getRequestURI()+"'>");
		out.print("<label>" + num1 + "</label>");
		out.print("<label>" + signo + "</label>");
		out.print("<label>" + num2 + "</label>");
		out.print("<input type='hidden' name='op' "
				+ "value='"+request.getParameter("op")+"'/>");
		out.print("<input type='hidden' name='num1' value='"+num1+"'/>");
		out.print("<input type='hidden' name='num2' value='"+num2+"'/>");
		out.print("<input type='number' name='rpta' />");
		out.print("<input type='submit' name='submitrpta' value='ENVIAR' />");
		out.print("</form>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Llega haciendo forward desde doPost del ServletOp
		//como si llegara desde el submit de entrada.jsp
		//Generar 2 nums random distintos
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();	
		
		if (request.getParameter("submitop")!=null)  //Venimos del jsp
		{
			nuevaPregunta(request,response, out);			
		}		
		
		
		if (request.getParameter("submitrpta")!=null) {
			
			int num1=Integer.parseInt(request.getParameter("num1"));
			int num2=Integer.parseInt(request.getParameter("num2"));
			String signo=request.getParameter("op");
			int rpta=Integer.parseInt(request.getParameter("rpta"));	
			
			
			
			int rptaOK=0;
			if (signo.equals("sumar"))
				rptaOK=num1+num2;
			if (signo.equals("restar"))
				rptaOK=num1-num2;
			
			if (rpta==rptaOK) {
				out.print("Respuesta OK");
			}
			else {
				out.print("Respuesta MAL. Era " + rptaOK);
			}
			nuevaPregunta(request, response, out);
		}
		
	
	}

}
