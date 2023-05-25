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
import modeloVO.AdmSolicitudes_adminVO;
import util.Conexion;

/**
 *
 * @author 57305
 */
public class AdmSolicitudes_adminDAO extends Conexion {

    private String assetSN, assetName, requestDate, fullNameEmployee, department;
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet rs;
    private boolean respuesta = false;
    private String sql;

    public AdmSolicitudes_adminDAO(AdmSolicitudes_adminVO solicitudes) {
        super();
        try {
            conexion = this.obtenerConexion();
            assetSN = solicitudes.getAssetSN();
            assetName = solicitudes.getAssetName();
            requestDate = solicitudes.getRequestDate();
            fullNameEmployee = solicitudes.getFullNameEmployee();
            department = solicitudes.getDepartment();
        } catch (Exception e) {
            Logger.getLogger(AdmSolicitudes_adminDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public AdmSolicitudes_adminDAO() {
    }

    public ArrayList<AdmSolicitudes_adminVO> showEM_admin() {
        ArrayList<AdmSolicitudes_adminVO> list = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select a.AssetSN,a.AssetName,em.EMStartDate,concat(e.FirstName,\" \",e.LastName) as fullname, d.Name from assets a JOIN emergencymaintenances em on a.ID = em.ID JOIN employees e on a.ID = e.ID join departments d on a.ID = d.ID;";
            puente = conexion.prepareStatement(sql);
            rs = puente.executeQuery();
            while (rs.next()) {
                //crear vo 
                AdmSolicitudes_adminVO solicitudes = new AdmSolicitudes_adminVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(solicitudes);
            }
        } catch (Exception e) {
            Logger.getLogger(AdmSolicitudes_adminDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    
    public ArrayList<AdmSolicitudes_adminVO> showEM_open_admin() {
        ArrayList<AdmSolicitudes_adminVO> list = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select a.AssetSN,a.AssetName,em.EMStartDate,concat(e.FirstName,\" \",e.LastName) as fullname, d.Name, p.name from assets a JOIN emergencymaintenances em on a.ID = em.ID JOIN employees e on a.ID = e.ID join departments d on a.ID = d.ID JOIN priorities p on em.ID = p.ID where em.EMEndDate is null ORDER BY p.Name DESC, em.EMStartDate DESC;";
            puente = conexion.prepareStatement(sql);
            rs = puente.executeQuery();
            while (rs.next()) {
                //crear vo 
                AdmSolicitudes_adminVO solicitudes = new AdmSolicitudes_adminVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(solicitudes);
            }
        } catch (Exception e) {
            Logger.getLogger(AdmSolicitudes_adminDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

}
