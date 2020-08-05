/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omicron.model;

/**
 *
 * @author Dulan
 */
public class Supply_Order_Detail {

    private String itemCode;
    private String supply_orderId;
    private int supply_order_detailRequestQty;
    private String subItemName;
    private String batchId;
    private double batchUnitPrice;
    private double amount;

    public Supply_Order_Detail() {
    }

    public Supply_Order_Detail(String itemCode, String supply_orderId, int supply_order_detailRequestQty,String batchId) {
        this.itemCode = itemCode;
        this.supply_orderId = supply_orderId;
        this.supply_order_detailRequestQty = supply_order_detailRequestQty;
        this.batchId = batchId;
    }

    public Supply_Order_Detail(String itemCode, String supply_orderId, int supply_order_detailRequestQty, String subItemName, String batchId, double batchUnitPrice, double amount) {
        this.itemCode = itemCode;
        this.supply_orderId = supply_orderId;
        this.supply_order_detailRequestQty = supply_order_detailRequestQty;
        this.subItemName = subItemName;
        this.batchId = batchId;
        this.batchUnitPrice = batchUnitPrice;
        this.amount = amount;
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
     * @return the supply_orderId
     */
    public String getSupply_orderId() {
        return supply_orderId;
    }

    /**
     * @param supply_orderId the supply_orderId to set
     */
    public void setSupply_orderId(String supply_orderId) {
        this.supply_orderId = supply_orderId;
    }

    /**
     * @return the supply_order_detailRequestQty
     */
    public int getSupply_order_detailRequestQty() {
        return supply_order_detailRequestQty;
    }

    /**
     * @param supply_order_detailRequestQty the supply_order_detailRequestQty to set
     */
    public void setSupply_order_detailRequestQty(int supply_order_detailRequestQty) {
        this.supply_order_detailRequestQty = supply_order_detailRequestQty;
    }

    /**
     * @return the subItemName
     */
    public String getSubItemName() {
        return subItemName;
    }

    /**
     * @param subItemName the subItemName to set
     */
    public void setSubItemName(String subItemName) {
        this.subItemName = subItemName;
    }

    /**
     * @return the batchId
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * @param batchId the batchId to set
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    /**
     * @return the batchUnitPrice
     */
    public double getBatchUnitPrice() {
        return batchUnitPrice;
    }

    /**
     * @param batchUnitPrice the batchUnitPrice to set
     */
    public void setBatchUnitPrice(double batchUnitPrice) {
        this.batchUnitPrice = batchUnitPrice;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    /**
     * @return the itemCode
     */
    
}
