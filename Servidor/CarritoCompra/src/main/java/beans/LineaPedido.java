/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author dw2
 */
public class LineaPedido {
    private int id;
    private int cantidad;
    private Item item;
    private Pedido pedido;
  
    public LineaPedido(){}
    
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getCantidad(){
        return this.cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
    public Item getItem(){
        return this.item;
    }
    public void setItem(Item item){
        this.item=item;
    }
    public Pedido getPedido(){
        return this.pedido;
    }       
    
    public void setPedido(Pedido pedido){
        this.pedido=pedido;
    }
}
