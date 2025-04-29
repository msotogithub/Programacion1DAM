/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud9t1;

import java.util.Comparator;

/**
 *
 * @author manue
 */
public class ComparaNombre implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
            return (((Futbolista)o1).nombre.compareTo(((Futbolista)o2).nombre));
    }
    
}
