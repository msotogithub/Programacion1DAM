/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud11t3;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UD11T3 {


    public static void main(String[] args) {
        int[] t1 = {3,7,9};
        int[] t2 = {1,5,10};
        int[] t3 = {12, 13, 15};
        int[] t4 = {20, 29};
        
        String[] nombresFicheros = {"Fichero1.dat","Fichero2.dat","Fichero3.dat", "Fichero4.dat"};
      
       /* 
        generaFicheros(t1,"Fichero1.dat");
        generaFicheros(t2,"Fichero2.dat");
        generaFicheros(t3,"Fichero3.dat");
        generaFicheros(t4,"Fichero4.dat");
        */
       for(String nombre: nombresFicheros){
           leeFichero(nombre);
       }
       // pedimos al usuario un número 
        System.out.println("Introduzca un número entero: ");
        Scanner s = new Scanner(System.in);
        int numero = s.nextInt();
        
         for(String nombre: nombresFicheros){
           buscaNumero(nombre,numero);
       }
            
    }
    
    public static void generaFicheros(int[] t, String nombreFichero){
        
        try (ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream(nombreFichero))){
            flujoSalida.writeObject(t);
        }  catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void leeFichero(String nombreFichero){
        int[] tabla = new int[0];
        try (ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream(nombreFichero))){
            tabla = (int[])flujoEntrada.readObject();
        }  catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(Arrays.toString(tabla));
    }
    public static void buscaNumero(String nombreFichero,int numero){
        int[] tabla = new int[0];
        try (ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream(nombreFichero))){
            tabla = (int[])flujoEntrada.readObject();
        }  catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        // una vez tengo la tabla con los números, la recorro a ver si está el del usuario
        for (int i = 0; i <tabla.length; i++) {
            if (tabla[i]== numero){
                System.out.println("El número está en el fichero: "+ nombreFichero);
                System.out.println("En la posición: " + i + " de la tabla");
            }
        }
 
    }
}
