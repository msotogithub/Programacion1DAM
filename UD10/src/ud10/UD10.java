/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud10;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuel.soto
 */
public class UD10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String texto = "";
        FileReader in = null;
        try{
            in = new FileReader("test.txt");
            int caracter = in.read();
            while(caracter !=-1){
                texto += (char)caracter;
                caracter = in.read();
            }
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al abrir fichero");
        }finally{
            if (in != null){
            try{    
               in.close(); 
            }catch (IOException ex){
                    System.out.println(ex);
                    }
            
        }
        
        }
        System.out.println(texto);
        }
    }
