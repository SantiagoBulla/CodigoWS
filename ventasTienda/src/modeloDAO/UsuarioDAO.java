/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.UsuarioVO;
import util.Conexion;

/**
 *
 * @author 57305
 */
public class UsuarioDAO extends Conexion {

    //variables de manejo y conexion
    private String documento = "", nombre = "", usuario = "", clave = "", rol = "";
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet rs;
    private boolean respuesta = false;
    private String sql;

    public UsuarioDAO(UsuarioVO usuVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            this.documento = usuVO.getDocumento();
            this.nombre = usuVO.getNombre();
            this.usuario = usuVO.getUsuario();
            this.clave = usuVO.getClave();
            this.rol = usuVO.getRol();
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    public UsuarioDAO() {
    }

    public boolean iniciarSesion() {
        try {
            conexion = this.obtenerConexion();
            sql = "select usuario, clave from usuarios where usuario=? and clave=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, this.usuario);
            puente.setString(2, this.clave);
            rs = puente.executeQuery();
            while (rs.next()) {
                respuesta = true;
            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    public boolean validarRol() {
        try {
            conexion = this.obtenerConexion();
            sql = "select rol from usuarios where usuario=? and clave=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, this.usuario);
            puente.setString(2, this.clave);
            rs = puente.executeQuery();
            while (rs.next()) {
                String rol = String.valueOf(rs.getString(1));
                if (rol.equalsIgnoreCase("admin")) {
                    respuesta = true;
                } else {
                    respuesta = false;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        }
        return respuesta;
    }

    public ArrayList<UsuarioVO> enlistarUsuarios() {
        ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuarios;";
            puente = conexion.prepareStatement(sql);
            rs = puente.executeQuery();
            while (rs.next()) {
                //crear VO
                UsuarioVO usuVO = new UsuarioVO(rs.getNString(1), rs.getNString(2), rs.getNString(3), rs.getNString(4), rs.getNString(5));
                listaUsuarios.add(usuVO);
            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaUsuarios;
    }

    public boolean modificarUsuario() {
        try {
            conexion = this.obtenerConexion();
            sql = "update usuarios set documento=?,nombre=?,usuario=?,clave=?,rol=? where documento=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, this.documento);
            puente.setString(2, this.nombre);
            puente.setString(3, this.usuario);
            puente.setString(4, this.clave);
            puente.setString(5, this.rol);
            puente.setString(6, this.documento);
            puente.executeUpdate();
            respuesta = true;
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    public boolean eliminarUsuario(String documentoUsu) {
        try {
            conexion = this.obtenerConexion();
            sql = "delete from usuarios where documento=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, documentoUsu);
            puente.executeUpdate();
            respuesta = true;
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    public boolean ingresarUsuario() {
        try {
            conexion = this.obtenerConexion();
            sql = " insert into usuarios values (?,?,?,?,?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, this.documento);
            puente.setString(2, this.nombre);
            puente.setString(3, this.usuario);
            puente.setString(4, this.clave);
            puente.setString(5, this.rol);
            puente.executeUpdate();
            respuesta = true;
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }
    
    public ArrayList<String> datosUsuario(String datoUsuario){
        ArrayList<String> datosUsu = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from usuarios where usuario=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, datoUsuario);
            rs = puente.executeQuery();
            while(rs.next()){
                for (int i = 0; i < 5; i++) {
                    datosUsu.add(String.valueOf(rs.getString(i)));
                }
            }
        } catch (Exception e) {
        }
        return datosUsu;
    }
}
