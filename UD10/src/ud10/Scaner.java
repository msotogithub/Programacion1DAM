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
public class Scaner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s;
        double numero, suma=0;
        String texto = "";
        BufferedReader br = null;
        FileReader fr =  null; 
        try{
            fr =new FileReader("test1.txt");
            br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea !=null){
                s = new Scanner(linea).useLocale(Locale.US);
                numero = s.nextDouble();
                suma +=numero;
               
                if (s.hasNextDouble()){
                    numero = s.nextDouble();
                    suma +=numero;
                }
                if (s.hasNextDouble()){
                    numero = s.nextDouble();
                    suma +=numero;
                }
                
                linea = br.readLine();
            }
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al abrir fichero");
        }catch (NoSuchElementException ex) {
            //System.out.println(ex.getMessage());
            System.out.println("Error la recuperar un valor del fichero de texto");
        }
        finally{
            if (br != null){
            try{    
               br.close(); 
            }catch (IOException ex){
                    System.out.println(ex);
                    }
            
        }
        
        }
        System.out.println(suma);
        }
    }
