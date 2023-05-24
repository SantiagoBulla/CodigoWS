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
    //decalarar variables de conexion 
    private Connection conexion;
    private String driver,user,password,bdName,urlBd; 

    public Conexion() {
        driver = "com.mysql.jdbc.Driver";
        user = "root";
        password = "";
        bdName = "sesion2";
        urlBd = "jdbc:mysql://localhost:3306/" + bdName;
        try {
            //crear instancia del driver
            Class.forName(driver).newInstance();
            //crear conexion
            conexion = DriverManager.getConnection(urlBd, user, password);
            System.out.println("conexion ok");
        } catch (Exception e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    public Connection obtenerConexion(){
        new Conexion();
        return conexion;
    }
    
    public Connection cerrarConexion() throws SQLException{
        conexion.close();
        return conexion;
    }
    
    
    
    
}
