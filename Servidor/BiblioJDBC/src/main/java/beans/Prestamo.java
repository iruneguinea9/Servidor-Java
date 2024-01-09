/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.util.Date;

/**
 *
 * @author dw2
 */
public class Prestamo {
    private int id;
    private Date fecha;
    private String isbn;
    private String titulo;
    private Date fecha_devolucion;
    public Prestamo(int id, Date fecha,String isbn,String titulo,Date fechaDev){
        this.id=id;
        this.fecha=fecha;
        this.isbn=isbn;
        this.titulo=titulo;
        this.fecha_devolucion=fechaDev;
    }
    public Prestamo(){
        
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public Date getFecha(){
        return this.fecha;
    }
    public void setFecha(Date fecha){
        this.fecha=fecha;
    }
     public Date getFechaDevolucion(){
        return this.fecha_devolucion;
    }
    public void setFechaDevolucion(Date fecha_devolucion){
        this.fecha_devolucion=fecha_devolucion;
    }
    public String getIsbn(){
        return this.isbn;
    }
    public void setIsbn(String isbn){
        this.isbn=isbn;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
}
