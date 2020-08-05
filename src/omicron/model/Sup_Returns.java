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
public class Sup_Returns {

    private String supplierId;
    private String batchId;
    private String serial_num;
    private String itemCode;
    private double batchSellingPrice;
    private String status;
    private String returnDescription;
    private String returnDate;

    public Sup_Returns() {
    }

//    public Sup_Returns(String supplierId, String batchId, String serial_num, String status, String returnDescription, String returnDate) {
//        this.supplierId = supplierId;
//        this.batchId = batchId;
//        this.serial_num = serial_num;
//        this.status = status;
//        this.returnDescription = returnDescription;
//        this.returnDate = returnDate;
//    }

    public Sup_Returns(String supplierId, String batchId, String serial_num, String itemCode, double batchSellingPrice, String status, String returnDescription, String returnDate) {
        this.supplierId = supplierId;
        this.batchId = batchId;
        this.serial_num = serial_num;
        this.itemCode = itemCode;
        this.batchSellingPrice = batchSellingPrice;
        this.status = status;
        this.returnDescription = returnDescription;
        this.returnDate = returnDate;
    }
    
    

    /**
     * @return the supplierId
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * @param supplierId the supplierId to set
     */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
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
     * @return the serial_num
     */
    public String getSerial_num() {
        return serial_num;
    }

    /**
     * @param serial_num the serial_num to set
     */
    public void setSerial_num(String serial_num) {
        this.serial_num = serial_num;
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
     * @return the returnDescription
     */
    public String getReturnDescription() {
        return returnDescription;
    }

    /**
     * @param returnDescription the returnDescription to set
     */
    public void setReturnDescription(String returnDescription) {
        this.returnDescription = returnDescription;
    }

    /**
     * @return the returnDate
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
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

}
