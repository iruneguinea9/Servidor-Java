/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dw2
 */
public class Empresa implements Serializable {
    
    private String nombre;
    private int beneficio;
    private Trabajador[] plantilla;
    private int nTrab;
    private static final int MAX_PLANTILLA=10;
    
    public Empresa(){
        nombre="Nombre desconocido";
        beneficio=0;
        plantilla=new Trabajador[MAX_PLANTILLA];
        nTrab=0;
    }

    public Empresa(String nombre, int beneficio) {
        this.nombre = nombre;
        this.beneficio = beneficio;
        plantilla=new Trabajador[MAX_PLANTILLA];
        nTrab=0;
        
        this.aniadirTrabajador(new Trabajador("Julio Perez",0));
        this.aniadirTrabajador(new Trabajador("Sara Saez",1000));
    }
    
    

    public void trabajar(int horas){
        for (int i=0; i<nTrab; i++)
            plantilla[i].trabajar(horas);
        
        beneficio+=100* horas;
        
        
    }
    
    private boolean existeTrab(Trabajador t){
        for (int i=0; i<nTrab; i++){
            if (plantilla[i].getNombre().equals(t.getNombre()))
                return true;
        }
        return false;
    }
    
    
    public boolean aniadirTrabajador(Trabajador tNuevo){
        //Si no cabe false
        if (nTrab>=plantilla.length){
             return false;  
        }   
        //Si existe otro trabajador con el mismo nombre
        if (existeTrab(tNuevo)){
            return false;
        }
       
        plantilla[nTrab]=tNuevo;
        nTrab++;
        return true;
    }
    
    
    public int getBeneficio() {
        return beneficio;
    }

    public String getNombre() {
        return nombre;
    }

    public Trabajador[] getPlantilla() {
        return plantilla;
    }
    
    
    
    public ArrayList<Trabajador> trabajadoresUtiles(){    
        
        ArrayList<Trabajador> trabs=new ArrayList<Trabajador>();
       for (int i=0; i<nTrab; i++)
           trabs.add(plantilla[i]);
       
       return trabs;
        
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + " " + beneficio;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
    
    
}
