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

/**
 *
 * @author 57305
 */
public class Conexion {

    //variables de conexion 
    private String driver, user, password, nameBd, urlBd;
    private Connection conexion;

    public Conexion() {
        driver = "com.mysql.jdbc.Driver";
        user = "root";
        password = "";
        nameBd = "sesion2";
        urlBd = "jdbc:mysql://localhost:3306/" + nameBd;

        try {
            //instancia del driver 
            Class.forName(driver).newInstance();
            //conexion 
            conexion = DriverManager.getConnection(urlBd,user,password);
            System.out.println("Conexion ok");
        } catch (Exception e) {
            System.out.println("Error de conexion "+e);
        }
    }
    
    public Connection obtenerConexion(){
        //new Conexion();
        return this.conexion;
    }
    
    public Connection cerrarConexion() throws SQLException{
        //new Conexion();
        conexion.close();
        return conexion;
    }

    public static void main(String[] args) {
       Conexion cn = new Conexion();
       cn.obtenerConexion();
    }
    
}
