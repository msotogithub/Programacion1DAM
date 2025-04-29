/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud12;

import java.util.Arrays;

/**
 *
 * @author manue
 */
public class UD12_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Contenedor<Integer> c = new Contenedor<>(new Integer[0]);
        for (int i = 0; i < 20; i++) {
            c.insertarAlfinal((int)(Math.random()*20));
        }
        System.out.println("Sin ordenar: "+ c);
        c.ordenar();
        System.out.println("Ordenado: "+ c);
        Integer n = c.extraerDelPrincipio();
        System.out.println("Elemento extraído: " + n);
        System.out.println("Después de extraer: " + c);
        
    }
    
    static <U extends Number> int numerosNulos(U[] tabla){
        int cont = 0;
        for (U elem: tabla){
            if(elem == null){
                cont++;
            }
        }
        return cont;
    }
    
    static <E> E[] addElemento(E elem, E[] tabla){
        tabla = Arrays.copyOf(tabla, tabla.length + 1);
        tabla[tabla.length-1] = elem;
        return tabla;
        
    }
}
