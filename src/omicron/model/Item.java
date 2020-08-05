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
public class Item {

    private String brandId;
    private String itemCode;
    private String itemName;
    private String SupplierId;
    private int itemRe_OrderLevel;

    public Item() {
    }

//    public Item(String brandId, String itemCode, String itemName, String SupplierId) {
//        this.brandId = brandId;
//        this.itemCode = itemCode;
//        this.itemName = itemName;
//        this.SupplierId = SupplierId;
//    }

    public Item(String brandId, String itemCode, String itemName, String SupplierId, int itemRe_OrderLevel) {
        this.brandId = brandId;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.SupplierId = SupplierId;
        this.itemRe_OrderLevel = itemRe_OrderLevel;
    }

    public Item(String itemName, String itemCode) {
        this.itemCode = itemCode;
        this.itemName = itemName;
    }

    /**
     * @return the brandId
     */
    public String getBrandId() {
        return brandId;
    }

    /**
     * @param brandId the brandId to set
     */
    public void setBrandId(String brandId) {
        this.brandId = brandId;
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
     * @return the SupplierId
     */
    public String getSupplierId() {
        return SupplierId;
    }

    /**
     * @param SupplierId the SupplierId to set
     */
    public void setSupplierId(String SupplierId) {
        this.SupplierId = SupplierId;
    }

    /**
     * @return the itemRe_OrderLevel
     */
    public int getItemRe_OrderLevel() {
        return itemRe_OrderLevel;
    }

    /**
     * @param itemRe_OrderLevel the itemRe_OrderLevel to set
     */
    public void setItemRe_OrderLevel(int itemRe_OrderLevel) {
        this.itemRe_OrderLevel = itemRe_OrderLevel;
    }

}
