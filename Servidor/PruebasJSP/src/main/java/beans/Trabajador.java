/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author dw2
 */
public class Trabajador implements Serializable {
    
    private String nombre;
    private int dinero;

    public Trabajador() {
    }

    public Trabajador(String nombre, int dinero) {
        this.nombre = nombre;
        this.dinero = dinero;
    }
    
    
    
    public void trabajar(int horas){
        this.dinero+=10*horas;
    }    
    
    public int getDinero() {
        return dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
