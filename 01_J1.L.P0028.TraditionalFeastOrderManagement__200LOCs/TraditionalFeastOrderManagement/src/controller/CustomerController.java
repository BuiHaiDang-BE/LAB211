/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import model.Customer;
import tool.Acceptable;
import view.displayView;

/**
 *
 * @author Bui_Hai_Dang
 */
public class CustomerController implements Acceptable {

    private List<Customer> customerList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private displayView view = new displayView();

    // search code by id
    public Customer findCustomer(String code) {
        for (Customer cus : customerList) {
            if (cus.getCustomerCode().equalsIgnoreCase(code)) {
                return cus;
            }
        }
        return null;
    }

    // lay list
    public List<Customer> getCustomerList() {
        return this.customerList;
    }

    //1 register customer
    public void registerCustomer() {
        String code, name, phone, email;
        while (true) {
            while (true) {
                System.out.print("Enter code: ");
                code = sc.nextLine().trim().toUpperCase();
                if (!code.matches(CUS_ID_VALID)) {
                    System.out.println("Invalid format");
                } else if (findCustomer(code) != null) {
                    System.out.println("Customer code already exists");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.print("Enter name: ");
                name = sc.nextLine().trim();
                if (!(name.matches(NAME_VALID)) && (name.isEmpty())) {
                    System.out.println("Invalid Format");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.print("Enter phone: ");
                phone = sc.nextLine().trim();
                if (!(phone.matches(PHONE_VALID))) {
                    System.out.println("Invalid Format");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.print("Enter email: ");
                email = sc.nextLine().trim();
                if (!(name.matches(NAME_VALID)) && (name.isEmpty())) {
                    System.out.println("Invalid Format");
                } else {
                    break;
                }
            }

            customerList.add(new Customer(code, name, phone, email));
            System.out.println("register successfully");
            System.out.print("Continue registering? (Y/N): ");
            if (!sc.nextLine().equalsIgnoreCase("Y")) {
                break;
            }

        }
    }

    /*------------------------------------------------------*/
    //2 update customer
    public void updateCustomer() {
        System.out.print("Enter code customer:");
        String code = sc.nextLine().trim();
        Customer newcs = findCustomer(code);

        if ((newcs == null)) {
            System.out.println("This customer does not exist.");
            return;
        }

        System.out.println("enter new name:");
        String newName = sc.nextLine().trim();
        if (!newName.isEmpty()) {
            if (newName.matches(NAME_VALID)) {
                newcs.setName(newName);
            } else {
                System.out.println("Invalid name");
            }
        }

        System.out.print("enter new Phone: ");
        String newPhone = sc.nextLine().trim();
        if (!newPhone.isEmpty()) {
            if (newPhone.matches(PHONE_VALID)) {
                newcs.setPhoneNumber(newPhone);
            } else {
                System.out.println("Invalid phone");
            }
        }

        System.out.print("New Email (Enter to skip): ");
        String newEmail = sc.nextLine().trim();
        if (!newEmail.isEmpty()) {
            if (newEmail.matches(EMAIL_VALID)) {
                newcs.setEmail(newEmail);
            } else {
                System.out.println("Invalid email");
            }
        }

        System.out.println("Update process finished");

    }

    /*--------------------------------------------------*/
    //3. Search for customer information by name
    public void searchByName() {
        System.out.print("enter the name or partial name: ");
        ArrayList<Customer> listName = new ArrayList<>();

        String name = sc.nextLine().toLowerCase().trim();

        for (Customer customer : customerList) {
            if (customer.getName().toLowerCase().contains(name)) {
                listName.add(customer);
            }
        }
        Collections.sort(listName, (a, b) -> a.getName().compareTo(b.getName()));

        view.displayList(listName);
    }

}
