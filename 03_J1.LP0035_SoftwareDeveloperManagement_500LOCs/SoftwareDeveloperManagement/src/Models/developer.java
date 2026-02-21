/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.List;

/**
 *
 * @author Bui_Hai_Dang
 */
public class Developer {
    private String devID;
    private String fullName;
    private List<String> languages;
    private int salaryUsd;

    public Developer() {
    }

    public Developer(String devID, String fullName, List<String> languages, int salaryUsd) {
        this.devID = devID;
        this.fullName = fullName;
        this.languages = languages;
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

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getSalaryUsd() {
        return salaryUsd;
    }

    public void setSalaryUsd(int salaryUsd) {
        this.salaryUsd = salaryUsd;
    }


    @Override
    public String toString() {
        return String.format("| -10%s | -25%s | -20%s | %d |",getDevID(),getFullName(),getLanguages(),getSalaryUsd());
    }
    
}
