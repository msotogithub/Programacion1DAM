/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bucles33;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author manuel.soto
 */
public class Bucles33 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    /* El programa genera un número entre 1 y 100 y el usuario
        tiene que adivinarlo. En cada intento el programa debe
        informar si el número es mayor o menor al indicado por 
        el usuario. El programa termina cuando el usuario acierta
        o cuando se rinde informando el valor -1
        
        */
    int numeroUsuario = 1000;
    Random ran = new Random();
    int numeroAleatorio = ran.nextInt(101);
    Scanner sc = new Scanner(System.in);   
    System.out.println("¿Qué número es?:");
    
    while (numeroUsuario != numeroAleatorio && numeroUsuario != -1){
         
           numeroUsuario = sc.nextInt();
           if (numeroUsuario > numeroAleatorio && numeroUsuario != -1){
               System.out.println("El número es menor, prueba de nuevo: ");
           }else if (numeroUsuario < numeroAleatorio && numeroUsuario != -1){
               System.out.println("El número es mayor, prueba de nuevo: ");
           }
           
       }
        if(numeroUsuario == numeroAleatorio){
            System.out.println("Enhorabuena, has acertado!!");
        }else if (numeroUsuario == -1){
             System.out.println("Juego abortado!!");
        }
    
    }
    
}
