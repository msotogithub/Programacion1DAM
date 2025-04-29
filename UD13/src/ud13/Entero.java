/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud13;

/**
 *
 * @author manue
 */
public class Entero {
    Integer valor;
    public Entero(Integer valor){
        this.valor= valor;
    }
    Entero siguiente(){
        return new Entero(valor + 1);
    }
    public String toString(){
        return "Entero{valor="+valor+ "}";
    }
}
