package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import beans.Peli;


public class ServletAltaPelis extends HttpServlet {
	
	
	@Override
	public void init() throws ServletException {		
		super.init();				
		this.getServletContext().setAttribute("aforo", 120);
	}
	
	
	private void creaFichPelis(String nomFich,ArrayList<Peli> pelis) {
		String ruta=(nomFich);
		try {
			ObjectOutputStream oos=new ObjectOutputStream
									(new FileOutputStream(ruta));
			
			for (Peli peli: pelis)
				oos.writeObject(peli);
			oos.writeObject(null);
			oos.close();
			System.out.print("Fichero creado");
		
		} catch (Exception e) {
			System.out.print("error al crear fichero"+ e.getMessage());
			
		}
	
	
	
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession s=request.getSession();
		
		if (request.getParameter("guardar")!=null) {
			HashMap<String,Integer> mapa=(HashMap<String,Integer>)
					s.getAttribute("mapapelis");
			ArrayList<Peli> lst=new ArrayList<Peli>();
			for(  Entry<String, Integer> par :  mapa.entrySet() ) {
				String nombre=par.getKey();
				int entradas=par.getValue();
				
				Peli p=new Peli();
				p.setNombre(nombre);
				p.setEntradas(entradas);
				lst.add(p);				
			}	
			creaFichPelis("pelis.obj",lst);
			s.invalidate();
		}
		
		response.sendRedirect("alta_pelis.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession s=request.getSession();
		
		
		
		if (request.getParameter("aniadir")!=null)
		{
			//Añadir pelicula a la sesión
			String nombre=request.getParameter("nombre");
			int entradas=Integer.parseInt(request.getParameter("entradas"));
			
			//Control error: nº de entradas supera aforo			
			if (entradas>
			(Integer)(getServletContext().getAttribute("aforo")))
			{
				request.setAttribute("error", "Las entradas no pueden superar el aforo");
			}
			else
			{
				if (s.getAttribute("mapapelis")==null)
					s.setAttribute("mapapelis", new HashMap<String,Integer>());
				
				HashMap<String,Integer> mapa=(HashMap<String,Integer>)
												s.getAttribute("mapapelis");
				mapa.put(nombre,entradas);
			}
			request.getRequestDispatcher("alta_pelis.jsp").forward(request, response);
		}
		
		
	}

}
