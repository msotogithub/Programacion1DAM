/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud13;

/**
 *
 * @author manue
 */
public class Calculos {
    Integer cuadrado(Integer a){
        return a*a;
    }
    static Integer cubo(Integer x){
        return x*x*x;
    }
    static Double raizN(Double x, Integer n){
        return Math.pow(x, 1./n);
    }
    static Double raiz3(Double x){
        return Math.pow(x,1./3);
    }
    static Double raiz2(Double x){
        return Math.sqrt(x);
    }
    static Double producto(Double x, Double y){
        return x*y;
    }
}
