/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exev3;

import java.io.Serializable;

/**
 *
 * @author manue
 */
public class Repuesto implements Comparable, Serializable {
    Integer codigo;
    String descripcion;
    String departamento;
    Integer stock;
    public Repuesto(int codigo, String descripcion, String departamento, int stock){
        this.codigo= codigo;
        this.descripcion= descripcion;
        this.departamento = departamento;
        this.stock= stock;
    }
    @Override
    public int compareTo(Object rep) {
        return codigo.compareTo(((Repuesto) rep).codigo);
    }
    public String toString(){
       // return codigo + " \t" + descripcion + " \t " + departamento + " \t" + stock + "\n";
        return codigo  + " \t " + departamento + " \t" + stock + " \t" + descripcion + "\n";
    }
    
}
