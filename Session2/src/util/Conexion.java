package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 57305
 */
public class Conexion {
    private String driver, user, bdName,password, urlBd;
    private Connection conexion;
    
    public Conexion(){
        this.driver = "com.mysql.jdbc.Driver";
        this.user = "root";
        this.password = "";
        this.bdName = "session2";
        this.urlBd = "jdbc:mysql://localhost:3306/"+bdName;
        
        try {
            //crear instancia del driver
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlBd,user,password);
            System.out.println("Conexion ok");
        } catch (Exception e) {
            System.out.println("Error en conexion "+e);
        }
    }
    
    public Connection obtenerConexion(){
        return conexion;
    }
    
    public Connection cerrarConexion() throws SQLException{
        conexion.close();
        conexion = null;
        return conexion;
    }
    
}
