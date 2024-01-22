/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Cliente;
import beans.Incidencia;
import beans.Item;
import beans.LineaPedido;
import beans.Pedido;
import conn.ConnPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author dw2
 */
public class DaoExam {
    
    /* ---------------------------- MAPA PEDIDOS ----------------------------*/
    public static HashMap<Pedido,ArrayList<Incidencia>> mapaPedidos(){
        HashMap<Pedido,ArrayList<Incidencia>> mapa = new HashMap<Pedido,ArrayList<Incidencia>>();
        
        String sql="select * from pedidos";
         try (   
                Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sql);               
                ResultSet rs=ps.executeQuery();       
            )        
        {
            while (rs.next()){
                Pedido p = new Pedido();
                p.setId(rs.getInt("id"));
                p.setTotal(rs.getInt("total"));
                p.setFecha(rs.getDate("fecha"));
               // por cada pedido recuperar sus incidencias 
               
               String sqlIncidencias = "select * from incidencias where idpedido='"+rs.getInt("id")+"' ORDER BY fecha";
               ArrayList<Incidencia> incidencias = new ArrayList<Incidencia>();
               try (   
                    PreparedStatement ps2=cn.prepareStatement(sqlIncidencias);               
                    ResultSet rs2=ps2.executeQuery();       
                )        
                {
                while (rs2.next()){
                    Incidencia in = new Incidencia();
                    in.setId(rs2.getInt("id"));
                    in.setDescripcion(rs2.getString("descripcion"));
                    in.setIdpedido(rs2.getInt("idpedido"));
                    in.setFecha(rs2.getDate("fecha"));
                    incidencias.add(in);
                }
                 } 
            catch (SQLException ex) {        
                System.err.print("Error SQL en DaoEXAM mapapedidos incidencias " + ex.getMessage());        
            }
             mapa.put(p, incidencias);
             System.out.print("añadido al mapa "+mapa.size());
            }
             } 
        catch (SQLException ex) {        
            System.err.print("Error SQL en DaoEXAM mapaPedidos" + ex.getMessage());        
        }
        
        return mapa;
    }
    
        /* ---------------------------- GRABAR INCIDENCIA ----------------------------*/
    public static boolean grabarIncidencia(Incidencia in){
        // elijo boolean para devolver si se ha grabado bien o no
        // Comprobaciones pre grabar
        if(!existeIncidencia(in)){
            //no existe incidencia con misma descripcion para el mismo pedido
            if(!tiene5incidencias(in)){
                //no tiene 5 incidencias en esa fecha
                String sqlNuevaIn = "insert into incidencias(descripcion,idpedido,fecha) values('"+in.getDescripcion()+"','"+in.getIdpedido()+"',CURRENT_DATE)";
                try (Connection cn = ConnPool.dameConexion();
                    PreparedStatement ps = cn.prepareStatement(sqlNuevaIn)) {

                   ps.executeUpdate();
                   return true;
               } catch (SQLException e) {
                   System.err.print("Error en DAO DaoEXAM grabar incidencia " + e.getMessage());
                   return false;
               }
                               
            }
        }     
              
        return false;
    }
    
     /* ---------------------------- ELIMINAR INCIDENCIAS ----------------------------*/
    
    public static boolean eliminarIncidencias(ArrayList<String> eliminables,int idpedido){
        for(String incidencia:eliminables){
            String sql = "delete from incidencias where idpedido='"+idpedido+"' and descripcion='"+incidencia+"'";
                try (   Connection cn=ConnPool.dameConexion();
                   PreparedStatement ps=cn.prepareStatement(sql);               
                    )        
                {
                    ps.executeUpdate();
                }
                catch (SQLException e){
                    System.err.print("Error en DAO DaoExam eliminarIncidencias " + e.getMessage());
                }

                }


        return false;
    }
   /* ---------------------------- MAPA ITEMS VENTAS ----------------------------*/  
    
     public static HashMap<Item,Integer> mapaItemVentas(){
         HashMap<Item,Integer> mapa = new HashMap<Item,Integer>();
         String sql = "select * from items where id in (select iditem from lineaspedido) order by nombre";
           try (   
                Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sql);               
                ResultSet rs=ps.executeQuery();       
            )        
        {
            while (rs.next()){
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setNombre(rs.getString("nombre"));
                item.setPrecio(rs.getDouble("precio"));
               // tenemos los items calcular la cantidad
               String sqlCantidad = "select sum(cantidad) as cant from lineaspedido where iditem='"+rs.getInt("id")+"'";
                    try (   
                                PreparedStatement ps2=cn.prepareStatement(sqlCantidad);               
                                ResultSet rs2=ps2.executeQuery();       
                            )        
                        {
                            while (rs2.next()){
                              mapa.put(item,rs2.getInt("cant") );
                            }
                             } 
                        catch (SQLException ex) {        
                            System.err.print("Error SQL en DaoEXAM mapaPedidos" + ex.getMessage());        
                        }
                    
            }
            
             } 
        catch (SQLException ex) {        
            System.err.print("Error SQL en DaoEXAM mapaPedidos" + ex.getMessage());        
        }
    
         return mapa;
     }
    
    
    /* ------------------- Utilidades mias -----------------*/
    public static boolean existeIncidencia(Incidencia in){
        
        String sql = "select * from incidencias where idpedido='"+in.getIdpedido()+"' and descripcion='"+in.getDescripcion()+"'";
        try (   
                Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sql);               
                ResultSet rs=ps.executeQuery();       
            )        
        {
            while (rs.next()){
               return true;
            }
             } 
        catch (SQLException e) {   
           System.err.print("Error en DAO DaoEXAM existe incidencia " + e.getMessage());
            return false;
        }
        
        return false;
    }

    
    public static boolean tiene5incidencias(Incidencia in){
        
        String sql = "select count(*) cuantas from incidencias where idpedido='"+in.getIdpedido()+"' and fecha='"+in.getFecha()+"'";
        try (   
                Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sql);               
                ResultSet rs=ps.executeQuery();       
            )        
        {
            while (rs.next()){
               if(rs.getInt("cuantas")==5){
                   return true;
               }
            }
             } 
        catch (SQLException e) {   
           System.err.print("Error en DAO DaoEXAM existen 5 incidencias " + e.getMessage());
            return false;
        }
        
        
        return false;
    }

    public static ArrayList<LineaPedido> obtenerSusPedidos(int idItem) {
        ArrayList<LineaPedido> pedidos = new ArrayList<LineaPedido>();
        String sql = "select * from lineaspedido where iditem='"+idItem+"'";
        try (   
                Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sql);               
                ResultSet rs=ps.executeQuery();       
            )        
        {
            while (rs.next()){
               LineaPedido l = new LineaPedido();
               l.setId(rs.getInt("id"));
               l.setCantidad(rs.getInt("cantidad"));
               l.setPedido(buscarPedidoid(rs.getInt("idpedido")));
               //l.setItem(buscarItemId(rs.getInt("iditem")));
               pedidos.add(l);
            }
             } 
        catch (SQLException e) {   
           System.err.print("Error en DAO DaoEXAM obtener pedidos " + e.getMessage());
        }
        return pedidos;
    }
    
 
    public static Pedido buscarPedidoid(int idPedido)
	{
        String sql = "SELECT * FROM pedidos where id='"+idPedido+"'";
        Connection con;
        try (   
                Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sql);               
                ResultSet rs=ps.executeQuery();       
            )        
        {
            while (rs.next()){
               Pedido p = new Pedido();
               p.setId(idPedido);
               p.setFecha(rs.getDate("fecha"));
               p.setTotal(rs.getDouble("total"));
               p.setCliente(buscaCliente(rs.getInt("idcliente")));
               return p;
            }
             } 
        catch (SQLException e) {   
           System.err.print("Error en DAO DaoEXAM obtener pedidos " + e.getMessage());
        }
		return null;
	}
    
    public static Cliente buscaCliente(int id){
     String sql = "select * from clientes where id='"+id+"'";
         try (   
                Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sql);               
                ResultSet rs=ps.executeQuery();       
            )        
        {
            while (rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setPassword(rs.getString("password"));
                c.setDomicilio(rs.getString("domicilio"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                return c;
            }
             } 
        catch (SQLException e) {   
           System.err.print("Error en DAO ClienteDAO " + e.getMessage());

        }
     
    
    return null;
}
}
