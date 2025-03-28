/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda;

/**
 *
 * @author manuel.soto
 */
public class Contacto {
    String nombre;
    int telefono;
    
    Contacto(String nom, int telef){
        nombre = nom;
        telefono = telef;
    }
    @Override
    public String toString(){
        return nombre + ": "+telefono;
    }
}
