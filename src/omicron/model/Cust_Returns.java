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
public class Cust_Returns {

    private String ordersId;
    private String returnId;
    private String serial_num;
    private String batchId;
    private double batchSellingPrice;
    private String itemCode;
    private String returnSupplierId;
    private String returnReason;
    private String returnDate;
    private String sup_ReturnStatus;
    private String Sup_Return_returnDescription;

    public Cust_Returns() {
    }

    public Cust_Returns(String ordersId, String returnId, String serial_num, String batchId, String returnSupplierId, String returnReason, String returnDate, String sup_ReturnStatus, String Sup_Return_returnDescription) {
        this.ordersId = ordersId;
        this.returnId = returnId;
        this.serial_num = serial_num;
        this.batchId = batchId;
        this.returnSupplierId = returnSupplierId;
        this.returnReason = returnReason;
        this.returnDate = returnDate;
        this.sup_ReturnStatus = sup_ReturnStatus;
        this.Sup_Return_returnDescription = Sup_Return_returnDescription;
    }

    public Cust_Returns(String ordersId, String returnId, String serial_num, String batchId, double batchSellingPrice, String returnSupplierId, String returnReason, String returnDate, String sup_ReturnStatus, String Sup_Return_returnDescription) {
        this.ordersId = ordersId;
        this.returnId = returnId;
        this.serial_num = serial_num;
        this.batchId = batchId;
        this.batchSellingPrice = batchSellingPrice;
        this.returnSupplierId = returnSupplierId;
        this.returnReason = returnReason;
        this.returnDate = returnDate;
        this.sup_ReturnStatus = sup_ReturnStatus;
        this.Sup_Return_returnDescription = Sup_Return_returnDescription;
    }

    public Cust_Returns(String ordersId, String returnId, String serial_num, String batchId, double batchSellingPrice, String itemCode, String returnSupplierId, String returnReason, String returnDate, String sup_ReturnStatus, String Sup_Return_returnDescription) {
        this.ordersId = ordersId;
        this.returnId = returnId;
        this.serial_num = serial_num;
        this.batchId = batchId;
        this.batchSellingPrice = batchSellingPrice;
        this.itemCode = itemCode;
        this.returnSupplierId = returnSupplierId;
        this.returnReason = returnReason;
        this.returnDate = returnDate;
        this.sup_ReturnStatus = sup_ReturnStatus;
        this.Sup_Return_returnDescription = Sup_Return_returnDescription;
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
     * @return the returnId
     */
    public String getReturnId() {
        return returnId;
    }

    /**
     * @param returnId the returnId to set
     */
    public void setReturnId(String returnId) {
        this.returnId = returnId;
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
     * @return the returnSupplierId
     */
    public String getReturnSupplierId() {
        return returnSupplierId;
    }

    /**
     * @param returnSupplierId the returnSupplierId to set
     */
    public void setReturnSupplierId(String returnSupplierId) {
        this.returnSupplierId = returnSupplierId;
    }

    /**
     * @return the returnReason
     */
    public String getReturnReason() {
        return returnReason;
    }

    /**
     * @param returnReason the returnReason to set
     */
    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
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
     * @return the sup_Returnstatus
     */
    public String getSup_ReturnStatus() {
        return sup_ReturnStatus;
    }

    /**
     * @param sup_Returnstatus the sup_Returnstatus to set
     */
    public void setSup_ReturnStatus(String sup_ReturnStatus) {
        this.sup_ReturnStatus = sup_ReturnStatus;
    }

    /**
     * @return the Sup_Return_returnDescription
     */
    public String getSup_Return_returnDescription() {
        return Sup_Return_returnDescription;
    }

    /**
     * @param Sup_Return_returnDescription the Sup_Return_returnDescription to set
     */
    public void setSup_Return_returnDescription(String Sup_Return_returnDescription) {
        this.Sup_Return_returnDescription = Sup_Return_returnDescription;
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
