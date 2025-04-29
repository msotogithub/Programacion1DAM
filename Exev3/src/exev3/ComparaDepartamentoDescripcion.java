/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exev3;

import java.util.Comparator;

/**
 *
 * @author manue
 */
public class ComparaDepartamentoDescripcion implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        int comparaDepart =   ((Repuesto) o1).departamento.compareTo(((Repuesto) o2).departamento);
        if(comparaDepart != 0){
            return comparaDepart;
        }else{ // a igualdad de departamento, compara por descripción
           return ((Repuesto) o1).descripcion.compareTo(((Repuesto) o2).descripcion); 
        }
         
    }
    
}
