/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud14;



import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author manue
 */
public class UD14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Connection con = null;
     Statement sentencia;
     int actualizados = 0;
     String sql_select = "select apellido, oficio, salario, comision from emple where oficio='ANALISTA' and "
             + "comision is not null";
     String sql_update = "update emple set comision=comision*1.1 where oficio = 'ANALISTA' and "
             + "comision is not null";
     String url = "jdbc:oracle:thin:@localhost:1521:XE";
     try{
         con =  DriverManager.getConnection(url, "USUARIO", "usuario");
         sentencia = con.createStatement();        
         //vemos los datos antes de la actualización
         ResultSet res = sentencia.executeQuery(sql_select);        
         while (res.next()){
             System.out.println(res.getString("APELLIDO") + "  " + res.getString("OFICIO")
             + "  " + res.getString("SALARIO")+ "  " + res.getString("COMISION"));
         }
         //actualizamos los datos
         actualizados = sentencia.executeUpdate(sql_update);
         //volvemos a consultar los datos después de actualizar
         System.out.println("Se han actualizado " + actualizados + " registros.");
         res = sentencia.executeQuery(sql_select);        
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
