/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut12t4;

/**
 *
 * @author manue
 */
public class Jugador{
    String dni;
    String nombre;
    String posicion;
    double estatura;
    
    Jugador(String dni, String nombre, String posicion, double estatura){
    this.dni = dni;
    this.nombre = nombre;
    this.posicion = posicion;
    this.estatura = estatura;
}
    @Override
    public String toString(){
        return "Jugador {dni: " + dni +", nombre: " + nombre+", posición: " + posicion + ", estatura: " + estatura +"}\n"; 
    }  
}
