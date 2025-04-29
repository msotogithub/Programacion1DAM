/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud12;

import java.util.*;

/**
 *
 * @author manue
 */
public class Mapas {
    
     public static void main(String[] args) {
         Map<String, Double> m = new HashMap<>();
         m.put("Ana",1.65);
         m.put("Pepe",1.75);
         m.put("Juan",1.80);
         m.put("Pedro",1.77);
        // System.out.println(m);
         
         Set<String> claves = m.keySet();
        // System.out.println(claves);
        
        Collection<Double> estaturas = m.values();
         
        System.out.println("Entradas antes del borrado: " +m);
         
         for(Iterator<Double> it = estaturas.iterator(); it.hasNext();){
             Double v = it.next();
             if(v> 1.71){
                 it.remove();
             }
         }
         
         System.out.println("Entradas después del borrado: " +m);
         
         /*
         System.out.println(estaturas);
         
         
         Set<Map.Entry<String, Double>> entradas = m.entrySet();
        
         System.out.println("Entradas antes del borrado: " +entradas);
         
         Iterator<Map.Entry<String,Double>> it; //definimos el iterador
         
         for(it = entradas.iterator(); it.hasNext();){
             Map.Entry<String, Double> e = it.next();
             if (e.getValue() > 1.71){
                 it.remove();
             }
         }
          System.out.println("Entradas después del borrado: " +entradas);
          */
     }
}
