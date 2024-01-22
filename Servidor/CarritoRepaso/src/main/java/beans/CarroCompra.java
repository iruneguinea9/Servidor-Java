package beans;

import java.util.Collection;
import java.util.HashMap;

public class CarroCompra {
	
	private HashMap<Integer, LineaPedido> carro = new HashMap<Integer, LineaPedido>();


	public HashMap getCarro() {
		return carro;
	}

	public void setCarro(HashMap carro) {
		this.carro = carro;
	}

	
	
	public void aniadeLinea(LineaPedido l) {
            if (l.getCantidad() > 0 && carro.containsKey(l.getItem().getId())) {
                LineaPedido oldLine = (LineaPedido) carro.get(l.getItem().getId());
                oldLine.setCantidad(oldLine.getCantidad() + l.getCantidad());
                carro.put(l.getItem().getId(), oldLine);
            } else if (!carro.containsKey(l.getItem().getId()) && l.getCantidad() > 0) {
                carro.put(l.getItem().getId(), l);
            }
         }



	public void borraLinea(int iditem) {
            carro.remove(iditem);
         }

	public LineaPedido getLineaPedido(int iditem) {
            return (LineaPedido) carro.get(iditem);
         }

	public Collection<LineaPedido> getLineasPedido() {
            return carro.values();
         }

	public double total() {
        double total = 0;
        for (LineaPedido linea : carro.values()) {
            total += linea.getItem().getPrecio()* linea.getCantidad();
        }
        return total;
     }

	public void removeAll() {
		
		carro.clear();
	}
	public boolean vacio() {
            return carro.isEmpty();
         }

        public void vaciar() {
            carro.clear();
         }

	

}
