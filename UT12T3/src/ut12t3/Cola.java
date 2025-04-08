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
public class Cola<T> {
      ArrayList<T> cola;
    
    public Cola(ArrayList<T> cola){
        this.cola = cola;
    }
    void encolar(T nuevo){
        cola.addFirst(nuevo);
    }
    T desencolar(){
       try{ //añadimos un try-catch porque me saltó la excepción del catch
       return cola.removeLast();   
        }catch(NoSuchElementException ex){ //esto salta cuando se queda la lista vacía
            return null;
        }           
    }
}
