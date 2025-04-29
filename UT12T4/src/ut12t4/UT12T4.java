/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut12t4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author manue
 */
public class UT12T4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Integer, Jugador> plantilla = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        String posicion;
        boolean existe;
        Jugador jugador = null;
        Integer dorsal;
        int opcion;
        System.out.println("Introduzca una opción:");
        mostrarMenu();
        opcion = sc.nextInt();
        while(opcion != 6){
            switch (opcion){
                case 1 -> {
                    System.out.println("Introduzca dorsal a crear:");
                    dorsal = sc.nextInt();
                    altaJugador( plantilla, dorsal);
                     mostrarMenu();
                }
                case 2 -> {
                    System.out.println("Introduzca dorsal a eliminar:");
                    dorsal = sc.nextInt();
                    jugador = eliminarJugador( plantilla, dorsal);
                    System.out.println("Jugador eliminado: " + jugador);
                     mostrarMenu();
                }
                case 3 -> {
                    mostrar(plantilla);
                     mostrarMenu();
                }
                case 4 -> {
                     System.out.println("Introduzca posición a listar:");
                    posicion = sc.next();
                    mostrar(plantilla, posicion);
                     mostrarMenu();
                }
                case 5 -> {
                    System.out.println("Introduzca dorsal a modificar:");
                    dorsal = sc.nextInt();
                    existe = editarJugador(plantilla, dorsal);
                    if (!existe) {
                        System.out.println("El dorsal introducido no existe");
                    }
                     mostrarMenu();
                }                             
            }
               opcion = sc.nextInt();            
        }        
    }
    
    static void mostrarMenu(){
        System.out.println("***************************************");
        System.out.println("1.Alta");
        System.out.println("2.Eliminación");
        System.out.println("3.Mostrar plantilla");
        System.out.println("4.Mostrar por posición");
        System.out.println("5.Modificación");
        System.out.println("6.Salir");
        System.out.println("***************************************");
                 System.out.println("Introduzca una opción:");
         System.out.println("***************************************");
    }
    
    static void altaJugador(Map<Integer, Jugador> plantilla, Integer dorsal){
        //los jugadores pueden ser porteros, defensas, centrocampistas y delanteros
        Scanner sc = new Scanner(System.in);
        String dni, nombre, posicion = "";
        double estatura;
        boolean noValido = true;
        System.out.println("Introduzca los datos del jugador:");
        System.out.println("DNI: ");
        dni = sc.next();
        System.out.println("Nombre: ");
        nombre = sc.next();
        System.out.println("Posición: ");
        while(noValido){
            posicion = sc.next();
            switch(posicion.toUpperCase()){
                case "PORTERO", "DEFENSA","CENTROCAMPISTA", "DELANTERO" -> {
                    noValido = false;
                }                    
            }
        }
        System.out.println("Altura: ");
        estatura = sc.nextDouble();
        plantilla.put(dorsal, new Jugador(dni, nombre, posicion, estatura));
        
    }
    
    static Jugador eliminarJugador(Map<Integer, Jugador> plantilla, Integer dorsal){
        Jugador jugador = null;
        jugador = plantilla.remove(dorsal);
        return jugador;
    }
    
    static void mostrar(Map<Integer, Jugador> plantilla){
        System.out.println(plantilla);
    }
    
    static void mostrar(Map<Integer, Jugador> plantilla, String posicion){
        Collection <Jugador> jugadores = plantilla.values();
        for(Iterator<Jugador> it = jugadores.iterator(); it.hasNext();){
            Jugador jugador = it.next();
            if (jugador.posicion.equalsIgnoreCase(posicion))
                System.out.println(jugador);
        }
    }
    
    static boolean editarJugador(Map<Integer, Jugador> plantilla, Integer dorsal){
        Jugador jugadorviejo = null;
         boolean existe = false;
        jugadorviejo = plantilla.get(dorsal);
        if (jugadorviejo != null){
         existe = true;
         Scanner sc = new Scanner(System.in);
        String dni, nombre, posicion = "";
        double estatura;
        boolean noValido = true;
        System.out.println("Introduzca los datos del jugador:");
        // el DNI copiamos el que tenía
        dni = jugadorviejo.dni;
        System.out.println("Nombre: ");
        nombre = sc.next();
        System.out.println("Posición (portero/defensa/centrocampista/delantero): ");
        while(noValido){
            posicion = sc.next();
            switch(posicion.toUpperCase()){
                case "PORTERO", "DEFENSA","CENTROCAMPISTA", "DELANTERO" -> {
                    noValido = false;
                } 
                default ->{
                    System.out.println("Valor incorrecto");
                }
            }
        }
        System.out.println("Altura: ");
        estatura = sc.nextDouble();
        plantilla.replace(dorsal, new Jugador(dni, nombre, posicion, estatura));               
    }else {
            System.out.println("No hay jugador con ese dorsal");
        }
         return existe;
    }    
}
