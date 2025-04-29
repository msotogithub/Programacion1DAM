/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manue
 */
public class GestionSocios {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String dni = "";
        // usamos un conjunto para guardar los socios, así evitamos repeticiones
        // si usamos un conjunto TreeSet se ordenarán por DNI (ordenación natural)
        Set<Socio> socios = new TreeSet<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("socios.dat"))){
            socios = (TreeSet<Socio>) in.readObject();
        }  catch (IOException |ClassNotFoundException ex) {
             System.out.println(ex.getMessage());
         }
        int opcion;
        do{
            System.out.println("1.Alta");
            System.out.println("2.Baja");
            System.out.println("3.Modificación");
            System.out.println("4.Listado por dni");
            System.out.println("5.Listado por antigúedad");
            System.out.println("6.Salir");
            System.out.println("\nIntroducir opción: ");
            opcion = sc.nextInt();
            switch (opcion){
                case 1 -> {
                    System.out.println("dni: ");
                    dni = sc.next();
                    alta(socios, dni);
                }
                case 2 -> {
                    System.out.println("dni socio a eliminar: ");
                    dni = sc.next();
                    socios.remove(new Socio(dni));
                }
                case 3 -> {
                    System.out.println("dni socio a modificar: ");
                    dni = sc.next();
                    socios.remove(new Socio(dni));
                    alta(socios,dni);
                }
                case 4 -> {
                    System.out.println(socios);
                } 
                case 5 -> {
                    Comparator<Socio> c = new Comparator<>(){
                        @Override
                        public int compare (Socio o1, Socio o2){
                            return o2.antiguedad() - o1.antiguedad();
                        }
                    }; // creamos un objeto de una clase Comparator c
                    //y le pasamos este objeto como argumento al conjunto
                    Set<Socio> s = new TreeSet<>(c); 
                    s.addAll(socios); //volcamos todos los socios al nuevo conjunto
                    System.out.println(s);
                }
            }
        }while (opcion != 6);
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("socios.dat"))){
            out.writeObject(socios);
        } catch (IOException ex) {
             System.out.println(ex);
         }
     }
     static boolean alta(Set<Socio> socios, String dni){
         String nombre, fechaAlta;
         Scanner sc = new Scanner(System.in);
         System.out.println("nombre: ");
         nombre = sc.next();
         System.out.println("fecha de alta: ");
         fechaAlta = sc.next();
         Socio nuevo = new Socio(dni, nombre, fechaAlta);
         return socios.add(nuevo);
         
     }
}
