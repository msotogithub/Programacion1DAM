/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author manue
 */
public class ClaseCollections {
     public static void main(String[] args) {
         List<Cliente> lista = new ArrayList<>();
         lista.add(new Cliente("111", "Pepe", "12/02/2001"));
         lista.add(new Cliente("115", "Ana", "12/02/2004"));
         lista.add(new Cliente("113", "Pepe", "12/02/2009"));
         lista.add(new Cliente("110", "Pepe", "12/02/2007"));
         System.out.println(lista);
         Collections.sort(lista);         
         System.out.println(lista);
         int indice = Collections.binarySearch(lista, new Cliente("113"));
         System.out.println("El cliente 113 está en el índice: " + indice);
     }
}
