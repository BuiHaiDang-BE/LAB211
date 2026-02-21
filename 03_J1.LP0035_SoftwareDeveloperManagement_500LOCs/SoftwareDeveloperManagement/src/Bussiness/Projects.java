/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bussiness;

import Models.Project;
import Tools.Acceptable;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bui_Hai_Dang
 */
public class Projects extends HashMap<String, List<Project>> implements Workable<Project> {

    private final String pathfile = "projects.txt";

    @Override
    public void addHew(Project x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Project x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Project searchById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void showAll() {
        if (this.values().isEmpty()) {
            System.out.println("Project is empty");
        }
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("| -10%s | -25%s | -20%s | %d |", "projectID", "devID", "projectName", "durationMonths", "startDate");
        for (List<Project> pro : this.values()) {
            System.out.println(pro);
        }
        System.out.println("--------------------------------------------------------------------");
    }

    public void readFile() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try ( Scanner sc = new Scanner(new File(pathfile))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",\\s*");
                if (parts.length == 5) {
                    String pId = parts[0].trim();
                    String dId = parts[1].trim();
                    String pName = parts[2].trim();
                    int duration = Integer.parseInt(parts[3].trim());
                    Date startDate = sdf.parse(parts[4].trim());

                    if (Acceptable.isValid(dId, Acceptable.CUS_ID_VALID) && duration >= 1) {
                        List<Project> list =  this.get(dId);
                        if (list == null) {

                            this.put(dId, list);
                        }
                        list.add(new Project(pId, dId, pName, duration, startDate));
                    }
                }

            }
        } catch (Exception e) {
        }
    }

    public void saveFile() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try ( PrintWriter pw = new PrintWriter(new File(pathfile))) {
            for (String did : this.keySet()) {
                List<Project> list = this.get(did);
                for (Project p : list) {
                    String line = did + "|" + p.getProjectID() + "," + p.getProjectName() + "," + p.getDuration() + "," + sdf.format(p.getStartDate());
                    pw.println(line);
                }
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
