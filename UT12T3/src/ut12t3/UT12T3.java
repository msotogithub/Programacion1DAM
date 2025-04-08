/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut12t3;

import java.util.*;

/**
 *Implementa las clases Cola y Pila genéricas, utilizando objetos ArrayList para
 * guardar los elementos.
 * @author manuel.soto
 */
public class UT12T3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Pila<Integer> enteros = new Pila<>(new ArrayList<Integer>());
       Cola<String> nombres = new Cola<>(new ArrayList<String>());
       Integer elem;
       String nombre;
       enteros.apilar(2);
       enteros.apilar(5);
       enteros.apilar(1);
       enteros.apilar(4);
        System.out.println(enteros.lista);
        //vaciamos la pila de enteros
        elem = enteros.desapilar();
       while(elem !=null){
           System.out.print(elem + " ");
           elem = enteros.desapilar();
       }
        System.out.println(""); 
        
       nombres.encolar("Juan");
       nombres.encolar("Ana");
       nombres.encolar("Pepe");
       nombres.encolar("Rosa");
        System.out.println(nombres.cola);
      
       //vaciamos la pila de nombres
       nombre = nombres.desencolar();
       while(nombre !=null){
           System.out.print(nombre + " ");
           nombre = nombres.desencolar();
       }
        System.out.println(""); 
    }
    
}
