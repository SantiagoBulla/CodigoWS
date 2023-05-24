/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.PartesVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Conexion;

/**
 *
 * @author 57305
 */
public class PartesDAO extends Conexion {

    private String id = "", name = "", effectiveLife = "";
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet rs;
    private boolean respuesta = false;
    private String sql;

    public PartesDAO(PartesVO partes) {
        super();
        try {
            conexion = this.obtenerConexion();
            this.id = partes.getId();
            this.name = partes.getName();
            this.effectiveLife = partes.getEffectiveLife();
        } catch (Exception e) {
            Logger.getLogger(PartesDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public PartesDAO() {
    }

    public ArrayList<PartesVO> traerPartes() {
        ArrayList<PartesVO> listaPartes = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from parts";
            puente = conexion.prepareStatement(sql);
            rs = puente.executeQuery();
            while (rs.next()) {
                //creamos vo
                PartesVO partes = new PartesVO(rs.getString(1), rs.getString(2), rs.getString(3));
                listaPartes.add(partes);
            }
        } catch (Exception e) {
            Logger.getLogger(PartesDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaPartes;
    }

}
