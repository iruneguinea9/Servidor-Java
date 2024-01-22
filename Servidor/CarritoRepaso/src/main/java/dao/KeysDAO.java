/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conn.ConnPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dw2
 */
public class KeysDAO {
    
    
    /*Método static siguienteId
    que reciba un nombre de tabla y nos devuelva el siguiente id disponible en dicha tabla (1 si aún
    no tiene tuplas, 1+ del mayor id existente en caso contrario)
    */

    public static int siguienteID(String nombreTabla){
        int siguienteId = 1;
        String sql="select max(id) as maxID from '"+nombreTabla+"'";
         try (   
                Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sql);               
                ResultSet rs=ps.executeQuery();       
            )        
        {
            while (rs.next()){
                siguienteId=rs.getInt("maxID");
            }
             } 
        catch (SQLException ex) {        
            System.err.print("Error SQL en KeysDAO" + ex.getMessage());        
        }
        return siguienteId;
    }
}
