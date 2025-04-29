/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud9t1;

import java.util.Arrays;

/**
 *
 * @author manue
 */
public class UD9T1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Futbolista[] tabla = {
            new Futbolista("511A", "Pepe", 24, 10),
            new Futbolista("211Z", "Ana", 24, 12),
            new Futbolista("711A", "Juan", 24, 10),
            new Futbolista("151A", "Eva", 21,5),
            new Futbolista("111F", "Fran", 30, 2)
        };
        /*
        System.out.println("Sin ordenar: \n" + Arrays.toString(tabla));
        Arrays.sort(tabla);
        System.out.println("Ordenada por DNI: \n" + Arrays.toString(tabla));
        Arrays.sort(tabla, new ComparaNombre());
        System.out.println("Ordenada por nombre: \n" + Arrays.toString(tabla));
        */
        Arrays.sort(tabla, new ComparaEdad());  
        System.out.println("Ordenadas por edad: \n " + Arrays.toString(tabla));
        Arrays.sort(tabla, new ComparaEdadNombre());  
        System.out.println("Ordenadas por edad y nombre: \n " + Arrays.toString(tabla));
        
    }
    
    
}
