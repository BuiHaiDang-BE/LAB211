/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Bui_Hai_Dang
 */
public class developer {
    private String devID;
    private String fullName;
    private String programLanguages;
    private int salaryUsd;

    public developer() {
    }

    public developer(String devID, String fullName, String programLanguages, int salaryUsd) {
        this.devID = devID;
        this.fullName = fullName;
        this.programLanguages = programLanguages;
        this.salaryUsd = salaryUsd;
    }

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProgramLanguages() {
        return programLanguages;
    }

    public void setProgramLanguages(String programLanguages) {
        this.programLanguages = programLanguages;
    }

    public double getSalaryUsd() {
        return salaryUsd;
    }

    public void setSalaryUsd(int salaryUsd) {
        this.salaryUsd = salaryUsd;
    }
    
   

    @Override
    public String toString() {
        return String.format("| -10%s | -25%s | -20%s | %d |",getDevID(),getFullName(),getProgramLanguages(),getSalaryUsd());
    }
    
}
