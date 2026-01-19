/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import business.Customers;
import business.Orders;
import business.SetMenus;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import model.Customer;
import model.Order;
import model.SetMenu;
import tool.Acceptable;
import tool.Inputter;

/**
 *
 * @author Bui_Hai_Dang
 */
public class FeastController {

    private Customers customerList;
    private SetMenus menuList;
    private Orders orderList;
    private Inputter inputter;
    private Order order;

    public FeastController() {
        customerList = new Customers();
        menuList = new SetMenus();
        orderList = new Orders();
        inputter = new Inputter();

        customerList.readFromFile();
        menuList.readFromFile();
        orderList.readFromFile();
    }

    public void registerCustomer() {
        String choose;
        do {
            String id = inputter.inputAndLoop("Enter Customer ID: ", Acceptable.CUS_ID_VALID);
            if (customerList.searchById(id) != null) {
                System.out.println("ID already exists!");
            } else {
                String name = inputter.inputAndLoop("Enter Name: ", Acceptable.NAME_VALID);
                String phone = inputter.inputAndLoop("Enter Phone: ", Acceptable.PHONE_VALID);
                String email = inputter.inputAndLoop("Enter Email: ", Acceptable.EMAIL_VALID);
                customerList.addNew(new Customer(id, name, phone, email));
            }
            choose = inputter.getString("choose Y(continue register)or N (exist): ");

        } while (choose.equalsIgnoreCase("Y"));
    }

    public void updateCustomer() {
        String id = inputter.inputAndLoop("Enter Customer ID: ", Acceptable.CUS_ID_VALID);
        Customer newcs = customerList.searchById(id);
        if (newcs == null) {
            System.out.println("This customer does not exist. ");
        } else {
            customerList.update(newcs);
        }
    }

    public void searchByName() {
        String name = inputter.inputAndLoop("Enter the name or partial name: ", Acceptable.NAME_VALID);
        customerList.searchByName(name);
    }

    public void displayFeastMenus() {
        menuList.readFromFile();
        menuList.showMenuList();

    }

    public void placeFeastOrder() {

        double cost = 0.0;
        System.out.println("--- Place a Feast Order ---");
        if (customerList.isEmpty()) {
            System.out.println("Cusomer list is empty, please register");

        } else {
            String cId = inputter.inputAndLoop("Enter Customer ID: ", Acceptable.CUS_ID_VALID);
            if (cId.isEmpty()) {
                System.out.println("Cannot be blank");

            }

            Customer foundCust = customerList.searchById(cId);
            if (foundCust == null) {
                System.out.println("Customer not found!");
            }

            menuList.showMenuList();
            String mId = inputter.getString("Enter Menu ID: ");
            SetMenu foundMenu = menuList.get(mId);
            if (foundMenu == null) {
                System.out.println("Menu not found!");

            } else {
                int tables = inputter.IntAndLoop("Enter number of tables: ", Acceptable.POSITIVE_INT_VALID);
                Date eventDate = inputter.getDate("Enter event date");
                if (eventDate == null) {
                    return;
                }
                cost = foundMenu.getPrice() * tables;
                orderList.addNew(new Order(cId, new Date(), cId, mId, foundMenu.getPrice(), tables, cost));
            }

            System.out.println("-------------------------------------------------------");
            System.out.println("Code            : " + foundCust.getId());
            System.out.println("Customer Name   : " + foundCust.getName());
            System.out.println("Phone Number    : " + foundCust.getPhone());
            System.out.println("Email           : " + foundCust.getEmail());
            System.out.println("-------------------------------------------------------");

            System.out.println("Code of Set Menu: " + foundMenu.getMenuId());
            System.out.println("Set menu name   : " + foundMenu.getMenuName());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Event date      : " + sdf.format(order.getEventDate()));
            System.out.printf("Price            : %,.0f Vnd\n", foundMenu.getPrice());
            System.out.println("Ingredients :");
            String raw = foundMenu.getIngredients().replace("\"", "");
            String[] groups = raw.split("#");
            for (String group : groups) {
                System.out.println(" " + group.trim());
            }
            System.out.println("-------------------------------------------------------");
            System.out.printf("Total cost      : %,.0f Vnd\n", cost);
            System.out.println("-------------------------------------------------------");
        }
    }

    public void UpdateOrderInfor() {
        System.out.println("--- Update Order Information ---");
        String code = inputter.inputAndLoop("Enter ID", Acceptable.CUS_ID_VALID);
        Order foundOrder = orderList.searchById(code);

        if (foundOrder == null) {
            System.out.println("Order Code does not exist!");
            return;
        }

        System.out.println("Current Order Details: " + foundOrder);

        String newCusId = inputter.inputAndLoop("Enter new Customer ID (leave blank to keep old): ", Acceptable.CUS_ID_VALID);
        if (!newCusId.isEmpty()) {
            if (customerList.searchById(newCusId) == null) {
                System.out.println("New Customer ID does not exist! Keeping the old one.");
            } else {
                foundOrder.setCustomerId(newCusId);
            }
        }

        int newTables = inputter.IntAndLoop("Enter new number of tables (0 to keep old): ", Acceptable.POSITIVE_INT_VALID);
        if (newTables > 0) {
            foundOrder.setNumOfTables(newTables);
        }

//        String newDate = inputter.inputAndLoop("Enter new date (must be a valid date in the future)", Acceptable)
        System.out.println("Order updated successfully!");
        System.out.println("Updated Order: " + foundOrder);
        System.out.println("Customer updated successfully.");

    }

    public void displayCustomerOrOrder() {
        int number = inputter.IntAndLoop("Enter 1 to Choose display Customer list, 2 to choose display Order list: ", Acceptable.POSITIVE_INT_VALID);
        switch (number) {
            case 1:
                displayAllCustomers();
                break;
            case 2:
                displayAllOrders();
                break;
            default:
                System.out.println("Invalid data, please redo");
                break;
        }
    }

    /*-----------------------------------------------*/
    public void saveData() {
        customerList.saveToFile();
        orderList.saveToFile();
        System.out.println("All data saved to files successfully.");
    }

    public void displayAllCustomers() {
        System.out.println("\n--- CUSTOMER LIST ---");
        customerList.showAll();
    }

    public void displayAllOrders() {
        System.out.println("\n--- ORDER LIST ---");
        orderList.showAll();
    }
}
