/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud13;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author manue
 */
public class UD13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  Function<Integer, Integer> f1 = Calculos::cubo;
  Calculos calc = new Calculos();
  Function<Integer, Integer> f2 = calc::cuadrado; //necesitamos instanciar un objeto antes
  Function<Entero,Entero> siguienteEntero = Entero::siguiente;
  Integer[] t={1,2,3,4,5};
  //Integer[] t2={6,7,8,9,10};
  Double[] t3 = {1.,2.,3.,4.,5.};
  
  
  Double[] t1 = {1.,2.,3.,4.,5.};
  Double[] t2 ={2.,5.,3.,7.,0.};
  Double[] resul = operarTablas(t1, t2, new Double[0], Calculos::producto);
  
   System.out.println(Arrays.toString(resul));
  
  aplicar(t3,4, Calculos::raizN);
  System.out.println(Arrays.toString(t3));
  
  aplicar(t,calc::cuadrado);
 // aplicar(t2, f1);
  
        System.out.println(Arrays.toString(t));
        System.out.println(Arrays.toString(t2)); 
        System.out.println(siguienteEntero.apply(new Entero(3)));
    }
    
    static <T> List<String> saludarGrupo(T[] grupo, Saludo<T> saludo){
        List<String> resultado = new ArrayList<>();
        for (T elem : grupo){
            resultado.add(saludo.saludar(elem));
        }
        return resultado;
    }
    static <T> T maximo(T[] tabla, Comparator<T> comp){
        T max = tabla[0]; //inicializamos al primer elemento de la tabla       
        for (T elem : tabla){           
            if(comp.compare(elem, max)>0){
                max = elem;
            }
        }
        return max;
    }
    static <T> void aplicar(T[] tabla, Function<T,T> m){
        for(int i=0; i<tabla.length; i++){
            tabla[i] = m.apply(tabla[i]);
        }
    }
      static <T,V> void aplicar(T[] tabla, V n, FuncionN<T,V> m){
        for(int i=0; i<tabla.length; i++){
            tabla[i] = m.operar(tabla[i],n);
        }
    }
   static <T, V, U> U[] operarTablas(T[] t1, V[] t2, U[] res, Funcion2<T,V,U> func){
       if(t1.length == t2.length){
           res = Arrays.copyOf(res,t1.length);
           for (int i = 0; i < t1.length; i++) {
               res[i] = func.operar(t1[i], t2[i]);
           }
       }else{
           res = null;
       }
       return res;
   }
   
    
    
    static <T> T[] filtrar(T[] tabla, Predicate<T> chequeo){
        //como no podemos crear una tabla genérica con new, creamos una como copia 
        //de la original, pero de longitud 0, para ir añadiendo los que pasen el chequeo
        T[] resultado = Arrays.copyOf(tabla, 0); 
        for (T elem : tabla){
            if (chequeo.test(elem)){
                resultado = Arrays.copyOf(resultado, resultado.length +1);
                resultado[resultado.length -1] = elem;
            }
        }
        return resultado;
    }
    
    static <T, V> V[] transformar(T[] tablaOriginal, V[] tablaTransformada, Function<T, V> funcion){
        //redimensionamos la tabla a devolver del mismo tamaño que la original
        tablaTransformada = Arrays.copyOf(tablaTransformada, tablaOriginal.length);
        for( int i = 0; i<tablaOriginal.length; i++){
            tablaTransformada[i] = funcion.apply(tablaOriginal[i]);
        }
        return tablaTransformada;
    }
    
    static <T> void paraCada(T[] tabla, Consumer<T> operacion){
        for (T elem : tabla){
            operacion.accept(elem);
        }
    }
}
