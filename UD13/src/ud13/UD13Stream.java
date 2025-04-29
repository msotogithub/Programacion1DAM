/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud13;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author manue
 */
public class UD13Stream {
    
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("dado");
        lista.add("arte");
        lista.add("bola");
        lista.add("asa");
        lista.add("buzo");
        lista.add("coche");
        lista.add("barco");
        lista.add("duna");
        
       lista.stream()
               .filter(s -> s.startsWith("a"))
               .forEach(System.out::println);
        
       Cliente[] tablaClientes = {
           new Cliente("111", "Marta", "12/02/2000"),
           new Cliente("115", "Jorge", "16/03/1999"),
           new Cliente("112", "Carlos", "01/12/2001"),
           new Cliente("211", "Ana", "07/12/2001")           
       };
      
        System.out.println("Suma edades: " + Arrays.stream(tablaClientes)
        .mapToInt(c -> c.edad())
        .sum());
        
        
         System.out.println("Media edades: " + Arrays.stream(tablaClientes)
                 .mapToInt(Cliente::edad) //devuelve un IntStream (Stream de enteros)
                 .average()
                 .getAsDouble()); 
         
         System.out.println("Suma edades: " + Arrays.stream(tablaClientes)
                 .map(Cliente::edad) //devuelve un IntStream (Stream de enteros)
                 .reduce(0, (a, b) -> a + b)
                    );
         
       
       Comparator<Cliente> comp = (x,y) -> x.nombre.compareTo(y.nombre);
      
        System.out.println(Arrays.stream(tablaClientes)
              .filter(c -> c.fechaNacimiento.isAfter(LocalDate.of(2000,12,31)))
              .count());
        
       Stream<Integer> streamEnteros = Stream.of(4, 3, 7, 1,
                0, 8, 9, 3, 5,
                4, 2, 1, 4, 6, 
                8, 1, 0, 2, 3);
       
        Stream<Integer> streamNuevo = Stream.of(-1, -6, -3, -3);
      
        Stream.concat(streamEnteros, streamNuevo)
                .distinct()
                .forEach(x -> System.out.print(x + " "));
        
    }
}
