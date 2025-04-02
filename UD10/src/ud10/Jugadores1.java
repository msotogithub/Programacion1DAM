/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud10;

import java.io.*;
import java.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuel.soto
 */
public class Jugadores1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s;
      
        String nombres = "";
        double mediaAltura=0;
        int mediaEdad=0, contador = 0;
        FileInputStream flujoDatos = null;

        try{
            flujoDatos = new FileInputStream("Personas.txt");
           
        }catch (IOException ex) {
           
            System.out.println("Error al abrir fichero");
        }catch (NoSuchElementException ex) {
            //System.out.println(ex.getMessage());
            System.out.println("Error al recuperar un valor del fichero de texto");
        }
        
        s = new Scanner(flujoDatos).useLocale(Locale.US);
         while(s.hasNext()){
                
                contador++;
               if (s.hasNext()){
                  nombres += s.next() + " "; 
               }else{
                   System.out.println("La línea " + contador +" no tiene el nombre");
               }                
               if(s.hasNextInt()){
                  mediaEdad +=s.nextInt(); 
               }
               else{
                   System.out.println("La línea " + contador +" no tiene un valor entero para la edad");
               }  
               if(s.hasNextDouble()){
                 mediaAltura +=s.nextDouble();  
               }else{
                   System.out.println("La línea " + contador +" no tiene un valor double para la altura");
               }  
              
            }
            mediaEdad = mediaEdad/contador;
            mediaAltura = mediaAltura/contador;
        System.out.println("Nombres: "+nombres);
        System.out.println("Media edades: " + mediaEdad );
        System.out.println("Media alturas: " + mediaAltura);
        }
    }
