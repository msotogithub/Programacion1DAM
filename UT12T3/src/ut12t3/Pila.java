/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut12t3;

import java.util.*;

/**
 *
 * @author manuel.soto
 */
public class Pila<T> {
     ArrayList<T> lista;
    
    public Pila(ArrayList<T> lista){
        this.lista = lista;
    }
    void apilar(T nuevo){
        lista.addFirst(nuevo);
    }
    T desapilar(){
        try{ //añadimos un try-catch porque me saltó la excepción del catch
       return lista.removeFirst();   
        }catch(NoSuchElementException ex){  //esto salta cuando se queda la lista vacía
            return null;
        }
    }
    
}
