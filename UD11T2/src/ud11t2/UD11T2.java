/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud11t2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author manuel.soto
 */
public class UD11T2 {

    /**
     * @param args the command line arguments
     * Implementa una aplicación que permita guardar y recuperar los datos de 
     * los clientes de una empresa. Para ello, define la clase Cliente, que 
     * tendrá los atributos: id, nombre y teléfono. Los objetos Cliente se 
     * insertarán en una tabla. Para realizar las distintas operaciones, 
     * la aplicación tendrá el siguiente menú:
     * 1- Añadir nuevo cliente.
     * 2- Modificar datos.
     * 3- Dar de baja cliente.
     * 4- Listar los clientes.
     * 5- ¿Salir?
     * La información se guardará en un fichero binario, que se cargará en la
     * memoria al iniciar la aplicación y se grabará en disco, actualizada,
     * al terminar.

     */
    
    
    
    public static void main(String[] args) {
        
        Cliente[] tablaClientes = new Cliente[0];
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean salir = false;
        tablaClientes = leerFichero("Clientes.dat");
        
        mostrarMenu();
       
        
        while(!salir){
          opcion = sc.nextInt(); 
          switch (opcion){
              case 1 -> { //añadir nuevo cliente
                  tablaClientes = addCliente(tablaClientes);
                  mostrarMenu();
              }
              case 2 -> { // modificar datos
                  modificaCliente(tablaClientes);
                  mostrarMenu();
              }
              case 3 -> { // dar de baja cliente
                  tablaClientes = borrarCliente(tablaClientes);
                  mostrarMenu();
              }
              case 4 -> { //listar clientes
                  System.out.println(Arrays.toString(tablaClientes));
                  mostrarMenu();
              }
              case 5 -> { // salir
                  System.out.println("Guardamos datos y salimos");
                  guardarFichero("Clientes.dat",tablaClientes);
              }
              default -> {
                  System.out.println("Introduzca una opción válida");
              }
          }
        }
        
        
        
    }
    
    /********************************************************************
    Funciones definidas para el programa:
    *********************************************************************/
     public static Cliente[] addCliente(Cliente[] tabla){
         Scanner sc = new Scanner(System.in);
         String id, nombre;
         int telefono;
         System.out.println("Introduzca ID:");
         id = sc.next();
         System.out.println("Introduzca nombre:");
         nombre = sc.next();
         System.out.println("Introduzca teléfono:");
         telefono = sc.nextInt();
         
        tabla = Arrays.copyOf(tabla, tabla.length+1);
        tabla[tabla.length-1] = new Cliente(id,nombre,telefono);
        
        return tabla;
    }
     
     public static Cliente[] leerFichero(String nombreFichero){
        Cliente[] tabla = new Cliente[0];
        
        try(ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream(nombreFichero))){
            tabla = (Cliente[]) flujoEntrada.readObject();
        }catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        
        return tabla;
        
    }
    
    public static void guardarFichero(String nombreFichero, Cliente[] tabla){
        try(ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream(nombreFichero))){
            flujoSalida.writeObject(tabla);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    } 
    
    public static void mostrarMenu(){
        System.out.println("**************************************");
        System.out.println("Seleccione una opción: ");
        System.out.println("1 - Añadir nuevo cliente.");
        System.out.println("2 - Modificar datos.");
        System.out.println("3 - Dar de baja cliente.");
        System.out.println("4 - Listar los clientes.");
        System.out.println("**************************************");
    }
    
    public static void modificaCliente(Cliente[] tabla){
        String id = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca ID del cliente a modificar: ");
        id = sc.next();
        for(Cliente cli: tabla){
            if(cli.id.equals(id)){
                cli = actualizaCliente(cli);
            }
        }
    }
    
    public static Cliente actualizaCliente(Cliente cli){
       
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduca nuevo ID:");
        cli.id = sc.next();
        System.out.println("Introduzca nuevo nombre: ");
        cli.nombre = sc.next();
        System.out.println("Introduzca nuevo teléfono");
        cli.telefono = sc.nextInt();
        
        return cli;
    }
    
    public static Cliente[] borrarCliente(Cliente[] tabla){
        Cliente[] tablanueva = new Cliente[0];
        String id = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduca ID de cliente a eliminar: ");
        id = sc.next();
        for(Cliente cli : tabla){
            if(!cli.id.equals(id)){
                tablanueva = Arrays.copyOf(tablanueva, tablanueva.length+1);
                tablanueva[tablanueva.length-1] = cli;
            }
        }
        
        return tablanueva;
    }
    
}
