/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author manue
 */
public class Enteros {
    
    public static void main(String[] args) {
        Collection<Integer> lista = new ArrayList<>();
        Collection<Integer> listaNoRepe = new ArrayList<>();
        
        for (int i = 0; i < 20; i++) {
            lista.add((int) (Math.random()*10+1));
        }
        System.out.println("Lista original: " + lista);
        
        for(Integer e : lista){
            if(!listaNoRepe.contains(e)){
                listaNoRepe.add(e);
            }
        }
        System.out.println("Lista sin repetidos: " + listaNoRepe);
    }
}
