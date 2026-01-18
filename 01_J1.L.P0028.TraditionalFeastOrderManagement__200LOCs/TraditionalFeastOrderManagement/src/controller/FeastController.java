/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import business.Customers;
import business.Orders;
import business.SetMenus;
import java.util.Date;
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
        SetMenu foundmenu = new SetMenu();
        System.out.println("--- Place a Feast Order ---");
        if (customerList.isEmpty()) {
            System.out.println("Cusomer list is empty, please register");

        } else {
            String cId = inputter.inputAndLoop("Enter Customer ID: ", Acceptable.CUS_ID_VALID);
            if (cId.isEmpty()) {
                System.out.println("Cannot be blank");

            }

            if (customerList.searchById(cId) == null) {
                System.out.println("Customer not found!");
            }

            menuList.showMenuList();
            String mId = inputter.getString("Enter Menu ID: ");

            if (menuList.get(mId) == null) {
                System.out.println("Menu not found!");

            } else {
                int tables = inputter.IntAndLoop("Enter number of tables: ", Acceptable.POSITIVE_INT_VALID);

                orderList.addNew(new Order(cId, new Date(), cId, mId, mPrice, tables, cost));
            }
        }
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

    private Customer findCustomerInList(String code, List<Customer> customers) {
        for (Customer c : customers) {
            if (c.getCustomerCode().equalsIgnoreCase(code)) {
                return c; // Trả về đối tượng khách hàng nếu tìm thấy [cite: 165]
            }
        }
        return null; // Không tìm thấy
    }

// Hàm tìm thực đơn từ list thực đơn truyền vào
    private SetMenu findMenuInList(String code, List<SetMenu> menus) {
        for (SetMenu m : menus) {
            if (m.getMenuId().equalsIgnoreCase(code)) {
                return m; // Trả về đối tượng thực đơn nếu tìm thấy [cite: 176]
            }
        }
        return null; // Không tìm thấy
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
