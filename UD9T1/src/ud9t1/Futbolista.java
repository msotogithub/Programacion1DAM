/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud9t1;

/**
 *
 * @author manue
 */
public class Futbolista implements Comparable {
    String dni;
    String nombre;
    Integer edad;
    Integer goles;
    public Futbolista(String dni, String nombre, Integer edad, Integer goles){
        this.dni= dni;
        this.nombre = nombre;
        this.edad= edad;
        this.goles = goles;
    }
    
    @Override
    public String toString(){
        return dni + ", " + nombre + ", " + edad + ", " + goles + "\n";
    }
    public boolean equals(Object obj){
        Futbolista futbolista = (Futbolista) obj;
            return this.dni.equals(futbolista.dni);        
    }
    @Override
    public int compareTo(Object o) {
        Futbolista futbolista = (Futbolista) o;
        return this.dni.compareTo(futbolista.dni);
    }
}
