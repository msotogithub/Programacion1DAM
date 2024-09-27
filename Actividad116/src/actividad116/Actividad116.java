/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad116;

import java.util.Scanner;

/**
 *
 * @author manuel.soto
 */
public class Actividad116 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int horas,minutos,segundos,datoSegundosTotales;
        System.out.println("Introduzca los segundos totales:");
        datoSegundosTotales = new Scanner(System.in).nextInt();
        
        minutos = datoSegundosTotales/60;
        segundos = datoSegundosTotales%60;
        horas = minutos/60;
        minutos %=60;
        
        System.out.println("Corresponde a "+horas+" horas "+minutos+" minutos "+segundos+" segundos");
        
        
    }
    
}
