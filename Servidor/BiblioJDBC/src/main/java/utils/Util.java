/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dw2
 */
public class Util {
    
    
    public static java.util.Date fechaUtil(java.sql.Date fechaSQL){
        
        return new java.util.Date(fechaSQL.getTime());
    }
    
    
    public static String strFecha(java.util.Date fecha){
        
        SimpleDateFormat formateador=new SimpleDateFormat("d/M/y");
        return formateador.format(fecha);
        
    }
    
    public static java.util.Date fechaDesdeStr(String strFecha){
        
        try {
            SimpleDateFormat formateador=new SimpleDateFormat("d/M/y");
            return formateador.parse(strFecha);
        } catch (ParseException ex) {
                System.out.print("error en parseador");
                return null;
        }
        
    }
   public long diasEntreFechas(Date fecha1, Date fecha2) {
    return ChronoUnit.DAYS.between(fecha1.toInstant(), fecha2.toInstant());
}
}
