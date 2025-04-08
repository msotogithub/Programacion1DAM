/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud12t1;

import java.util.*;

/**
 *Implementar una aplicación donde se piden por consola números reales hasta que
 * se introduce un 0. A medida que se leen del teclado, los valores positivos se
 * insertan en una colección y los negativos en otra. Al final, se muestran ambas
 * colecciones y las sumas de los elementos de cada una de ellas. Por último, se
 * eliminan de ambas todos los valores que sean mayores que 10 o menores de -10 
 * y se vuelven a mostrar.
 * @author manuel.soto
 */
public class UD12T1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Collection<Double> positivos = new ArrayList<>();
        Collection<Double> negativos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Double real = 0.0, sumPos = 0.0, sumNeg = 0.0;
        System.out.println("Introduzca un número real (0 para terminar): ");
        real = sc.nextDouble();
        while(real != 0){
            if(real>0){
                positivos.add(real);
                sumPos += real;
            }else{
                negativos.add(real);
                sumNeg +=real;
            }
            real = sc.nextDouble();
        }
        System.out.println("Positivos: " + positivos);
        System.out.println("Suma de positivos: " + sumPos);
        System.out.println("Negativos: " + negativos);
        System.out.println("Suma de negativos: " + sumNeg);
        
        for(Iterator<Double> it = positivos.iterator(); it.hasNext();){
           if (it.next()> 10){
               it.remove();
           }
        }
        System.out.println("Positivos < 10: " + positivos);
        
        for(Iterator<Double> it = negativos.iterator(); it.hasNext();){
           if (it.next()< -10){
               it.remove();
           }
        }
        System.out.println("Negativos < -10: " + negativos);
        
    }
    
}
