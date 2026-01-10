/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Bui_Hai_Dang
 */
public class order {
    public String orderCode;
    public String customerId;
    public String provide;
    public String menuId;
    public int numOfTables;
    public Date eventDate;

    public order() {
    }

    public order(String orderCode, String customerId, String provide, String menuId, int numOfTables, Date eventDate) {
        this.orderCode = orderCode;
        this.customerId = customerId;
        this.provide = provide;
        this.menuId = menuId;
        this.numOfTables = numOfTables;
        this.eventDate = eventDate;
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

    public String getProvide() {
        return provide;
    }

    public void setProvide(String provide) {
        this.provide = provide;
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
    public String toString() {
        return "order{" + "orderCode=" + orderCode + ", customerId=" + customerId + ", provide=" + provide + ", menuId=" + menuId + ", numOfTables=" + numOfTables + ", eventDate=" + eventDate + '}';
    }
    
    
}
