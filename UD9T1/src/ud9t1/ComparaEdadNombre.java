/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud9t1;

import java.util.Comparator;

/**
 *
 * @author manue
 */
public class ComparaEdadNombre implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
         int comparaEdad = ((Futbolista)o1).edad.compareTo(((Futbolista)o2).edad);
        if (comparaEdad !=0){ // si no tienen la misma edad, no miramos el nombre
            return comparaEdad;
        }else { // si tienen la misma edad, comparamos por nombre
            return (((Futbolista)o1).nombre.compareTo(((Futbolista)o2).nombre));
        }
        
    }
    
}
