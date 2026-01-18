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

    public String orderCode;
    public String customerId;
    public String menuId;
    public int numOfTables;
    public Date eventDate;

    public Order() {
        this.orderCode = generateOrderCode();
    }

    public Order( String customerId, String menuId, int numOfTables, Date eventDate) {
        this.orderCode = generateOrderCode();
        this.customerId = customerId;
        this.menuId = menuId;
        this.numOfTables = numOfTables;
        this.eventDate = eventDate;
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
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Order other = (Order) obj;
        return Objects.equals(this.customerId, other.customerId) &&
               Objects.equals(this.menuId, other.menuId) &&
               Objects.equals(this.eventDate, other.eventDate);
    }
//    @Override
//    public String toString() {
//        return "order{" + "orderCode=" + orderCode + ", customerId=" + customerId + ", provide=" + provide + ", menuId=" + menuId + ", numOfTables=" + numOfTables + ", eventDate=" + eventDate + '}';
//    }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("| %-15s | %-10s | %-10s | %-10s | %2d |", 
                             orderCode, sdf.format(eventDate), customerId, menuId, numOfTables);
    }

}
