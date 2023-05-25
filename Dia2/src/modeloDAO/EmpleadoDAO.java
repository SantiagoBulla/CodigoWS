/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.EmpleadoVO;
import util.Conexion;

/**
 *
 * @author 57305
 */
public class EmpleadoDAO extends Conexion {

    private String id = "", firstName = "", lastName = "", phone = "", isAdmin = "", username = "", password = "";
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet rs;
    private boolean respuesta = false;
    private String sql;

    public EmpleadoDAO(EmpleadoVO empleado) {
        super();
        try {
            conexion = this.obtenerConexion();
            id = empleado.getId();
            firstName = empleado.getFirstName();
            lastName = empleado.getLastName();
            phone = empleado.getPhone();
            isAdmin = empleado.getIsAdmin();
            username = empleado.getUsername();
            password = empleado.getPassword();
        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public EmpleadoDAO() {
    }

    public boolean login() {
        try {
            conexion = this.obtenerConexion();
            sql = "select username,password from employees where username=? and password=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, username);
            puente.setString(2, password);
            rs = puente.executeQuery();
            while (rs.next()) {
                respuesta = true;
            }
        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }
    
    public boolean isAdmin() {
        try {
            respuesta = false;
            conexion = this.obtenerConexion();
            sql = "select isAdmin from employees where username=? and password=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, username);
            puente.setString(2, password);
            rs = puente.executeQuery();
            while (rs.next()) {
                int rol = rs.getInt(1);
                if(rol == 1) {
                    respuesta = true;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }
    

}
