/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author manue
 */
public class Conjuntos {
     public static void main(String[] args) {
      List<Integer> lista = new ArrayList<>();
         for (int i = 0; i < 30; i++) {
             lista.add((int) (Math.random()*10) + 1);
         }
 //ordenamos obteniendo el orden natural de la clase Integer en una clase Comparator
        Comparator<Integer> c = Comparator.naturalOrder();
        lista.sort(c);
        System.out.println("Lista original: " + lista);
        Set<Integer> sinRepeticiones = new TreeSet<>();
        sinRepeticiones.addAll(lista); //al añadir todos, y ser un conjunto, se eliminan los duplicados
         System.out.println("Sin repeticiones: " + sinRepeticiones);
         Set<Integer> repetidos = new TreeSet<>();
         for (Integer e : sinRepeticiones){
             lista.remove(e); //elimina la ocurrencia de e
         }
         repetidos.addAll(sinRepeticiones);
         System.out.println("Repetidos: " + repetidos);
         Set<Integer> unicos = new TreeSet<>();
         unicos.addAll(sinRepeticiones);
         unicos.removeAll(repetidos);
         System.out.println("Elementos no repetidos: " + unicos);
     }
    
}
