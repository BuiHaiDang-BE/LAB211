/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Bui_Hai_Dang
 */

import java.util.ArrayList;
import tool.Inputter;
import tool.Acceptable;

public class Menu extends ArrayList<String> {
    public Menu() {
        super();
    }

    public void addMenuItem(String item) {
        this.add(item);
    }

    public int getUserChoice() {
        System.out.println("\n===== TRADITIONAL FEAST ORDER MANAGEMENT =====");
        for (int i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + ". " + this.get(i));
        }
        System.out.println("0. Exit");
        Inputter inputter = new Inputter();
        return inputter.IntAndLoop("Select your option: ",Acceptable.CHOICE_VALID);
    }
}
