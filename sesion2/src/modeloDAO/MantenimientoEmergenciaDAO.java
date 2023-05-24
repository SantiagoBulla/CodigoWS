/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.MantenimientosEmergenciaVO;
import util.Conexion;
import java.util.*;


/**
 *
 * @author 57305
 */
public class MantenimientoEmergenciaDAO extends Conexion {

    //variables de conexion
    private String AssetSN = "", AssetName = "", EMReportDate = "", EmployeeFullaName = "", DepartmentName = "";

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet rs;
    private boolean repuesta = false;
    private String sql;

    //constructor que tiene valores 
    public MantenimientoEmergenciaDAO(MantenimientosEmergenciaVO emVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            AssetSN = emVO.getAssetSN();
            AssetName = emVO.getAssetName();
            EMReportDate = emVO.getEMReportDate();
            EmployeeFullaName = emVO.getEmployeeFullaName();
            DepartmentName = emVO.getDepartmentName();
        } catch (Exception e) {
            Logger.getLogger(MantenimientoEmergenciaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //constructor que no tiene datos 
    public MantenimientoEmergenciaDAO() {
    }

    public ArrayList<MantenimientosEmergenciaVO> mostrarEM() {
        ArrayList<MantenimientosEmergenciaVO> listaDatos = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql="select a.AssetSN, a.AssetName, r.EMReportDate, CONCAT( e.FirstName,' ', e.LastName) as Employee_FullName, d.Name as Departments_Name from Assets a JOIN emergencymaintenances r on a.ID = r.ID JOIN employees e on r.ID = e.ID JOIN locations d on r.ID = d.ID;";
            puente = conexion.prepareStatement(sql);
            rs = puente.executeQuery();
            while(rs.next()){
                //crear VO 
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = sdf.format(rs.getDate(3));
                MantenimientosEmergenciaVO emVO = new MantenimientosEmergenciaVO(rs.getNString(1),rs.getNString(2),dateString,rs.getNString(4), rs.getNString(5));
                listaDatos.add(emVO);
            }

        } catch (Exception e) {
            Logger.getLogger(MantenimientoEmergenciaDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return listaDatos;
    }
    
    public ArrayList<MantenimientosEmergenciaVO> mostrarEMFiltro() {
        ArrayList<MantenimientosEmergenciaVO> listaDatosFiltro = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql="select a.AssetName, a.AssetSN, r.EMReportDate, CONCAT( e.FirstName, ' ', e.LastName) as Employee_FullName, d.Name as Departments_Name from Assets a JOIN emergencymaintenances r on a.ID = r.ID JOIN employees e on r.ID = e.ID JOIN locations d on r.ID = d.ID JOIN priorities p on r.ID = p.ID WHERE EMEndDate is null ORDER BY p.Name DESC, EMReportDate ASC;";
            puente = conexion.prepareStatement(sql);
            rs = puente.executeQuery();
            while(rs.next()){
                //crear VO 
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = sdf.format(rs.getDate(3));
                MantenimientosEmergenciaVO emVO = new MantenimientosEmergenciaVO(rs.getNString(1),rs.getNString(2),dateString,rs.getNString(4), rs.getNString(5));
                listaDatosFiltro.add(emVO);
            }
        } catch (Exception e) {
            Logger.getLogger(MantenimientoEmergenciaDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return listaDatosFiltro;
    }

}
