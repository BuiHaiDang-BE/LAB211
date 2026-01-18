/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Bui_Hai_Dang
 */
import controller.FeastController;
import java.util.Date;
import model.Order;
import tool.Acceptable;

public class Main {

    public static void main(String[] args) {

        FeastController fcontrol = new FeastController();

        Menu mainMenu = new Menu();
        mainMenu.addMenuItem("Register a new customer");
        mainMenu.addMenuItem("Update customer information");
        mainMenu.addMenuItem("Search for customer information by name");
        mainMenu.addMenuItem("Display feast menus");
        mainMenu.addMenuItem("Place a feast order");
        mainMenu.addMenuItem("Update order information");
        mainMenu.addMenuItem("Save data to file");
        mainMenu.addMenuItem("Display lists (Customers or Orders)");

        int choice;
        do {
            choice = mainMenu.getUserChoice();
            switch (choice) {
                case 1:
                    fcontrol.registerCustomer();
                    break;
                case 2:
                    fcontrol.updateCustomer();
                    break;

                case 3:
                    fcontrol.searchByName();
                    break;
                case 4:
                    fcontrol.displayFeastMenus();
                    break;

                case 5:
                    fcontrol.placeFeastOrder();
                    break;
                case 6:
                    
                    break;
                case 7:
                    fcontrol.saveData();
                    break;

                case 8:
                    fcontrol.displayCustomerOrOrder();
                    break;
                
            }
        } while (choice != 0);
    }
}
