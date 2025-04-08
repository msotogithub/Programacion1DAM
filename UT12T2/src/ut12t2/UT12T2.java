/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut12t2;

import java.util.*;

/**
 *Implementa un método genérico al que se le pasa una lista de valores de la
 * clase genérica T y devuelve otra donde se han eliminado las repeticiones.

 * @author manuel.soto
 */
public class UT12T2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> listaEnteros = new ArrayList<>();
        ArrayList<String> listaNombres = new ArrayList<>();
        listaEnteros.add(1);
        listaEnteros.add(6);
        listaEnteros.add(9);
        listaEnteros.add(1);
        listaEnteros.add(4);
        listaEnteros.add(6);
        listaEnteros.add(3);
        listaEnteros.add(1);
        
        listaNombres.add("Pepe");
        listaNombres.add("Ana");
        listaNombres.add("Pepe");
        listaNombres.add("Juan");
        listaNombres.add("Rosa");
        listaNombres.add("Raul");
        listaNombres.add("Pepe");
        listaNombres.add("Juan");
        System.out.println("Enteros: " + listaEnteros);
        System.out.println("Nombres: "+ listaNombres);
        
        listaEnteros = eliminaRepetidos(listaEnteros);
        listaNombres = eliminaRepetidos(listaNombres);
        
        System.out.println("Enteros sin repetidos: " + listaEnteros);
        System.out.println("Nombres sin repetidos: "+ listaNombres);
        
        
    }
    static <T> ArrayList<T> eliminaRepetidos(ArrayList<T> lista){
        lista = new ArrayList<T>(new TreeSet<>(lista));
        
        return lista;
    } 
    
}
