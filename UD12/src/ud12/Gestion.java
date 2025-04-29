/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author manue
 */
public class Gestion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     List<Cliente> listaClientes = new ArrayList<>();
     Collection<Cliente> coleccionClie = listaClientes;
     
     Cliente cliente = new Cliente("111", "Marta", "12/02/2000");
     
     coleccionClie.add(cliente);
     
     coleccionClie.add(new Cliente("222", "Pepe", "01/01/2010"));
     
        System.out.println("Tamaño de la colección: " + coleccionClie.size());
        
        System.out.println("¿Está vacía? " + coleccionClie.isEmpty());
        
        System.out.println("¿Contiene el dato de Marta? " + coleccionClie.contains(cliente));
        
        System.out.println(coleccionClie);
    }
    
    static <U extends Number> int numerosNulos(U[] tabla){
        int cont = 0;
        for (U elem: tabla){
            if(elem == null){
                cont++;
            }
        }
        return cont;
    }
    
    static <E> E[] addElemento(E elem, E[] tabla){
        tabla = Arrays.copyOf(tabla, tabla.length + 1);
        tabla[tabla.length-1] = elem;
        return tabla;
        
    }
}
