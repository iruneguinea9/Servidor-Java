package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import beans.Peli;

public class ServletEntradas extends HttpServlet {
	
	
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
	
	
	private ArrayList<Peli> pelis(String nomFich){			
		ArrayList<Peli> pelis= new ArrayList<Peli>();		
		try {
			ObjectInputStream ois=new ObjectInputStream(
					new FileInputStream(nomFich));
			
			Peli p=(Peli) ois.readObject();
			while (p!=null) {
				pelis.add(p);				
				p=(Peli) ois.readObject();
			}			
			ois.close();
			
		} catch (Exception e) {
			System.out.print("Error en lectura fich objetos");
		}
		
		return pelis;
	}
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession s=request.getSession();
		HashMap<String,Integer> mapa=
				(HashMap<String,Integer>)s.getAttribute("mapaentradas");
		
		if (request.getParameter("grabar")!=null)
		{
			ArrayList<Peli>pelis=pelis("pelis.obj");			
			for (int i=0; i<pelis.size(); i++) {
				Peli p=pelis.get(i);
				if (mapa.containsKey(p.getNombre()))
					p.setEntradas(p.getEntradas() - mapa.get(p.getNombre()) );				
			}	
			creaFichPelis("pelis.obj", pelis);
			s.removeAttribute("listapelis");
			s.removeAttribute("mapaentradas");
		}		
		
		s.setAttribute("listapelis", pelis("pelis.obj"));
		response.sendRedirect("entradas.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Si venimos de un submit "aniadir entradas" de entradas.jsp
		
		HttpSession s=request.getSession();
		
		if (request.getParameter("aniadir")!=null)
		{
			
			if (s.getAttribute("mapaentradas")==null)
			{
				HashMap<String,Integer> mapa=new HashMap<String,Integer>();
				s.setAttribute("mapaentradas", mapa);				
			}
			
			HashMap<String,Integer> mapaentradas=
					(HashMap<String,Integer>)s.getAttribute("mapaentradas");
			
			
			String nombre=request.getParameter("nombre");
			int entradas=Integer.parseInt(request.getParameter("entradas"));
			
			if (mapaentradas.containsKey(nombre))
				mapaentradas.put(nombre, mapaentradas.get(nombre)+entradas);
			else
				mapaentradas.put(nombre,entradas);
			
			
		}
		
		response.sendRedirect("entradas.jsp");
		
		
		
	}

}
