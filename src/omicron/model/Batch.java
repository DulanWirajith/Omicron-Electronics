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
public class Batch {

    private String itemCode;
    private String batchId;
    private double batchBuyingPrice;
    private double batchSellingPrice;
    private String batchDescription;
    private int batchQty;
    
    private String itemName;
    private int re_OrderLevelQty;
    private int availabeQty;
    

    public Batch() {
    }

    public Batch(String itemCode, String itemName, int re_OrderLevelQty, int availabeQty) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.re_OrderLevelQty = re_OrderLevelQty;
        this.availabeQty = availabeQty;
    }

    
    
    public Batch(String itemCode, String batchId, double batchBuyingPrice, double batchSellingPrice, String batchDescription, int batchQty) {
        this.itemCode = itemCode;
        this.batchId = batchId;
        this.batchBuyingPrice = batchBuyingPrice;
        this.batchSellingPrice = batchSellingPrice;
        this.batchDescription = batchDescription;
        this.batchQty = batchQty;
    }

    public Batch(String batchId, int batchQty) {
        this.batchId = batchId;
        this.batchQty = batchQty;
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
     * @return the batchBuyingPrice
     */
    public double getBatchBuyingPrice() {
        return batchBuyingPrice;
    }

    /**
     * @param batchBuyingPrice the batchBuyingPrice to set
     */
    public void setBatchBuyingPrice(double batchBuyingPrice) {
        this.batchBuyingPrice = batchBuyingPrice;
    }

    /**
     * @return the batchSellingPrice
     */
    public double getBatchSellingPrice() {
        return batchSellingPrice;
    }

    /**
     * @param batchSellingPrice the batchSellingPrice to set
     */
    public void setBatchSellingPrice(double batchSellingPrice) {
        this.batchSellingPrice = batchSellingPrice;
    }

    /**
     * @return the batchDate
     */
    public String getBatchDescription() {
        return batchDescription;
    }

    /**
     * @param batchDate the batchDate to set
     */
    public void setBatchDescription(String batchDescription) {
        this.batchDescription = batchDescription;
    }

    /**
     * @return the batchQty
     */
    public int getBatchQty() {
        return batchQty;
    }

    /**
     * @param batchQty the batchQty to set
     */
    public void setBatchQty(int batchQty) {
        this.batchQty = batchQty;
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
     * @return the availabeQty
     */
    public int getAvailabeQty() {
        return availabeQty;
    }

    /**
     * @param availabeQty the availabeQty to set
     */
    public void setAvailabeQty(int availabeQty) {
        this.availabeQty = availabeQty;
    }

    /**
     * @return the re_OrderLevelQty
     */
    public int getRe_OrderLevelQty() {
        return re_OrderLevelQty;
    }

    /**
     * @param re_OrderLevelQty the re_OrderLevelQty to set
     */
    public void setRe_OrderLevelQty(int re_OrderLevelQty) {
        this.re_OrderLevelQty = re_OrderLevelQty;
    }

}
