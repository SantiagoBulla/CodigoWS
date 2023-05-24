package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.EmployeeVO;
import util.Conexion;
import util.crud;

/**
 *
 * @author 57305
 */
public class EmployeeDAO extends Conexion implements crud {

    //declarar objetos y variables para hacer conexiones y operaciones 
    private Connection conexion;
    //crear puente 
    private PreparedStatement puente;
    //varaible resultset
    private ResultSet rs;
    //variables 
    private boolean operacion = false;
    //variable de sql
    String sql;

    //datos del vo
    private String id = "", firstName = "", lastName = "", phone = "", isAdmin = "", userName = "", password = "";

    //constructor traer datos de vo
    public EmployeeDAO(EmployeeVO employeeVO) {
        super();//llamar metodos como propios 
        try {
            //asiganar datos del DAO con el VO
            conexion = this.obtenerConexion();
            id = employeeVO.getId();
            firstName = employeeVO.getFirstName();
            lastName = employeeVO.getLastName();
            phone = employeeVO.getPhone();
            isAdmin = employeeVO.getIsAdmin();
            userName = employeeVO.getUserName();
            password = employeeVO.getPassword();

        } catch (Exception e) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    //constructor vacio
    public EmployeeDAO() {
    }
    
    

    public boolean validacionCredencial(String usuario, String clave) {
        try {
            //conexion 
            operacion = false;
            conexion = this.obtenerConexion();
            sql = "select isAdmin from employees where  username=? and password=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            puente.setString(2, clave);
            rs = puente.executeQuery();
            while (rs.next()) {
                int isAdminGlobal = rs.getInt(1);
                if (isAdminGlobal == 1) {
                    operacion = true;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                //this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    public boolean inicioSesion(String usuario, String clave) {
        try {
            //conexion 
            conexion = this.obtenerConexion();
            sql = "select username, password from employees where username=? and password=?;";
            //preparar consulta 
            puente = conexion.prepareStatement(sql);
            //pasar datos con el puente 
            puente.setString(1, usuario);
            puente.setString(2, clave);
            this.rs = puente.executeQuery();
            if (rs.next()) {
                operacion = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                //this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    public ArrayList<EmployeeVO> mostrarEmployees() {
        ArrayList<EmployeeVO> listaEmployees = new ArrayList<>();
        try{
            conexion = this.obtenerConexion();
            sql = "select * from employees;";
            puente = conexion.prepareStatement(sql);
            rs = puente.executeQuery();
            while (rs.next()) {
                EmployeeVO employees = new EmployeeVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                listaEmployees.add(employees);
            }
        }catch (Exception e) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaEmployees;
    }
    
    

    @Override
    public boolean crearRegistro() {
        try {
            conexion = this.obtenerConexion();
            //consulta 
            sql = "insert into employees(firstName,lastName,phone,isAdmin,userName,password) values (?,?,?,?,?,?)";
            //pasar datos con el puente 
            puente.setString(1, firstName);
            puente.setString(2, lastName);
            puente.setString(3, phone);
            puente.setString(4, isAdmin);
            puente.setString(5, userName);
            puente.setString(6, password);
            puente.executeUpdate();//ejecuta la consulta
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inhabilitarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
