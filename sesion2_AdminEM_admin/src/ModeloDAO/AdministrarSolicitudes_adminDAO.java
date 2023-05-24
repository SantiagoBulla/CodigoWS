/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import util.Conexion;
import ModeloVO.AdministrarSolicitudes_adminVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author 57305
 */
public class AdministrarSolicitudes_adminDAO extends Conexion {

    private String assetSN = "", assetName = "", reportDate = "", fullNameEmployee = "", department = "";
    //variables de conexion y operaciones 
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet rs;
    private boolean operacion = false;
    private String sql;

    public AdministrarSolicitudes_adminDAO(AdministrarSolicitudes_adminVO adminVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            assetSN = adminVO.getAssetSN();
            assetName = adminVO.getAssetName();
            reportDate = adminVO.getReportDate();
            fullNameEmployee = adminVO.getFullNameEmployee();
            department = adminVO.getDepartment();
        } catch (Exception e) {
            Logger.getLogger(AdministrarSolicitudes_adminDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public AdministrarSolicitudes_adminDAO() {
    }

    public ArrayList<AdministrarSolicitudes_adminVO> mostrarDatosSinFiltro() {
        ArrayList<AdministrarSolicitudes_adminVO> listaSinFiltro = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select a.assetSN,a.assetName,em.EMReportDate, concat(e.firstName,' ',e.lastName) as fullNameEmployee, d.name as departmentsName from assets a join emergencyMaintenances em on a.ID = em.ID join employees e on a.ID = e.ID join departments d on a.ID = d.ID;";
            puente = conexion.prepareStatement(sql);
            rs = puente.executeQuery();
            //creamos el VO 
            while (rs.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = sdf.format(rs.getDate(3));
                AdministrarSolicitudes_adminVO asVO = new AdministrarSolicitudes_adminVO(rs.getNString(1), rs.getNString(2), dateString, rs.getNString(4), rs.getNString(5));
                listaSinFiltro.add(asVO);
            }
        } catch (Exception e) {
            Logger.getLogger(AdministrarSolicitudes_adminDAO.class.getName()).log(Level.SEVERE, null, e);

        }
        return listaSinFiltro;
    }

    public ArrayList<AdministrarSolicitudes_adminVO> mostrarDatosConFiltro(){
        ArrayList<AdministrarSolicitudes_adminVO> listaConFiltro = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql="select a.assetSN,a.assetName,em.EMReportDate, concat(e.firstName,' ',e.lastName) as fullNameEmployee, d.name as departmentsName from assets a join emergencyMaintenances em on a.ID = em.ID join employees e on a.ID = e.ID join departments d on a.ID = d.ID join priorities p on em.ID = p.ID where em.EMEndDate is null order by p.Name DESC, em.EMStartDate ASC;";
            puente = conexion.prepareStatement(sql);
            rs = puente.executeQuery();
            //creamos el VO 
            while (rs.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = sdf.format(rs.getDate(3));
                AdministrarSolicitudes_adminVO asVO = new AdministrarSolicitudes_adminVO(rs.getNString(1), rs.getNString(2), dateString, rs.getNString(4), rs.getNString(5));
                listaConFiltro.add(asVO);
            }
        } catch (Exception e) {
        }
        return listaConFiltro;
    }
    
    public ArrayList<String> tenerDatos(){
        ArrayList<String> guardarDatos = new ArrayList<>();
        try {
            guardarDatos.add(this.assetSN);
            guardarDatos.add(this.assetName);
            guardarDatos.add(this.reportDate);
            guardarDatos.add(this.fullNameEmployee);
            guardarDatos.add(this.department);
            
        } catch (Exception e) {
        }
        return guardarDatos;
    }

}
