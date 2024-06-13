
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dario
 */
public class jdbc_test {
    public static void main(String[]args){
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/jdbc_test";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
           //insecion de datos 
            statement.execute("INSERT INTO `usuarios` (`id`,`nombre`) VALUES(NULL, 'camilo');");
             System.out.println("");
             rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //Actualizacion de datos
             statement.execute("UPDATE `usuarios` SET `nombre`='EDER' WHERE `id` = 2;");
             System.out.println("");
             rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //Borrado o Eliminacion de datos
             statement.execute("DELETE FROM usuarios WHERE `usuarios`.`id` = 2;");
             System.out.println("");
             rs = statement.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(jdbc_test.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
 
};
