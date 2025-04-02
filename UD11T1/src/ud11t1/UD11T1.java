/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud11t1;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.ClassNotFoundException;

public class UD11T1 {
    /*Implementa una aplicación que gestione una lista de nombres ordenada por
    *orden alfabético. Al arrancar se leerá de un fichero los nombres insertados 
    anteriormente y se pedirán nombres nuevos hasta que se introduzca la cadena "fin".
    Cada nombre que se introduzca deberá añadirse a los que ya había, de forma 
    que la lista permanezca ordenada. Al terminar, se guardará en el fichero
    la lista actualizada.
    */
public static void main(String[] args) {
//declaramos una tabla dinámica de nombres
        String[] nombres = new String[0];
        String nombre;
        
//leemos los datos del fichero si existiera
        
        nombres = leerFichero("Datos.dat");
        
//declaramos un objeto Scanner para leer nombres del teclado
        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca un nombre: ");
        nombre = s.next();
        
        while(!nombre.equals("fin")){
            nombres = addNombre(nombres,nombre);
            nombre = s.next();
        }
        
//tras terminar la inserción de nuevos nombres, ordenamos la tabla
        Arrays.sort(nombres);
//opcionalmente podemos mostrar la lista para ver que funciona
        System.out.println(Arrays.toString(nombres));
        
//guardamos los datos de la tabla de nombres en el archivo binario
        
        guardarFichero("Datos.dat",nombres);
        
    }

// Declaración de funciones a utilizar en el programa principal

    public static String[] addNombre(String[] tabla, String nombre){
        tabla = Arrays.copyOf(tabla, tabla.length+1);
        tabla[tabla.length-1] = nombre;
        
        return tabla;
    }
    
    public static String[] leerFichero(String nombreFichero){
        String[] tablaNombres = new String[0];
        
        try(ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream(nombreFichero))){
            tablaNombres = (String[]) flujoEntrada.readObject();
        }catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        
        return tablaNombres;
        
    }
    
    public static void guardarFichero(String nombreFichero, String[] tablaNombres){
        try(ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream(nombreFichero))){
            flujoSalida.writeObject(tablaNombres);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
