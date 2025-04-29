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
public class Exev3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] usuarios = new String[0];     
        Repuesto[] repuestos = new Repuesto[0]; 
        Repuesto[] repuestosFiltrados = new Repuesto[0]; 
        String usuario, departamento = "";
        int opcion;
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        usuarios = leerUsuarios();
        repuestos = leerRepuestos();
        System.out.println("Introduzca usuario:");
        usuario = sc.next();
        departamento = departamentoUsuario(usuarios, usuario);
        mostrarMenu(departamento);
        while(!salir){
           opcion = sc.nextInt();
           if(departamento.equalsIgnoreCase("administrador")){
               switch (opcion){
              case 1 -> { //Lista usuarios
                  listarUsuarios(usuarios);
                  mostrarMenu(departamento);
              }
              case 2 -> { // alta usuario
                  
                  mostrarMenu(departamento);
              }
              case 3 -> {//baja usuario
                  
                  mostrarMenu(departamento);
              }
              case 4 -> { // cambiar a otro usuario
                   System.out.println("Introduzca usuario: ");
                   usuario = sc.next();
                   departamento = departamentoUsuario(usuarios,usuario);
                  mostrarMenu(departamento);
              }
              case 5 -> { // salir y guardar usuarios
                  guardarUsuarios(usuarios);
                  salir = true;
              }
          }
           }else { // no es administrador
               repuestos = leerRepuestos();
               repuestosFiltrados = filtrarRepuestos(repuestos, departamento);
               switch (opcion){
              case 1 -> { //listar repuestos
                   System.out.println(Arrays.toString(repuestos));
                  System.out.println(Arrays.toString(repuestosFiltrados));
                  mostrarMenu(departamento);
              }
              case 2 -> { // listar repuestos por descripción
                  
                  mostrarMenu(departamento);
              }
              case 3 -> { // listar repuestos por stock
                  
                  mostrarMenu(departamento);
              }
              case 4 -> { // buscar repuesto por código
                  
                  mostrarMenu(departamento);
              }
              case 5 -> { // buscar repuesto por descripción
                  
                  mostrarMenu(departamento);
              }
              case 6 -> { // cambiar usuario
                  System.out.println("Introduzca usuario: ");
                   usuario = sc.next();
                   departamento = departamentoUsuario(usuarios,usuario);
                  mostrarMenu(departamento);
              }
              case 7 -> {// alta de repuesto
                 repuestos = addRepuesto(repuestos);
                  mostrarMenu(departamento);
              }
              case 8 -> {// modificación de repuesto
                  
                  mostrarMenu(departamento);
              }
              case 9 -> { //borrado de repuesto
                  
                  mostrarMenu(departamento);
              }
              case 10 -> { // salir y guardar repuestos
                  guardarRepuestos(repuestos);
                  salir = true;
              }
          }
           }
          
        }
    }
    static public String[] leerUsuarios(){
        String[] usuarios = new String[0];
        String linea;
        try(BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))){          
            linea = br.readLine();
            while(linea !=null){
                usuarios = addUsuario(usuarios, linea);
                linea = br.readLine();
            }
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al abrir fichero de usuarios");
        }
        return usuarios;
    }
    static public void guardarUsuarios(String[] usuarios){
        try(BufferedWriter bw = new BufferedWriter (new FileWriter("usuarios.txt"))){          
            for(String linea : usuarios){
                bw.write(linea);
                bw.newLine();
            }                                  
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al guardar el fichero de usuarios");
        }
    }
    static public void listarUsuarios(String[] usuarios){
        System.out.println(Arrays.toString(usuarios));
    }
    static public String[] addUsuario(String[] usuarios, String usuario){
        usuarios = Arrays.copyOf(usuarios, usuarios.length +1);
        usuarios[usuarios.length -1] = usuario;
        return usuarios;
    }
    static public String departamentoUsuario(String[] usuarios, String usuario){
       String departamento = "";
        String[] lineaUsuario = new String[2];
        for (String elem : usuarios){
            lineaUsuario = elem.split(" ");
            if (lineaUsuario[0].equalsIgnoreCase(usuario)){
                departamento = lineaUsuario[1];
            }
        }
        System.out.println("Departamento: " + departamento);
        return departamento;
        
    }

    static public void mostrarMenu(String departamento){
        if(departamento.equalsIgnoreCase("administrador")){
            System.out.println("1.Lista usuarios");
            System.out.println("2.Alta usuario");
            System.out.println("3.Baja usuario");
            System.out.println("4.Cambiar usuario");
            System.out.println("5.Salir");
        }else{
            System.out.println("1.Listar repuestos ordenados por código");
            System.out.println("2.Listar repuestos ordenados por descripción");
            System.out.println("3.Listar repuestos ordenados por stock");
            System.out.println("4.Buscar repuesto por código");
            System.out.println("5.Buscar repuesto por descripción");
            System.out.println("6.Cambiar usuario");
            System.out.println("7.Alta repuesto");
            System.out.println("8.Modificación de repuesto");
            System.out.println("9.Borrado de repuesto");
            System.out.println("10.Salir");
        }
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
     
     public static Repuesto[] leerRepuestos(){
        Repuesto[] tabla = new Repuesto[0];
        
        try(ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream("repuestos.dat"))){
            tabla = (Repuesto[]) flujoEntrada.readObject();
        }catch(IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        
        return tabla;
        
    }
     public static Repuesto[] filtrarRepuestos(Repuesto[] repuestos, String departamento){
         Repuesto[] repuestosFiltrados = new Repuesto[0];
         for(Repuesto rep : repuestos){
             if(rep.departamento.equalsIgnoreCase(departamento)){
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
