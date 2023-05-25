/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 57305
 */
public class Conexion {
    private String driver, usuario, clave, dbNombre, dbUrl;
    private Connection conexion;

    public Conexion() {
        driver = "com.mysql.jdbc.Driver";
        usuario = "root";
        clave = "";
        dbNombre = "sesion2";
        dbUrl = "jdbc:mysql://localhost:3306/"+dbNombre;
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(dbUrl,usuario,clave);
            System.out.println("Conexion ok");
        } catch (Exception e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    
    public Connection obtenerConexion(){
        new Conexion();
        //System.out.println("conexion ok");
        return conexion;
    }
    public Connection cerrarConexion() throws SQLException{
        conexion.close();
        return conexion;
    }
    
    
    
    
    
}
