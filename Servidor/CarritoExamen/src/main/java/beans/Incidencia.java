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
public class Incidencia {
    private int id;
    private String descripcion;
    private int idpedido;
    private Date fecha;
    
    
    public Incidencia(){};
    public Incidencia(int id,String descripcion,int idpedido,Date fecha){
        this.id=id;
        this.descripcion=descripcion;
        this.idpedido=idpedido;
        this.fecha=fecha;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String desc) {
        this.descripcion = desc;
    }
    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int id) {
        this.idpedido = id;
    }
    public Date getFecha(){
        return this.fecha;
    }
    public void setFecha(Date fecha){
        this.fecha=fecha;
    }
}
