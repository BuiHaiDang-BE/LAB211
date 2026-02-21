/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bussiness;

import Models.Developer;
import Tools.Acceptable;
import Tools.Inputter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bui_Hai_Dang
 */
public class Developers extends HashMap<String, Developer> implements Workable {

    private final String pathfile = "developer.txt";
    Inputter inputter = new Inputter();

    @Override
    public void addNew(Object x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    @Override
    public Developer searchById(String id) {
        if(this.containsKey(id)){
            System.out.println("Developer is exist");
            return this.get(id);
        }
        System.out.println("Developer not found");
        return null;
    }

    @Override
    public void showAll() {
        if (this.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("\"| -10%s | -25%s | -20%s | %d |\n", "ID", "Name", "Languages", "Salary");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (Developer dev : this.values()) {
            System.out.println(dev);
        }
        System.out.println("-------------------------------------------------------------------------------------------");

    }

    public void saveFile() {
       try (PrintWriter writer = new PrintWriter(new FileWriter(pathfile))) {
        for (Developer dev : this.values()) {
            
            String langs = dev.getLanguages().toString(); 
            
            writer.printf("%s, %s, %s, %d\n", 
                          dev.getDevID(), 
                          dev.getFullName(), 
                          langs, 
                          dev.getSalaryUsd());
        }
           System.out.println("Saving list developers successfully");

        } catch (Exception e) {
            System.out.println("Error while saving file developer: " + e.getMessage());
        }

    }

    public void readFine() {
        this.clear();
        try ( Scanner fileScanner = new Scanner(pathfile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();

                String[] parts = line.split(",\\s*(?![^\\[]*\\])");

                if (parts.length == 4) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String langStr = parts[2].trim();
                    int salary = Integer.parseInt(parts[3].trim());

                    if (Acceptable.isValid(id, Acceptable.ID_VALID) && salary >= 1000) {

                        langStr = langStr.substring(1, langStr.length() - 1);
                        List<String> langs = new ArrayList<>();
                        if (!langStr.isEmpty()) {
                            for (String s : langStr.split(",")) {
                                langs.add(s.trim());
                            }
                        }
                        this.put(id, new Developer(id, name, langs, salary));
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Error when read file developer: " + e.getMessage());
        }
    }

}
