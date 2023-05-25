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
public class AdmSolicitudes_adminVO {
    private String assetSN, assetName, requestDate, fullNameEmployee, department;

    public AdmSolicitudes_adminVO(String assetSN, String assetName, String requestDate, String fullNameEmployee, String department) {
        this.assetSN = assetSN;
        this.assetName = assetName;
        this.requestDate = requestDate;
        this.fullNameEmployee = fullNameEmployee;
        this.department = department;
    }

    public AdmSolicitudes_adminVO() {
    }

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

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
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
