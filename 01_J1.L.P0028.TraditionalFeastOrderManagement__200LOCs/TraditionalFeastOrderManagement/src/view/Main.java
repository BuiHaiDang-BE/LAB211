/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Bui_Hai_Dang
 */
import controller.CustomerController;
import controller.MenuController;
import controller.OrderController;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import model.Customer;
import model.SetMenu;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        CustomerController controller = new CustomerController();
        MenuController menu = new MenuController();
        OrderController order = new OrderController();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("----- TEST MENU -----");
            System.out.println("1. Register Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Search for customer information by name");
            System.out.println("4. Display feast menus");
            System.out.println("5. Place a feast order");
            System.out.println("6. Update order information");
            System.out.println("7. Save data to file");
            System.out.println("8. Display Customer or Order lists ");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    controller.registerCustomer();
                    break;
                case 2:
                    controller.updateCustomer();
                    break;

                case 3:
                    controller.searchByName();
                    break;
                case 4:
                    menu.displayMenus();
                    break;
                case 5:
                    // Gọi thông qua biến 'controller' và 'menu' bạn đã tạo ở trên
                    List<Customer> currentCustomers = controller.getCustomerList();
                    List<SetMenu> currentMenus = menu.getMenuList();

                    // Truyền 2 list này vào hàm placeOrder
                    order.placeOrder(currentCustomers, currentMenus);
                    break; 
            }

        } while (choice != 0);
    }
}
