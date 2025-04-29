/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud14;



import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author manue
 */
public class UD141 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Connection con = null;
     PreparedStatement sentencia;
     int actualizados = 0;
     Scanner sc = new Scanner(System.in);
     String oficio;
     int salario;
     String sql_select = "select apellido, oficio, salario, comision from emple where oficio = ? and salario > ?";
     
     String url = "jdbc:oracle:thin:@localhost:1521:XE";
     try{
         con =  DriverManager.getConnection(url, "USUARIO", "usuario");
         sentencia = con.prepareStatement(sql_select);        
         //pedimos los valores por teclado
         System.out.println("Introduzca oficio: ");
         oficio = sc.next();
         System.out.println("Introduzca salario de corte: ");
        salario = sc.nextInt();
        //asignamos los valores a los parámetros
        sentencia.setString(1, oficio);
        sentencia.setInt(2, salario);
        //lanzamos la consulta
         ResultSet res = sentencia.executeQuery();        
         while (res.next()){
             System.out.println(res.getString("APELLIDO") + "  " + res.getString("OFICIO")
             + "  " + res.getString("SALARIO")+ "  " + res.getString("COMISION"));
         }        
         con.close();        
     }  catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }     
    }   
}
