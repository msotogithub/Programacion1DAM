/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud12;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author manue
 */
public class Socio implements Comparable<Socio>, Serializable {
    String dni;
    String nombre;
    LocalDate fechaAlta;
    
    public Socio(String dni, String nombre, String alta){
        this.dni = dni;
        this.nombre = nombre;
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyy");
        this.fechaAlta = LocalDate.parse(alta, f);
    }
    // constructor para las búsquedas
    public Socio(String dni){
        this.dni = dni;
    }
    int antiguedad(){
        return (int) fechaAlta.until(LocalDate.now(), ChronoUnit.YEARS);
    }
    // ordenación natural por DNI:
    @Override
    public int compareTo(Socio o) {
       return dni.compareTo(o.dni);
    }
    //definimos el método de igualdad en base al atributo dni
    @Override
    public boolean equals(Object o){
        return dni.equals(((Socio) o).dni);
    }
    public String toString(){
        return "Socio{dni=" + dni + ", nombre="+nombre
                +", antigüedad="+antiguedad() + "}\n";
    }
}
