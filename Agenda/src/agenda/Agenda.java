/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agenda;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manuel.soto
 */
public class Agenda {

    /**
     * @param args the command line arguments
     * Diseño de una agenda con el siguiente menu
     * 1 - Nuevo contacto
     * 2 - Buscar por nombre
     * 3 - Mostrar todos
     * 4 - Salir
     * La agenda tendrá un máximo de 20 personas
     * Se debe comprobar que la agenda no esté llena antes de añadir un nuevo contacto
     * Se debe comprobar que el nombre que se quiere insertar no esté ya en la agenda
     * La opción de búsqueda por nombre debe buscar con patrones
     * La tabla debe quedar ordenada alfabéticamente por nombre
     * Los datos se guardan en el archivo agenda.txt
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s;
        int opcion;
        boolean valorIncorrecto = true;
        Contacto[] agenda = new Contacto[0]; 
        Contacto[] busqueda = new Contacto[0];
         // cargar datos del fichero
         agenda = leerFichero(agenda);
         mostrarTodos(agenda);
        
        //mostramos el menú
        mostrarMenu();
        
        //pedimos opción al usuario
        s = new Scanner(System.in);
        while (valorIncorrecto){
       
            opcion = s.nextInt();
       
        switch (opcion){
            case 1 -> { //nuevo contacto
                // comprobar tabla llena
                agenda = nuevoContacto(agenda);
                System.out.println("*****************************");
                 mostrarMenu();
            }
            case 2 -> {// buscar por nombre
                
                busqueda = buscarPorNombre(agenda);
                mostrarTodos(busqueda);
                System.out.println("*****************************");
                 mostrarMenu();
            }
            case 3 -> { // mostrar todos
                mostrarTodos(agenda);
               System.out.println("*****************************");
                 mostrarMenu();
            }
            case 4 -> { // salir
                guardarFichero(agenda);
                System.out.println("Datos actualizados en agenda.txt");
                valorIncorrecto = false;
            }
            default -> {
                
                System.out.println("Opción no válida, introduzca otro valor.");
                mostrarMenu();
            }
        }
        }
       
     
        //pedir opción a usuario con Scanner
        
        //ordenar y guardar datos al salir del programa
        
    }
         public static Contacto[] nuevoContacto(Contacto[] agenda){
        // chequear si la agenda está llena
        // pedir datos al usuario y añadirlo al archivo
        Scanner s = new Scanner(System.in);
        String nombre;
        int telefono;
       
             System.out.println("Introduzca nombre del contacto: ");
             nombre = s.next();
             System.out.println("Introduzca teléfono del contacto: ");
             telefono = s.nextInt();
             
             agenda = addContacto(agenda, new Contacto(nombre, telefono));
    
        return agenda;
    }
         public static Contacto[] addContacto(Contacto[] agenda, Contacto contact){
             agenda = Arrays.copyOf(agenda, agenda.length +1);
             agenda[agenda.length -1] = contact;
             return agenda;
         }
         
         public static Contacto[] buscarPorNombre(Contacto[] agenda){
            Scanner s;
             String nombre;
             Contacto[] resultado = new Contacto[0];
             s = new Scanner(System.in);
             System.out.println("Introduzca patrón de búsqueda: ");
             nombre = s.next();
             
             for(Contacto contact: agenda){
                 if(contact.nombre.contains(nombre)){
                     resultado = addContacto(resultado, contact);
                 }
             }
             return resultado;
         }
         
         public static void mostrarTodos(Contacto[] agenda){
             for(Contacto contact: agenda){
                 if (contact != null){
                     System.out.println(contact);
                 }
                 
             }
         }
         
         public static void salir(){
             //ordenar tabla y guardar en fichero agenda.txt
             
         }
         public static void mostrarMenu(){
        System.out.println("Seleccione una opción: ");
        System.out.println("1 - Nuevo contacto");
        System.out.println("2 - Buscar por nombre");
        System.out.println("3 - Mostrar todos");
        System.out.println("4 - Salir");
         }
         
        static Contacto[] leerFichero(Contacto[] agenda){
             Scanner s;
             String nombre;
             int telefono;
                       
             try (BufferedReader in = new BufferedReader(new FileReader("agenda.txt"))){
                     String linea = in.readLine();
                     while (linea!=null){
                            s  = new Scanner(linea);
                            nombre = s.next();
                            telefono = s.nextInt();
                            addContacto(agenda, new Contacto(nombre,telefono));
                            linea = in.readLine();

                     }
                     
             } catch (FileNotFoundException ex) {
                 System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return agenda;
             
         }
        
        static void guardarFichero(Contacto[] agenda){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("agenda.txt"))){
            
            for(Contacto contact: agenda){
               bw.write(contact.toString());
                bw.newLine();  
            }    
               
        } catch (IOException ex) {
            System.out.println("Error al crear fichero: " +ex.getMessage());
        } 
        
        }
         
}
