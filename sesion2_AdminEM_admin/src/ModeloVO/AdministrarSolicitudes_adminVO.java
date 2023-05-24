/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author 57305
 */
public class AdministrarSolicitudes_adminVO {
    private String assetSN,assetName,reportDate,fullNameEmployee, department;

    public AdministrarSolicitudes_adminVO() {
    }

    public AdministrarSolicitudes_adminVO(String assetSN, String assetName, String reportDate, String fullNameEmployee, String department) {
        this.assetSN = assetSN;
        this.assetName = assetName;
        this.reportDate = reportDate;
        this.fullNameEmployee = fullNameEmployee;
        this.department = department;
    }
    
    
    //getters and setters 

    public String getAssetSN() {
        return assetSN;
    }

    public void setAssetSN(String assetSN) {
        this.assetSN = assetSN;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getFullNameEmployee() {
        return fullNameEmployee;
    }

    public void setFullNameEmployee(String fullNameEmployee) {
        this.fullNameEmployee = fullNameEmployee;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    
    
}
