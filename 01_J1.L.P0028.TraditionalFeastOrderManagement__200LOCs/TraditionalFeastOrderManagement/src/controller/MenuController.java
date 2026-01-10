/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.SetMenu;
import java.util.Scanner;
import view.displayView;

/**
 *
 * @author Bui_Hai_Dang
 */
public class MenuController {

    List<SetMenu> menu = new ArrayList<>();

    public List<SetMenu> getMenuList() {
        return this.menu;
    }

    public void displayMenus() {
        displayView v = new displayView();
        File f = new File("FeastMenu.csv");
        if (!f.exists()) {
            System.out.println("Cannot read data from feastMenu.csv. Please check it.");
            return;
        }
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                if (data.length >= 4) {
                    try {
                        String id = data[0].trim();
                        String name = data[1].trim();
                        double price = Double.parseDouble(data[2].trim());
                        String ingredients = data[3].trim();
                        menu.add(new SetMenu(id, name, price, ingredients));
                    } catch (NumberFormatException e) {
                    }
                }
            }
            Collections.sort(menu, (m1, m2) -> Double.compare(m1.getPrice(), m2.getPrice()));
            v.displayMenu(menu);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading feastMenu.csv!");
        }
    }
}
