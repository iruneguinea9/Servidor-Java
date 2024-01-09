/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import beans.Autor;
import beans.Libro;
import beans.Prestamo;
import conn.ConnPool;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Util;

/**
 *
 * @author dw2
 */
public class DaoBiblio {
    
    
    
    public static HashMap <Integer, java.util.Date> mapaAutorFechaPrestamo(){
        
        HashMap <Integer, java.util.Date> mapa=new HashMap <Integer, java.util.Date>();
        
        String sqlAutores="select distinct idautor from libros";
        
         try (   Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sqlAutores);
                ResultSet rs=ps.executeQuery();       
            )
        
        {
            while (rs.next()){
                int idAutor=rs.getInt("idautor");
                mapa.put(idAutor, fechaUltimoPrestamo(idAutor));
                
            }
            
        }
        catch(SQLException e){
            
            
        } 
        
        return mapa;
    }
    
    public static java.util.Date fechaUltimoPrestamo(int idautor){
        
         java.util.Date f=null;
         String sqlFecha="select max(fecha) as ultimafecha from prestamos, libros "
                 + " where libros.idautor=" + idautor + " and prestamos.idlibro=libros.isbn"; 
        
         System.out.print(sqlFecha);
         try (   Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sqlFecha);
                ResultSet rs=ps.executeQuery();       
            )
        
        {
            if (rs.next()){
                System.out.print("Recuperado " + rs.getDate("ultimafecha"));
                if (rs.getDate("ultimafecha")!=null){
                    f=Util.fechaUtil(rs.getDate("ultimafecha"));
                       
                }                    
                    
            }
        }
        catch(SQLException e){
            System.err.print("Error en fechaUltimoPrestamo " + e.getMessage());
        } 
        return f;
    }
    
    
    public static LinkedHashMap<Autor,ArrayList<Libro>> mapaAutores (){
        
        LinkedHashMap<Autor,ArrayList<Libro>> mapa=new LinkedHashMap<Autor,ArrayList<Libro>>();
        
        String sqlAutores="select id, nombre, fecha, nacionalidad from autores"
                + " where autores.id in (select idautor from libros)";
        
        try (   Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sqlAutores);
                ResultSet rs=ps.executeQuery();       
            )
        
        {
            while (rs.next()){
                Autor a=new Autor();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                a.setFecha(Util.fechaUtil(rs.getDate("fecha")));      
                
                
                
                a.setNacionalidad(rs.getString("nacionalidad"));                
                mapa.put(a, librosDeAutor(a.getId()));
            }
            
        } 
        catch (SQLException ex) {        
            System.err.print("Error SQL en mapaAutores" + ex.getMessage());        
        }
        
        return mapa;        
    }
    
    
    
    
    public static ArrayList<Libro> librosDeAutor(int idAutor){
        ArrayList<Libro> libros=new ArrayList<Libro>();        
        
        String sqlLibros="select isbn, titulo, paginas, genero, idautor from "+
                " libros where idautor= " + idAutor;
        
         try (   Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sqlLibros);               
                ResultSet rs=ps.executeQuery();       
            )
        
        {
            while (rs.next()){
                Libro l=new Libro();
                l.setIsbn(rs.getString("isbn"));
                l.setTitulo(rs.getString("titulo"));
                l.setPaginas(rs.getInt("paginas"));
                l.setGenero(rs.getString("genero"));
                l.setIdautor(idAutor);
                libros.add(l);
            }
            
        } 
        catch (SQLException ex) {        
            System.err.print("Error SQL en librosDeAutor" + ex.getMessage());        
        }
        
        
        return libros;
    }
    
    
    
    public static void borrarLibro(String isbn){
        
        String sqlBPL="delete from prestamos where idlibro='" + isbn + "'";
        String sqlBL="delete from libros where isbn='" + isbn + "'";
        
        try (   Connection cn=ConnPool.dameConexion();
                PreparedStatement ps1=cn.prepareStatement(sqlBPL);               
                PreparedStatement ps2=cn.prepareStatement(sqlBL);           
            )        
        {
            ps1.executeUpdate();
            ps2.executeUpdate();            
        }
        catch (SQLException e){
            System.err.print("Error en DAO borrarLibro " + e.getMessage());
        }
    }
     public static ArrayList<Libro> obtenerLibros() {
        ArrayList<Libro> libros=new ArrayList<Libro>();        
        
        String sqlLibros="select isbn, titulo, paginas, genero, idautor from libros";
        
         try (   Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sqlLibros);               
                ResultSet rs=ps.executeQuery();       
            )
        
        {
            while (rs.next()){
                Libro l=new Libro();
                l.setIsbn(rs.getString("isbn"));
                l.setTitulo(rs.getString("titulo"));
                l.setPaginas(rs.getInt("paginas"));
                l.setGenero(rs.getString("genero"));
                l.setIdautor(rs.getInt("idAutor"));
                l.setNumPrestamos(numPrestamoLibro(rs.getString("isbn")));
                libros.add(l);
            }
            
        } 
        catch (SQLException ex) {        
            System.err.print("Error SQL en obtenerLibros" + ex.getMessage());        
        }
        
        
        return libros;
   }
     
     public static void prestarLibro(String isbn) {
   String sqlPrestamo = "INSERT INTO prestamos (idlibro, fecha) VALUES ('" + isbn + "', CURRENT_DATE)";

   try (Connection cn = ConnPool.dameConexion();
        PreparedStatement ps = cn.prepareStatement(sqlPrestamo)) {

       ps.executeUpdate();
   } catch (SQLException e) {
       System.err.print("Error en DAO prestarLibro " + e.getMessage());
   }
}
      public static int numPrestamoLibro(String isbn) {
      //cantidad de prestamos que tiene un libro
      String sql = "select count(*) as num from prestamos where idlibro='"+isbn+"'";
      int num=0;
       try (   Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sql);               
                ResultSet rs=ps.executeQuery();
            )        
        {
           while (rs.next()){
               num = rs.getInt("num");
           }
        }
        catch (SQLException e){
            System.err.print("Error en DAO numPrestamoLibro " + e.getMessage());
        }
       return num;
      }
      
        public static ArrayList<Prestamo> obtenerPrestamos(String isbn) {
        ArrayList<Prestamo> prestamos=new ArrayList<Prestamo>();        
        
        String sql="SELECT libros.titulo as titulo, prestamos.id as id,prestamos.fecha_devolucion as dev, libros.isbn as isbn, prestamos.fecha as fecha FROM libros INNER JOIN prestamos ON libros.isbn = prestamos.idlibro WHERE libros.isbn = '"+isbn+"';";
        
         try (   Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sql);               
                ResultSet rs=ps.executeQuery();       
            )
        
        {
            while (rs.next()){
                Prestamo p=new Prestamo();
                p.setId(rs.getInt("id"));
                p.setIsbn(rs.getString("isbn"));
                p.setTitulo(rs.getString("titulo"));
                p.setFecha(rs.getDate("fecha"));
                p.setFechaDevolucion(rs.getDate("dev"));
                prestamos.add(p);
            }
            
        } 
        catch (SQLException ex) {        
            System.err.print("Error SQL en obtenerLibros" + ex.getMessage());        
        }
        
        
        return prestamos;
   }
    public static ArrayList<Prestamo> obtenerLibrosSinDevolver() {
        ArrayList<Prestamo> prestamos=new ArrayList<Prestamo>();        
        
        String sql="SELECT libros.titulo as titulo, prestamos.id as id,prestamos.fecha_devolucion as dev, libros.isbn as isbn, prestamos.fecha as fecha FROM libros INNER JOIN prestamos ON libros.isbn = prestamos.idlibro WHERE prestamos.fecha_devolucion is null ORDER BY fecha;";
        
         try (   Connection cn=ConnPool.dameConexion();
                PreparedStatement ps=cn.prepareStatement(sql);               
                ResultSet rs=ps.executeQuery();       
            )
        
        {
            while (rs.next()){
                Prestamo p=new Prestamo();
                p.setId(rs.getInt("id"));
                p.setIsbn(rs.getString("isbn"));
                p.setTitulo(rs.getString("titulo"));
                p.setFecha(rs.getDate("fecha"));
                p.setFechaDevolucion(rs.getDate("dev"));
                prestamos.add(p);
            }
            
        } 
        catch (SQLException ex) {        
            System.err.print("Error SQL en obtenerLibros" + ex.getMessage());        
        }
        
        
        return prestamos;
   }
              
        
}
