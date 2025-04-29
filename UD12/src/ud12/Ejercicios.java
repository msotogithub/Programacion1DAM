/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud12;

import java.util.*;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author manue
 */
public class Ejercicios {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduzca una frase:");
        String frase = sc.nextLine();
        Scanner scf = new Scanner(frase);
        ArrayList<String> palabras = new ArrayList<>();
        ArrayList<String> palabrasRepetidas = new ArrayList<>();
        ArrayList<String> palabrasNoRepetidas = new ArrayList<>();
        while(scf.hasNext()){
           palabras.add(scf.next());         
        }
        System.out.println("Todas: " + palabras);
        //para calcular las no repetidas uso el método estático frequency de Collections
        for(String elem:palabras){
            if (Collections.frequency(palabras, elem)>1){
                if(!palabrasRepetidas.contains(elem)){
                  palabrasRepetidas.add(elem);  
                }                
            }else{
                palabrasNoRepetidas.add(elem);
            }
        }
         System.out.println("Repetidas: " + palabrasRepetidas);
          System.out.println("No repetidas: " + palabrasNoRepetidas);
    }
}
