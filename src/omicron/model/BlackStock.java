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
public class BlackStock {

    private String itemCode;
    private double unitPrice;
    private double discountPrice;
    private int qty;
    private String status;
    private String confirm;
    private double tableUnitPrice;

    public BlackStock() {
    }

    public BlackStock(String itemCode, double unitPrice, double discountPrice, int qty, String status, String confirm, double tableUnitPrice) {
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
        this.discountPrice = discountPrice;
        this.qty = qty;
        this.status = status;
        this.confirm = confirm;
        this.tableUnitPrice = tableUnitPrice;
    }
    
    
     public BlackStock(String itemCode,double tableUnitPrice) {
        this.itemCode = itemCode;
        this.tableUnitPrice = tableUnitPrice;
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
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the discountPrice
     */
    public double getDiscountPrice() {
        return discountPrice;
    }

    /**
     * @param discountPrice the discountPrice to set
     */
    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the confirm
     */
    public String getConfirm() {
        return confirm;
    }

    /**
     * @param confirm the confirm to set
     */
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    /**
     * @return the tableUnitPrice
     */
    public double getTableUnitPrice() {
        return tableUnitPrice;
    }

    /**
     * @param tableUnitPrice the tableUnitPrice to set
     */
    public void setTableUnitPrice(double tableUnitPrice) {
        this.tableUnitPrice = tableUnitPrice;
    }

    
}
