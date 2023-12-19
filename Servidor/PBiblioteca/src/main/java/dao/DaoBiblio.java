/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Libro;
import java.util.ArrayList;
import conn.ConnPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dw2
 */
public class DaoBiblio {
    
    public ArrayList<Libro> libros(){
        ArrayList<Libro> libros = new ArrayList<Libro>();
        String sql = "SELECT * FROM libros";
        try {
            Connection cn=ConnPool.dameConexion();
            PreparedStatement ps=cn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Libro libro = new Libro(rs.getString("isbn"), rs.getString("titulo"),
                                        rs.getInt("paginas"), rs.getString("genero"), 
                                        rs.getInt("id_autor"));
                libros.add(libro);
                System.out.println(rs.getString("titulo"));
                     
            }
            rs.close();
            ps.close();
            cn.close();
        } catch (SQLException ex) {
            System.err.println("Error en metodo libros: " + ex);
        }
        return libros;
    }
}
