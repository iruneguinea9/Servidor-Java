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
import java.util.HashMap;

/**
 *
 * @author dw2
 */
public class DaoHospital {
    
    //Método que devuelve mapa Id medico --> nombre del medico
	public static HashMap<Integer,String> medicos(){
		
		String sql="select id, medico from medicos";
		HashMap<Integer,String> mapa=new HashMap();
		
		try (
				Connection cn=ConnPool.dameConexion();
				PreparedStatement ps=cn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();   )		
		{
			while (rs.next()) {
				mapa.put(rs.getInt("id"), rs.getString("medico"));
			}
			
		} 
		catch (SQLException e) {
			System.out.println("Error en medicos " + e.getMessage());
		}		
		catch (Exception e) {
			System.out.println("excepcion general " + e.getMessage());
		}
		return mapa;
	}
}
