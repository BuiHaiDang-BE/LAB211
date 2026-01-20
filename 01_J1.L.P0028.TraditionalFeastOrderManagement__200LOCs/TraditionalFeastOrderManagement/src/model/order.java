/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Bui_Hai_Dang
 */
public class Order implements Serializable {

    private String orderCode;
    private String customerId;
    private String menuId;
    private int numOfTables;
    private Date eventDate;
    private double price;
    private double totalCost;

    public Order() {
        this.orderCode = generateOrderCode();
    }

    public Order(String customerId, String menuId, int numberOfTables, Date eventDate, double price, double total) {
        this.orderCode = generateOrderCode();
        this.customerId = customerId;
        this.menuId = menuId;
        this.numOfTables = numberOfTables;
        this.eventDate = eventDate;
        this.price = price;
        this.totalCost = total;
    }

    public Order(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    private String generateOrderCode() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public int getNumOfTables() {
        return numOfTables;
    }

    public void setNumOfTables(int numOfTables) {
        this.numOfTables = numOfTables;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, menuId, eventDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        return Objects.equals(this.customerId, other.customerId)
                && Objects.equals(this.menuId, other.menuId)
                && Objects.equals(this.eventDate, other.eventDate);
    }

  @Override
public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    // Đúng: %-15s (Căn lề trái 15)
    // Sai: % 15s (Dư khoảng trắng giữa % và 15)
    return String.format("| %-15s | %-10s | %-10s | %-10s | %4d | %15,.0f | %15,.0f |", 
                         orderCode, sdf.format(eventDate), customerId, menuId, 
                         numOfTables, price, totalCost);
}

}
