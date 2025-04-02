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
public class Scaner1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s;
        double numero, suma=0;
        String texto = "";
        FileInputStream fis = null;
       
        try{
            fis =new FileInputStream("test1.txt");
           

        }catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al abrir fichero");
        }
        
         s = new Scanner(fis);
         while(s.hasNext()){
             numero = s.nextInt();
             suma += numero;
         }
         
         
        System.out.println(suma);
        }
    }
