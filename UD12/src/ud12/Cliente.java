/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author manue
 */
public class Cliente implements Comparable<Cliente> {

    String dni;
    String nombre;
    LocalDate fechaNacimiento;
    
    Cliente(String dni, String nombre, String fechaNacimiento){
        this.dni = dni;
        this.nombre = nombre;
        DateTimeFormatter formatoFechas = 
                DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, formatoFechas);
    }
     Cliente(String dni){
         this.dni = dni;
     }
    
    int edad(){
        return (int)fechaNacimiento.until(LocalDate.now(), ChronoUnit.YEARS);
    }
    
    @Override
    public boolean equals(Object ob){
        return dni.equals(((Cliente)ob).dni);
    }
    @Override
    public int compareTo(Cliente otro) {
        return dni.compareTo(otro.dni); //usamos el compareTo de la clase String
    }
    
    @Override
    public String toString(){
        return "DNI: " + dni + " Nombre: " + nombre + ", Edad: " + edad() + "\n";
    }
    
}
