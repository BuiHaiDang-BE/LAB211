/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author Bui_Hai_Dang
 */
import model.Order;
import tool.FileUtils;
import java.util.ArrayList;
import java.util.HashSet;
import tool.Inputter;

public class Orders extends HashSet<Order> implements Workable<Order> {

    private final String pathFile = "feast_order_service.dat";
    Inputter inputter = new Inputter();

    @Override
    public void addNew(Order x) {
        if (this.contains(x)) {
            System.out.println("Duplicate Data!");
        } else {
            this.add(x);

            System.out.println("Order placed successfully.");
        }
    }

    @Override
    public void update(Order x) {
    
    }

    @Override
    public Order searchById(String id) {
        for (Order o : this) {
            if (o.getOrderCode().equalsIgnoreCase(id)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public void showAll() {
        this.forEach(System.out::println);
    }

    public void readFromFile() {
        this.clear();
        this.addAll(FileUtils.readFile(this.pathFile));

    }

    public void saveToFile() {
        FileUtils.saveToFile(new ArrayList<>(this), this.pathFile); // Chuyển sang List để ghi file [cite: 791]

    }
}
