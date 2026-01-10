/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.SetMenu;

/**
 *
 * @author Bui_Hai_Dang
 */
public class displayView {

    public void displayList(ArrayList<Customer> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("No one matches the search criteria!");

            return;
        }

        System.out.println("Matching Customers:");

        System.out.println("----------------------------------------------------------------------");
        System.out.printf("| %-10s | %-25s | %-15s | %-25s |\n", "Code", "Customer Name", "Phone", "Email");

        System.out.println("----------------------------------------------------------------------");

        for (Customer c : list) {
            System.out.printf("| %-10s | %-25s | %-15s | %-25s |\n",
                    c.getCustomerCode(), c.getName(), c.getPhoneNumber(), c.getEmail());

        }
        System.out.println("----------------------------------------------------------------------");
    }
    
   public void displayMenu(List<SetMenu> menu) {
    System.out.println("List of Set Menus for ordering party:");
    for (SetMenu m : menu) {
        System.out.println("-------------------------------------------------------");
        System.out.println("Code        : " + m.getMenuId());
        System.out.println("Name        : " + m.getMenuName());
        System.out.printf("Price       : %,.0f Vnd\n", m.getPrice());
        System.out.println("Ingredients :");
        String raw = m.getIngredients().replace("\"", "");
        String [] groups = raw.split("#");
        
        for (String group : groups) {
            System.out.println("+ " + group.trim());
        }
    }
    System.out.println("-------------------------------------------------------");
}
    
    
}
