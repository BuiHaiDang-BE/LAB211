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
    private SetMenu menu;
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
        String choose="";
        do {
            
            String id = inputter.inputAndLoop("Enter Customer ID: ", Acceptable.CUS_ID_VALID);
            if (customerList.searchById(id) != null) {
                System.out.println("ID already exists!");
                continue; 
            }

            String name = inputter.inputAndLoop("Enter Name: ", Acceptable.NAME_VALID);

            String phone;
            while (true) {
                phone = inputter.inputAndLoop("Enter Phone: ", Acceptable.PHONE_VALID);
                if (customerList.searchByPhone(phone) != null) {
                    System.out.println("This phone number is already registered!");
                } else {
                    break; 
                }
            }

            String email;
            while (true) {
                email = inputter.inputAndLoop("Enter Email: ", Acceptable.EMAIL_VALID);
                if (customerList.searchByEmail(email) != null) {
                    System.out.println("This email is already registered!");
                } else {
                    break; 
                }
            }

            customerList.addNew(new Customer(id, name, phone, email));

            choose = inputter.getString("Choose Y (continue registering) or N (exit): ");

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

        System.out.println("--- Place a Feast Order ---");
        if (customerList.isEmpty()) {
            System.out.println("Cusomer list is empty, please register");
            return;
        }

        String cId = inputter.inputAndLoop("Enter Customer ID: ", Acceptable.CUS_ID_VALID);
        if (cId.isEmpty()) {
            System.out.println("Cannot be blank");
            return;
        }

        Customer foundCust = customerList.searchById(cId);
        if (foundCust == null) {
            System.out.println("Customer not found!");
            return;
        }

        menuList.showMenuList();
        String mId = inputter.getString("Enter Menu ID: ");
        SetMenu foundMenu = menuList.get(mId);
        double price = foundMenu.getPrice();
        if (foundMenu == null) {
            System.out.println("Menu not found!");
            return;
        }
        int tables = inputter.IntAndLoop("Enter number of tables: ", Acceptable.POSITIVE_INT_VALID);
        double total = price * tables;
        Date eventDate = inputter.getDate("Enter event date");
        if (eventDate == null) {
            System.out.println("Event date is required!");
            return;
        }
        {
            Order newOrder = new Order(cId, mId, tables, eventDate, price, total);
            orderList.addNew(newOrder);

            System.out.println("-------------------------------------------------------");
            System.out.println("Customer order information [Order ID: ]" + newOrder.getOrderCode());
            System.out.println("-------------------------------------------------------");
            System.out.println("Code            : " + foundCust.getId());
            System.out.println("Customer Name   : " + foundCust.getName());
            System.out.println("Phone Number    : " + foundCust.getPhone());
            System.out.println("Email           : " + foundCust.getEmail());
            System.out.println("-------------------------------------------------------");

            System.out.println("Code of Set Menu: " + foundMenu.getMenuId());
            System.out.println("Set menu name   : " + foundMenu.getMenuName());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Event date      : " + sdf.format(newOrder.getEventDate()));
            System.out.printf("Price : %,.0f Vnd\n", foundMenu.getPrice());
            System.out.println("Ingredients :");
            String raw = foundMenu.getIngredients().replace("\"", "");
            String[] groups = raw.split("#");
            for (String group : groups) {
                System.out.println(" " + group.trim());
            }
            System.out.println("-------------------------------------------------------");
            System.out.printf("Total cost      : %,.0f Vnd\n", newOrder.getTotalCost());
            System.out.println("-------------------------------------------------------");
        }
    }

    public void UpdateOrderInfor() {
        String choice;
        do {
            System.out.println("--- Update Order Information ---");
            if (orderList.isEmpty()) {
                System.out.println("No orders available to update.");
                return;
            }

            System.out.println("Existing Orders:");
            orderList.showAll();

            String code = inputter.getString("Enter the Order Code from the list above: ");
            Order foundOrder = orderList.searchById(code);

            if (foundOrder == null) {
                System.out.println("Order Code does not exist!");
                return;
            }

            System.out.println("Current Order Details: " + foundOrder);
            String newCodemenu = inputter.getString("Enter new code of set menu (leave blank to keep old): ");
            if (!newCodemenu.isEmpty()) {
                SetMenu newMenuId = menuList.get(newCodemenu);
                if (newMenuId == null) {
                    System.out.println("Menu id not found!");
                } else {

                    foundOrder.setMenuId(newCodemenu);
                    double newPrice = newMenuId.getPrice();

                    foundOrder.setPrice(newPrice);

                    System.out.println("Menu updated successfully!");
                }
            }
            int newTables = inputter.IntAndLoop("Enter new number of tables (0 to keep old): ", Acceptable.POSITIVE_INT_VALID);
            if (newTables > 0) {
                foundOrder.setNumOfTables(newTables);
            }
            double newTotal = foundOrder.getPrice() * foundOrder.getNumOfTables();
            foundOrder.setTotalCost(newTotal);
            Date newDate = inputter.getDate("Enter new event date (leave blank to keep old)");
            if (newDate != null) {
                foundOrder.setEventDate(newDate);
            }
            System.out.println("Order updated successfully!");
            System.out.println("Code of Set Menu: " + foundOrder.getMenuId());
            SetMenu newMenuId = menuList.get(foundOrder.getMenuId());
            System.out.println("Set menu name   : " + newMenuId.getMenuName());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Event date      : " + sdf.format(foundOrder.getEventDate()));
            System.out.printf("Price            : %,.0f Vnd\n", foundOrder.getPrice());
            System.out.println("Ingredients :");
            String raw = newMenuId.getIngredients().replace("\"", "");
            String[] groups = raw.split("#");
            for (String group : groups) {
                System.out.println(" " + group.trim());
            }
            System.out.println("-------------------------------------------------------");
            System.out.printf("Total cost : %,.0f Vnd\n", foundOrder.getTotalCost());
            System.out.println("-------------------------------------------------------");
            System.out.println("Customer updated successfully.");
            choice = inputter.getString("choose Y(continue Update)or N (exist): ");

        } while (choice.equalsIgnoreCase("y"));

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
