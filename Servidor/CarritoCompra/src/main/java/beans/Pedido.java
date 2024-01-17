/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.sql.Date;

/**
 *
 * @author dw2
 */
public class Pedido {
    private int id;
    private float total;
    private Date fecha;
    private Cliente cliente;
    
    public Pedido(){}
    
    private int getId(){
        return this.id;
    }
    private void setId(int id){
        this.id=id;
    }
    private float getTotal(){
        return this.total;
    }
    private void setTotal(float total){
        this.total=total;
    }
    private Date getFecha(){
        return this.fecha;
    }
    private void setFecha(Date fecha){
        this.fecha=fecha;
    }
    private Cliente getCliente(){
        return this.cliente;
    }
    private void setCliente(Cliente cliente){
        this.cliente=cliente;
    }
}
