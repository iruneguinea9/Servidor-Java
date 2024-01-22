package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import beans.Item;
import beans.LineaPedido;
import beans.Pedido;
import conn.ConnPool;

public class PedidoDAO {

	public static Map<Integer, Item> todosItems()
	{
		Map<Integer, Item> items = new HashMap<Integer, Item>();
        String sql = "SELECT * FROM items";
        Connection con;
        try {
            con = ConnPool.dameConexion();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
            	Item item = new Item(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"));
                items.put(item.getId(), item);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
        	System.out.println("Error en PedidoDAO --> todosItems()");
            System.out.println(ex.getMessage());
        }
	        
		return items;
	}
	
	
	public static Item buscarItemId(int idItem)
	{
        String sql = "SELECT * FROM items where id=?";
        Connection con;
        try {
            con =  ConnPool.dameConexion();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, idItem);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            	return new Item(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"));
            
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
        	System.out.println("Error en PedidoDAO --> buscarItemId(idItem)");
            System.out.println(ex.getMessage());
        }
		return null;
	}
	
	
	public static void guardarPedido(Pedido p)
	{
        String sql = "INSERT INTO pedidos (id,total,fecha,idCliente) VALUES ('" + p.getId() + "', '" + p.getTotal() + "','" + p.getFecha() + "','" + p.getCliente().getId() + "')";

        try (Connection cn = ConnPool.dameConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.print("Error en DAO PedidoDAO " + e.getMessage());
        }
    }

	
	
	public static void guardarLineaPedido(LineaPedido l)
	{
        String sql = "INSERT INTO lineaspedido (id,cantidad,idpedido,iditem) VALUES ('" + l.getId() + "', '" + l.getCantidad() + "','" + l.getPedido().getId() + "','" +l.getItem().getId() + "')";

        try (Connection cn = ConnPool.dameConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.print("Error en DAO PedidoDAO " + e.getMessage());
        }
	}
	
}
