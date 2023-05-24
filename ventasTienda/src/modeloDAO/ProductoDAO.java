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
import util.Conexion;
import modeloVO.ProductoVO;

/**
 *
 * @author 57305
 */
public class ProductoDAO extends Conexion {

    //variables de VO y conexion
    private String codigo, nombre, disponibilidad, valorUnitario;
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet rs;
    private boolean respuesta = false;
    private String sql;

    public ProductoDAO(ProductoVO producto) {
        super();
        try {
            conexion = this.obtenerConexion();
            this.codigo = producto.getCodigo();
            this.nombre = producto.getNombre();
            this.disponibilidad = producto.getDisponibilidad();
            this.valorUnitario = producto.getValorUnitario();
        } catch (Exception e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public boolean ingresarProducto() {
        try {
            conexion = this.obtenerConexion();
            sql = "insert into productos (nombreproducto,disponibilidad,valorunitario) values (?,?,?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nombre);
            int cantidad = Integer.valueOf(disponibilidad);
            puente.setInt(2, cantidad);
            int unitario = Integer.valueOf(valorUnitario);
            puente.setInt(3, unitario);
            puente.executeUpdate();
            respuesta = true;
        } catch (Exception e) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

}
