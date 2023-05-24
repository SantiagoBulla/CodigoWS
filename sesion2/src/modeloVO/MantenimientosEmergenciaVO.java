/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

/**
 *
 * @author 57305
 */
public class MantenimientosEmergenciaVO {
    //Datos del VO 
    private String AssetSN, AssetName, EMReportDate, EmployeeFullaName, DepartmentName;
    
    //constructor que no recibe datos 

    public MantenimientosEmergenciaVO() {
    }

    public MantenimientosEmergenciaVO(String AssetSN, String AssetName, String EMReportDate, String EmployeeFullaName, String DepartmentName) {
        this.AssetSN = AssetSN;
        this.AssetName = AssetName;
        this.EMReportDate = EMReportDate;
        this.EmployeeFullaName = EmployeeFullaName;
        this.DepartmentName = DepartmentName;
    }
    
    //getters & setters

    public String getAssetSN() {
        return AssetSN;
    }

    public void setAssetSN(String AssetSN) {
        this.AssetSN = AssetSN;
    }

    public String getAssetName() {
        return AssetName;
    }

    public void setAssetName(String AssetName) {
        this.AssetName = AssetName;
    }

    public String getEMReportDate() {
        return EMReportDate;
    }

    public void setEMReportDate(String EMReportDate) {
        this.EMReportDate = EMReportDate;
    }

    public String getEmployeeFullaName() {
        return EmployeeFullaName;
    }

    public void setEmployeeFullaName(String EmployeeFullaName) {
        this.EmployeeFullaName = EmployeeFullaName;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentDate) {
        this.DepartmentName = DepartmentName;
    }
    
        
}
