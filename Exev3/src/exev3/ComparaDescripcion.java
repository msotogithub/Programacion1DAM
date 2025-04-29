/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exev3;

import java.util.Comparator;

/**
 *
 * @author manue
 */
public class ComparaDescripcion implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return ((Repuesto) o1).descripcion.compareTo(((Repuesto) o2).descripcion);
    }
    
}
