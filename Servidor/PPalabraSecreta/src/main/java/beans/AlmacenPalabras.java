package beans;

import java.util.ArrayList;

public class AlmacenPalabras {

	private static ArrayList<String> listaPalabras=new ArrayList<String>();
	
	static {
		listaPalabras.add("Perro");
		listaPalabras.add("Manzana");
		listaPalabras.add("Furgoneta");
		listaPalabras.add("Ordenador");
		listaPalabras.add("Silla");
		listaPalabras.add("Piano");
		listaPalabras.add("Reloj");
	}
	
	public static String palabraAzar() {
		int indice = (int) (Math.random()*listaPalabras.size()+1);		
		
		return listaPalabras.get(indice-1);
	}

	public static ArrayList<String> getListaPalabras() {
		return listaPalabras;
	}

	public static void setListaPalabras(ArrayList<String> listaPalabras) {
		AlmacenPalabras.listaPalabras = listaPalabras;
	}
}
