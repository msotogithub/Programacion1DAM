/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo1;


import java.util.Scanner;

/**
 *
 * @author manuel.soto
 */
public class Ejemplo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int dia;
      String textoDia;
        
        System.out.println("Introduzca el día de la semana (1 a 7):");
        dia = new Scanner(System.in).nextInt();
        
       textoDia = switch (dia){
            case 1->{
                yield "Lunes"; 
            }
            case 2 ->{
                yield "Martes";
            }
            case 3 ->{
                yield "Miércoles";
            }
            case 4 ->{
                yield "Jueves";
            }
            case 5 ->{
                yield "Viernes";
            }
            case 6 ->{
                yield "Sábado";
            }
            case 7 ->{
                yield "Domingo";
            }
            
            default->{
                /* en caso de no coincidir con ninguno de los casos anteriores
                es por haber introducido un mes incorrecto, devuelvo un 0
                para que luego se evalue como un error */ 
                yield "Error"; 
            }
        }; // cerramos con punto y coma porque es una instrucción de asignación
       if(textoDia.equals("Error")){
            System.out.println("Error: el día introducido es incorrecto");
       }else{
            System.out.println("Día: " + textoDia);
       }
        
    }
    
}
