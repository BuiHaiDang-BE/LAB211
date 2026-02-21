/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author Bui_Hai_Dang
 */
public class Project {
    private String projectID; 
    private String devID; 
    private String projectName; 
    private int duration; 
    private Date startDate; 

    public Project() {
    }

    public Project(String projectID, String devID, String projectName, int duration, Date startDate) {
        this.projectID = projectID;
        this.devID = devID;
        this.projectName = projectName;
        this.duration = duration;
        this.startDate = startDate;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    @Override
    public String toString() {
        return String.format("| -10%s | -25%s | -20%s | %d | -10%s |",getProjectID(),getDevID(),getProjectName(),getDuration(),getStartDate());
    }
}
