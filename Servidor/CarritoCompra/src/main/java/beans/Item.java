/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author dw2
 */
public class Item {
    private int id;
    private String nombre;
    private float precio;
    
    public Item(){}
    public Item(int id,String nombre,float precio){
        this.id=id;
        this.nombre=nombre;
        this.precio=precio;
    }
    
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public float getPrecio(){
        return this.precio;
    }
    public void setPrecio(float precio){
        this.precio=precio;
    }
}
