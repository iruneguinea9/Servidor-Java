package daos;

import java.util.Map;

import beans.Item;
import beans.LineaPedido;
import beans.Pedido;

public class PedidoDAO {
	
	
	/**
	 * M�todo: que devuelve un HashMap con todos los �tems en venta de la base de datos
	 * @return
	 */
	public Map todosItems() {
		return null;
		
	}
	
	/**
	 * M�todo: Devuelve el item cuyo id se recibe como par�metro o null
	 * @param iditem
	 * @return
	 */
	public Item buscaItemPorId(int iditem) {
		return null;
		
	}
	
	
	
	/**
	 * M�todo: que recibe un pedido y lo almacena en la bd (Debe utilizar consultas precompiladas)
	 * @param p
	 */
	public void guardaPedido(Pedido pedido) {
		
	}
	
	
	/**
	 * M�todo: que recibe una l�nea de pedido y la almacena en la bd (Debe utilizar consultas precompiladas)
	 * @param l
	 */
	public void guardaLineaPedido (LineaPedido lineaPedido) {
		
	}
	
	

}
