    package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.EmpleadoVO;
import util.Conexion;

/**
 *
 * @author 57305
 */
public class EmpleadoDAO extends Conexion {

    private String id = "", firstName = "", lastName = "", phone = "", isAdmin = "", userName = "", password = "";
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet rs;
    private boolean respuesta = false;
    private String sql;

    //CONSTRUCTOR QUE ASIGNA VALORES DEL VO
    public EmpleadoDAO(EmpleadoVO empleado) {
        super();
        try {
            conexion = this.obtenerConexion();
            id = empleado.getId();
            firstName = empleado.getFirstName();
            lastName = empleado.getLastName();
            phone = empleado.getPhone();
            isAdmin = empleado.getIsAdmin();
            userName = empleado.getUserName();
            password = empleado.getPassword();
        } catch (Exception e) {
            System.out.println("Error de incio constructor " + e);
        }
    }

    public EmpleadoDAO() {
    }

    public boolean inicioSesion() {
        try {
            conexion = this.obtenerConexion();
            sql = "select username,password from employees where username=? and password=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, this.userName);
            puente.setString(2, this.password);
            rs = puente.executeQuery();
            while (rs.next()) {
                respuesta = true;
            }
        } catch (Exception e) {
            System.out.println("Error de inicio de sesion " + e);
        }
        return respuesta;
    }

    public boolean validarCredencial() {
        try {
            respuesta = false;
            conexion = this.obtenerConexion();
            sql = "select isAdmin from employees where username=? and password=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, this.userName);
            puente.setString(2, this.password);
            rs = puente.executeQuery();
            while (rs.next()) {
                int isAdminGlobal = rs.getInt(1);
                if (isAdminGlobal == 1) {
                    respuesta = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error de validacion de credenciales " + e);
        }
        return respuesta;
    }

    public ArrayList<EmpleadoVO> mostrarEmpleados() {
        //crear un array 
        ArrayList<EmpleadoVO> listaEmpleados = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from employees;";
            puente = conexion.prepareStatement(sql);
            rs = puente.executeQuery();
            while (rs.next()) {
                //crear un VO 
                EmpleadoVO empleadoVO = new EmpleadoVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                listaEmpleados.add(empleadoVO);
            }
        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaEmpleados;
    }

    public boolean agregarEmpleado() {
        conexion = this.obtenerConexion();
        int isAdminInt;
        try {
            sql = "insert into employees (firstname, lastname, phone, isadmin, username, password) values(?,?,?,?,?,?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, this.firstName);
            puente.setString(2, this.lastName);
            puente.setString(3, this.phone);
            isAdminInt = Integer.parseInt(this.isAdmin);
            puente.setInt(4, isAdminInt);
            puente.setString(5, this.userName);
            puente.setString(6, this.password);
            puente.executeUpdate();
            respuesta = true;
        } catch (Exception e) {
            System.out.println("Error al ingresar empleado" + e);
        }
        return respuesta;
    }

    public boolean modificarEmpleado() {
        conexion = this.obtenerConexion();
        int isAdminInt, idEmpleado;
        try {
            sql = "update employees set firstName=?, lastName=?,phone=?,isAdmin=?,userName=?,password=? where id=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, this.firstName);
            puente.setString(2, this.lastName);
            puente.setString(3, this.phone);
            isAdminInt = Integer.parseInt(this.isAdmin);
            puente.setInt(4, isAdminInt);
            puente.setString(5, this.userName);
            puente.setString(6, this.password);
            idEmpleado = Integer.parseInt(this.id);
            puente.setInt(7, idEmpleado);
            puente.executeUpdate();
            respuesta = true;
        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return respuesta;
    }

}
