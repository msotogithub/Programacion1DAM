/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud12;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author manue
 */
public class Borrado {
      public static void main(String[] args) {
          Collection<Integer> lista = new ArrayList<>();
          for (int i = 0; i < 100; i++) {
              lista.add((int)(Math.random()*10+1));              
          }
          System.out.println(lista);
          Collection<Integer> c = new ArrayList<>();
          c.add(5); //añadimos el elemento a eliminar
          lista.removeAll(c); //eliminamos de lista todos los elementos de c.
          System.out.println(lista);
      }
}
