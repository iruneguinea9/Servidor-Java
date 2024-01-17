/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author dw2
 */
public class Cliente {
    private int id;
    private String nombre;
    private String password;
    private String domicilio;
    private int telefono;
    private String email;
    
    public Cliente(){
        
    }
    public Cliente(int id,String nombre,String password,String domicilio,int telefono,String email){
        this.id=id;
        this.nombre=nombre;
        this.password=password;
        this.domicilio=domicilio;
        this.telefono=telefono;
        this.email=email;
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
     public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password=password;
    }
     public String getDomicilio(){
        return this.domicilio;
    }
    public void setDomicilio(String domicilio){
        this.domicilio=domicilio;
    }
    public int getTelefono(){
        return this.telefono;
    }
    public void setTelefono(int telefono){
        this.telefono=telefono;
    }
     public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }
}
