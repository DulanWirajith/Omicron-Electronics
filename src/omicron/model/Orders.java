/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omicron.model;

import java.util.ArrayList;

/**
 *
 * @author Dulan
 */
public class Orders {

    private String customerId;
    private String customerName ;
    private String ordersId;
    private String ordersDate;
    private double ordersTot_Amount;
    private ArrayList<Order_Detail> orderDetailList;
    private ArrayList<BlackStock> blackStockList;
    private String itemCode;
    private String itemName;
    private int sellingQty; 

    
    
    public Orders() {
    }

    public Orders(String itemCode, String itemName, int sellingQty) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.sellingQty = sellingQty;
    }
    
    public Orders(String customerId, String customerName, String ordersId, String ordersDate, double ordersTot_Amount, ArrayList<Order_Detail> orderDetailList, ArrayList<BlackStock> blackStockList) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.ordersId = ordersId;
        this.ordersDate = ordersDate;
        this.ordersTot_Amount = ordersTot_Amount;
        this.orderDetailList = orderDetailList;
        this.blackStockList = blackStockList;
    }

    public Orders(String customerId, String customerName, String ordersId, String ordersDate, double ordersTot_Amount, ArrayList<Order_Detail> orderDetailList) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.ordersId = ordersId;
        this.ordersDate = ordersDate;
        this.ordersTot_Amount = ordersTot_Amount;
        this.orderDetailList = orderDetailList;
    }
    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the ordersId
     */
    public String getOrdersId() {
        return ordersId;
    }

    /**
     * @param ordersId the ordersId to set
     */
    public void setOrdersId(String ordersId) {
        this.ordersId = ordersId;
    }

    /**
     * @return the ordersDate
     */
    public String getOrdersDate() {
        return ordersDate;
    }

    /**
     * @param ordersDate the ordersDate to set
     */
    public void setOrdersDate(String ordersDate) {
        this.ordersDate = ordersDate;
    }

    /**
     * @return the ordersTot_Amount
     */
    public double getOrdersTot_Amount() {
        return ordersTot_Amount;
    }

    /**
     * @param ordersTot_Amount the ordersTot_Amount to set
     */
    public void setOrdersTot_Amount(double ordersTot_Amount) {
        this.ordersTot_Amount = ordersTot_Amount;
    }

    /**
     * @return the orderDetailList
     */
    public ArrayList<Order_Detail> getOrderDetailList() {
        return orderDetailList;
    }

    /**
     * @param orderDetailList the orderDetailList to set
     */
    public void setOrderDetailList(ArrayList<Order_Detail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    /**
     * @return the blackStockList
     */
    public ArrayList<BlackStock> getBlackStockList() {
        return blackStockList;
    }

    /**
     * @param blackStockList the blackStockList to set
     */
    public void setBlackStockList(ArrayList<BlackStock> blackStockList) {
        this.blackStockList = blackStockList;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the sellingQty
     */
    public int getSellingQty() {
        return sellingQty;
    }

    /**
     * @param sellingQty the sellingQty to set
     */
    public void setSellingQty(int sellingQty) {
        this.sellingQty = sellingQty;
    }

    

}
