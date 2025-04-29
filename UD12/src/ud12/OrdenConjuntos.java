/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud12;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author manue
 */
public class OrdenConjuntos {
      public static void main(String[] args) {
          //hemos usado la interfaz Set para declarar la variable conjuntoEnteros
          //para poder referenciar a objetos de LinkedHashSet o TreeSet, ...
          Set<Integer> conjuntoEnteros = new LinkedHashSet<>();
          conjuntoEnteros.add(4);
           conjuntoEnteros.add(1);
           conjuntoEnteros.add(5);
           conjuntoEnteros.add(10);
           conjuntoEnteros.add(3);
           System.out.println(conjuntoEnteros);
           //opción 1 para ordenar
           Set<Integer> conjuntoEnterosOrdenados = new TreeSet<>();
           conjuntoEnterosOrdenados.addAll(conjuntoEnteros);
           System.out.println(conjuntoEnterosOrdenados);
           conjuntoEnteros = conjuntoEnterosOrdenados;
           // opción 2 para ordenar
           Set<Integer> conjuntoEnterosOrdenados2 = new TreeSet<>(conjuntoEnteros);
           System.out.println(conjuntoEnterosOrdenados2);
      }
}
