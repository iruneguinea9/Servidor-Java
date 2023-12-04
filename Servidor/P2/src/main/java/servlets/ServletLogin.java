package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ServletLogin extends HttpServlet {	
	
   
	private static final String PASS_ADMIN="admin";
	private static final String PASS_OTRO="otro";
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		PrintWriter pw=response.getWriter();		
		pw.write("<html>");		
		pw.write("<body>");		
		pw.write("<form method='post' action='ServletLogin'>");		
			pw.write("<label>USER</label>");
			pw.write("<input type='text' name='user' />");
			pw.write("<br/>");
			pw.write("<label>PASS</label>");
			pw.write("<input type='password' name='pass' />");
			pw.write("<br/>");
			pw.write("<input type='submit' name='submit' value='ENTRAR' />");		
		pw.write("</form>");
		
		String error=(String) request.getAttribute("errorlogin");
		if (error!=null)
			pw.write("<label>"+ error + "</label>");
		
		pw.write("</body>");
		pw.write("</html>");
	
		pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("submit")!=null) {
			
			String user=request.getParameter("user");
			String pass=request.getParameter("pass");
			
			if (  (user.equals("admin")  && pass.equals(PASS_ADMIN)  )				
				||
				(!user.equals("admin")  && pass.equals(PASS_OTRO)  )
				)
			{
				response.sendRedirect("ServletSaludo");
			}
			else
			{
				request.setAttribute("errorlogin", user + " no existe o password erronea");
				
				doGet(request,response);				
			}
		}
		
	}

}
