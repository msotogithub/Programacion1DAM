/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud12;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author manue
 * El tipo T debe tener implementada la interfaz Comparable para que se pueda
 * ordenar la tabla. Así limitamos los tipos posibles.
*/

public class Contenedor<T extends Comparable<T>> {
    private T[] objetos;
    
    public Contenedor(T[] objetos){
        this.objetos = objetos;
    }
    void insertarAlfinal(T nuevo){
        objetos = Arrays.copyOf(objetos, objetos.length +1);
        objetos[objetos.length-1] = nuevo;
    }
    void insertarAlPrincipio(T nuevo){
        objetos = Arrays.copyOf(objetos, objetos.length +1);
        //desplazamos todos los elementos un lugar al final para hacer hueco al principio
        System.arraycopy(objetos, 0, objetos, 1, objetos.length-1);
        objetos[0]= nuevo;
    }
    T extraerDelFinal(){
        T res = null;
        if(objetos.length>0){ //si la tabla no está vacía
            res = objetos[objetos.length-1];
            objetos = Arrays.copyOf(objetos, objetos.length-1);
        }
        return res;
    }
    T extraerDelPrincipio(){
        T res = null;
        if(objetos.length>0){
            res = objetos[0];
            objetos = Arrays.copyOfRange(objetos, 1,objetos.length);
        }
        return res;
    }
    void ordenar(){
        Arrays.sort(objetos);
    }
    public String toString(){
        return Arrays.deepToString(objetos);
    }
    void ordenar(Comparator<T> c){
        Arrays.sort(objetos,c);      
    }
    T get(int indice){
        T elem = null;
        if (indice >= objetos.length || indice <0){
            System.out.println("Valor de índice fuera de rango de la tabla");
        }else{
            for (int i = 0; objetos.length >= i; i++) {
            if (i == indice){
                elem = objetos[i];
                 }            
            }        
        }
        return elem;
    }
}
