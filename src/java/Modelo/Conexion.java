package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;
                                                                                           
public class Conexion {                                                                             
    Connection conx=null;                                                                    
    String BD="bd_ventas", USER="root", KEY="123456", HOST="localhost", URL="jdbc:mysql://"+HOST+":3306/";
    //"xxxxxx" <- contraseña de la bases de datos
    //Conección con la bases de datos
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conx = DriverManager.getConnection(URL+BD,USER,KEY);
            //JOptionPane.showMessageDialog(null,"se conecto a la bases de datos","Conexión!!!", 1);
        }catch(SQLException | ClassNotFoundException ex){
            System.out.println("Error al establecer conexión en la BD "+ex);
            JOptionPane.showMessageDialog(null, "Error al establecer conexión en la BD "+ex, "Conexión!!", 1);
        }
        return conx;
    }
}
