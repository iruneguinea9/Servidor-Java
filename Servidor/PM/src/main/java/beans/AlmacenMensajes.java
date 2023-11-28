package beans;

import java.util.ArrayList;

public class AlmacenMensajes {
	private static ArrayList<Mensaje> lstMsgs = new ArrayList<Mensaje>();
	
	public static void aniadirMensaje(Mensaje m) {
		lstMsgs.add(m);
	}
	
	public static int cantMsgs() {
		return lstMsgs.size();
	}

	public static ArrayList<Mensaje> getLstMsgs() {
		return lstMsgs;
	}

	public static void setLstMsgs(ArrayList<Mensaje> lstMsgs) {
		AlmacenMensajes.lstMsgs = lstMsgs;
	}
	

}
