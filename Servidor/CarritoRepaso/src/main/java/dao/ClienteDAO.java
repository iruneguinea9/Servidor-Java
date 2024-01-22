/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import beans.Cliente;
import conn.ConnPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author dw2
 */
public class ClienteDAO {
    
  /*  
Método: public static Cliente buscaCliente (String email, String password)
Busca en la BD el cliente con el correo y password recibidos como parámetros y lo devuelve
*/
 public static Cliente buscaCliente(String email,String password){
     Cliente c = new Cliente();
     String sql = "select * from clientes where email='"+email+"' and password='"+password+"'";
         try (   
                Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sql);               
                ResultSet rs=ps.executeQuery();       
            )        
        {
            while (rs.next()){
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setPassword(rs.getString("password"));
                c.setDomicilio(rs.getString("domicilio"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                 System.err.print("LLega aqui");
                return c;
            }
             } 
        catch (SQLException ex) {        
            System.err.print("Error SQL en ClienteDAO" + ex.getMessage());        
        }
     
     
     return null;
 }
    
/*            
Método: public static boolean buscaCliente (String email)
que devuelve si existe o no un cliente con el email indicado.
*/        
public static boolean buscaCliente(String email){
    boolean existe=false;
     String sql = "select * from clientes where email='"+email+"'";
         try (   
                Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sql);               
                ResultSet rs=ps.executeQuery();       
            )        
        {
            while (rs.next()){
                existe=true;
            }
             } 
        catch (SQLException e) {   
           System.err.print("Error en DAO ClienteDAO " + e.getMessage());

        }
     
    
    return existe;
}
    
/*    
Método: public static boolean guardaCliente(Cliente c)
Guarda un nuevo cliente en la BD, con la información del parámetro. Devuelve si la operación
ha tenido éxito. (No pueden existir 2 clientes con el mismo email).
*/        
public static boolean guardaCliente(Cliente c){
    boolean existe=buscaCliente(c.getEmail());
    //Comprobar si ya existe
    if(!existe){
        String sql = "INSERT INTO clientes (id,nombre,password,domicilio,telefono,email) VALUES ('" + c.getId() + "', '" + c.getNombre() + "','" + c.getPassword() + "','" + c.getDomicilio() + "','" + c.getTelefono() + "','" + c.getEmail() + "')";

        try (Connection cn = ConnPool.dameConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.print("Error en DAO ClienteDAO " + e.getMessage());
            return false;
        }
    }
    return false;
}
    
/*
Método: public static boolean actualizaCliente(Cliente c)
que actualiza el cliente de id contenido en c, con el resto de atributos contenidos en c
Tener en cuenta la restricción de email único.
*/

public static boolean actualizaCliente(Cliente c){
    boolean existe=buscaCliente(c.getEmail());
    //Comprobar si ya existe
    if(!existe){
        String sql = "UPDATE clientes SET nombre='"+c.getNombre()+"',password='"+c.getPassword()+"',domicilio='"+c.getDomicilio()+"',telefono='"+c.getTelefono()+"',email='"+c.getEmail()+"'  WHERE id='"+c.getId()+"'";

        try (Connection cn = ConnPool.dameConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.print("Error en DAO ClienteDAO " + e.getMessage());
            return false;
        }
    }
    return false;
}



}
