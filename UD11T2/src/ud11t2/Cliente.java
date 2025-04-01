/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud11t2;

import java.io.Serializable;

/**
 *
 * @author manuel.soto
 */
public class Cliente implements Serializable {
    String id, nombre;
    int telefono;
    public Cliente(String id, String nombre, int telefono){
        this.id = id;
        this.nombre = nombre;
        this.telefono  = telefono;
    }
    public String toString(){
        return "Cliente{id: "+id+", nombre: "+nombre+", teléfono: "+ telefono+"}";
    }
    
}
