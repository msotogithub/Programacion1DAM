/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exev3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author manue
 */
public class Exev31 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Repuesto[] repuestos = new Repuesto[0]; 
        /*
        Repuesto[] repuestos = {
            new Repuesto(1, "tuerca", "mecanico", 5),
            new Repuesto(2, "tornillo", "mecanico", 9),
            new Repuesto(3, "arandela", "mecanico", 7),
            new Repuesto(4, "broca madera 6", "mecanico", 5),
            new Repuesto(5, "broca madera 8", "mecanico", 13),
            new Repuesto(6, "broca madera 5", "mecanico", 19),
            new Repuesto(7, "broca metal 6", "mecanico", 3),
            new Repuesto(8, "broca metal 8", "mecanico", 5),
            new Repuesto(9, "broca pared 8", "mecanico", 5),
            new Repuesto(10, "broca pared 6", "mecanico", 8),
            new Repuesto(11, "raton optico", "informatica", 5),
            new Repuesto(12, "raton inalambrico", "informatica", 15),
            new Repuesto(13, "teclado basico", "informatica", 7),
            new Repuesto(14, "teclado retroiluminado", "informatica", 6),
            new Repuesto(15, "monitor 15 pulgadas", "informatica", 3),
            new Repuesto(16, "monitor 17 pulgadas", "informatica", 12),
            new Repuesto(17, "fuente alimentacion", "informatica", 25),
            new Repuesto(18, "torre", "informatica", 5),
            new Repuesto(19, "cable alimentacion", "informatica", 15),
            new Repuesto(20, "foleos A3", "papeleria", 65),
            new Repuesto(21, "foleos A4", "papeleria", 14),
            new Repuesto(22, "foleos A5", "papeleria", 73),
            new Repuesto(23, "portaminas", "papeleria", 41),
            new Repuesto(24, "rotulador", "papeleria", 39),
            new Repuesto(25, "carpeta A3", "papeleria", 54),
            new Repuesto(26, "carpeta A5", "papeleria", 5),
            new Repuesto(27, "cuaderno A4", "papeleria", 5),
            new Repuesto(28, "lapiz B2", "papeleria", 16),
            new Repuesto(29, "lapiz HB", "papeleria", 23),
            new Repuesto(30, "goma blanda", "papeleria", 57),
            new Repuesto(31, "acuarelas", "papeleria", 54),
            new Repuesto(32, "arandela C7", "mecanico", 15),
            new Repuesto(33, "casquillo E27", "electrico", 51),
            new Repuesto(34, "cable USB A", "informatica", 35),
            new Repuesto(35, "casquillo E14", "electrico", 45),
            new Repuesto(36, "tuerca C5", "mecanico", 43),
            new Repuesto(37, "bonbilla blanca E27", "electrico", 53),
            new Repuesto(38, "cable USB C", "informatica", 53),
            new Repuesto(39, "bombilla E14", "electrico", 56),
            new Repuesto(40, "regleta 3 enchufes", "electrico", 12),
            new Repuesto(41, "regleta 5 enchufes", "electrico", 65),
            new Repuesto(42, "interruptor", "electrico", 5),
            new Repuesto(43, "boligrafo", "papeleria", 59),
            new Repuesto(44, "tuerca C2", "mecanico", 5),
            new Repuesto(45, "interruptor doble", "electrico", 5),
            new Repuesto(46, "cable monitor", "informatica", 25),
            new Repuesto(47, "enchufe", "electrico", 5),
            new Repuesto(48, "sobre A5", "papeleria", 30),
            new Repuesto(49, "enchufe doble", "electrico", 5),
            new Repuesto(50, "arandela C5", "mecanico", 52),
            new Repuesto(51, "interruptor pared", "electrico", 5),
            new Repuesto(52, "adaptador HDMI", "informatica", 14),
            new Repuesto(53, "enchufe pared", "electrico", 5),
            new Repuesto(54, "tarjeta A5", "papeleria", 25),
            new Repuesto(55, "casquillo doble", "electrico", 5),
        };
*/
        Repuesto[] repuestosFiltrados = new Repuesto[0]; 
        
        int opcion, stock;
        String descripcion;
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        
        repuestos = leerRepuestos();
        
        mostrarMenu();
        while(!salir){
           opcion = sc.nextInt();   

               switch (opcion){
              case 1 -> { //listar repuestos
                  Arrays.sort(repuestos);
                   System.out.println(Arrays.toString(repuestos));

                  mostrarMenu();
              }
              case 2 -> { // listar repuestos por descripción
                  Arrays.sort(repuestos,new ComparaDescripcion());
                  System.out.println(Arrays.toString(repuestos));
                  mostrarMenu();
              }
              case 3 -> { // listar repuestos por departamento y descripción
                  Arrays.sort(repuestos,new ComparaDepartamentoDescripcion());
                  System.out.println(Arrays.toString(repuestos));
                  mostrarMenu();
              }
              case 4 -> { // listar repuestos con stock inferior a...
                  System.out.println("Introduzca stock límite: ");
                  stock = sc.nextInt();
                  repuestosFiltrados = filtrarRepuestos(repuestos, stock);
                  System.out.println(Arrays.toString(repuestosFiltrados));
                  mostrarMenu();
              }
              case 5 -> { // buscar repuesto por descripción
                  System.out.println("Introduzca descripción: ");
                 
                  descripcion = sc.next();
                  repuestosFiltrados = buscarRepuestos(repuestos, descripcion);
                  System.out.println(Arrays.toString(repuestosFiltrados));
                  mostrarMenu();
              }
              case 6 -> { // alta repuesto
                 repuestos = addRepuesto(repuestos);
                  mostrarMenu();
              }
              case 7 -> {// modifica repuesto
                  modificaRepuesto(repuestos);
                  mostrarMenu();
              }
              case 8 -> {// borrado de repuesto
                  repuestos = borraRepuesto(repuestos);
                  mostrarMenu();
              }
              case 9 -> { // salir y guardar repuestos
                  guardarRepuestos(repuestos);
                  salir = true;
              }
          }
           }
          
        }
    
   
  
    static public void mostrarMenu(){
            System.out.println("*************************************************************");
            System.out.println("1.Listar repuestos ordenados por código");
            System.out.println("2.Listar repuestos ordenados por descripción");
            System.out.println("3.Listar repuestos ordenados por departamento y descripción");
            System.out.println("4.Listar repuestos con stock inferior a...");
            System.out.println("5.Buscar repuesto por descripción");           
            System.out.println("6.Alta repuesto");
            System.out.println("7.Modificación de repuesto");
            System.out.println("8.Borrado de repuesto");
            System.out.println("9.Salir");
            System.out.println("*************************************************************");
        
    }
     public static Repuesto[] addRepuesto(Repuesto[] tabla){
         Scanner sc = new Scanner(System.in);
         String descripcion, departamento;
         Integer codigo, stock;
         System.out.println("Introduzca código:");
         codigo = sc.nextInt();
         System.out.println("Introduzca descripcion:");
         descripcion = sc.next();
         System.out.println("Introduzca departamento:");
         departamento = sc.next();
         System.out.println("Introduzca stock:");
         stock = sc.nextInt();
         
        tabla = Arrays.copyOf(tabla, tabla.length+1);
        tabla[tabla.length-1] = new Repuesto(codigo, descripcion, departamento, stock);
             System.out.println("Repuesto añadido a tabla");
         System.out.println(Arrays.toString(tabla));
        return tabla;
    
    }
     
     public static void modificaRepuesto(Repuesto[] tabla){
         Scanner sc = new Scanner(System.in);
         String descripcion, departamento;
         Integer codigo, stock;
         boolean existe = false;
         System.out.println("Introduzca código:");
         codigo = sc.nextInt();
         for(Repuesto rep : tabla){
             if (rep.codigo.equals((Integer) codigo)){
                 existe = true;
                 System.out.println("Introduzca descripcion:");
                 descripcion = sc.next();
                  System.out.println("Introduzca departamento:");
                     departamento = sc.next();
                    System.out.println("Introduzca stock:");
                    stock = sc.nextInt();
                    rep.descripcion = descripcion;
                    rep.departamento = departamento;
                    rep.stock = stock;                   
             }
         }
         if (!existe){
             System.out.println("El código de repuesto no existe");
         }   
    }
     
     public static Repuesto[] borraRepuesto(Repuesto[] tabla){
         Repuesto[] repuestosFiltrados = new Repuesto[0];
         boolean encontrado = false;
         Scanner sc = new Scanner(System.in);
         
         Integer codigo;
         System.out.println("Introduzca código a borrar:");
         codigo = sc.nextInt();
                
         for(Repuesto rep : tabla){
             if(!rep.codigo.equals(codigo)){
                 repuestosFiltrados = addRepuesto(repuestosFiltrados, rep);
             } else{
                 System.out.println("Repuesto eliminado: " + rep.codigo + " "+ rep.descripcion);
                 encontrado = true;
                 
             }
         }
         if (!encontrado){
             System.out.println("No existe el código " + codigo);
         }
        return repuestosFiltrados;
    
    }
     
     public static Repuesto[] leerRepuestos(){
        Repuesto[] tabla = new Repuesto[0];
        
        try(ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream("repuestos.dat"))){
            tabla = (Repuesto[]) flujoEntrada.readObject();
        }catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        
        return tabla;
        
    }
     public static Repuesto[] filtrarRepuestos(Repuesto[] repuestos, int stock){
         Repuesto[] repuestosFiltrados = new Repuesto[0];
         for(Repuesto rep : repuestos){
             if(rep.stock < stock){
                 repuestosFiltrados = addRepuesto(repuestosFiltrados, rep);
             }
         }
         Arrays.sort(repuestosFiltrados);
         return repuestosFiltrados;
     }
     public static Repuesto[] buscarRepuestos(Repuesto[] repuestos, String desc){
         Repuesto[] repuestosFiltrados = new Repuesto[0];
         for(Repuesto rep : repuestos){
             if(rep.descripcion.contains(desc)){
                 repuestosFiltrados = addRepuesto(repuestosFiltrados, rep);
             }
         }
         Arrays.sort(repuestosFiltrados);
         return repuestosFiltrados;
     }
     static public Repuesto[] addRepuesto(Repuesto[] repuestos, Repuesto rep){
        repuestos = Arrays.copyOf(repuestos, repuestos.length +1);
        repuestos[repuestos.length -1] = rep;
        return repuestos;
    }
    
    public static void guardarRepuestos(Repuesto[] tabla){
        try(ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream("repuestos.dat"))){
            flujoSalida.writeObject(tabla);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    } 
}
