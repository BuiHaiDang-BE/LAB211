/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Customer;
import tool.Acceptable;
import tool.FileUtils;
import tool.Inputter;

/**
 *
 * @author Bui_Hai_Dang
 */
public class Customers extends ArrayList<Customer> implements Workable<Customer> {

    private final String pathFile = "customers.dat";
    Inputter inputter = new Inputter();

    @Override
    public void addNew(Customer x) {
        if (this.add(x)) {
            System.out.println("Customer added successfully.");
        }
    }

    @Override
    public void update(Customer x) {
    Customer found = searchById(x.getId());
    if (found != null) {

        
        String newName = inputter.inputAndLoop("Enter new name: ", Acceptable.NAME_VALID);
        if (!newName.isEmpty()) {
            x.setName(newName);
        }

        
        String newPhone = inputter.inputAndLoop("Enter new phone: ", Acceptable.PHONE_VALID);
        if (!newPhone.isEmpty()) {
            x.setPhone(newPhone);
        }

       
        String newEmail = inputter.inputAndLoop("Enter new email: ", Acceptable.EMAIL_VALID);
        if (!newEmail.isEmpty()) {
            x.setEmail(newEmail);
        }

  
        System.out.println("Customer updated successfully.");
    }
}


    @Override
    public Customer searchById(String id) {
        for (Customer c : this) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    public void searchByName(String name) {
        List<Customer> equallName = new ArrayList<>();
        name = name.trim().toLowerCase();
        for (Customer o : this) {
            if (o.getName().trim().toLowerCase().contains(name)) {
                equallName.add(o);
            }
        }
        Collections.sort(equallName, (a, b) -> a.getName().compareTo(b.getName()));

        for (Customer customer : equallName) {
            customer.toString();
        }
    }

    @Override
    public void showAll() {
        if (this.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (Customer c : this) {
            System.out.println(c);
        }
    }

    public void readFromFile() {
        this.clear();
        this.addAll(FileUtils.readFile(this.pathFile));
       
    }

    public void saveToFile() {
        FileUtils.saveToFile(this, this.pathFile);
       
    }

   
}
