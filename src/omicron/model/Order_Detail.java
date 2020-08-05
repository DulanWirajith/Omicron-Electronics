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
public class Order_Detail {

    private String itemCode;
    private String ordersId;
    private String batchId;
    private int order_detailQty;
    private double order_detailBatchSellingPrice;
    private double order_detailSellingPrice;
    private String order_detailReason;

    public Order_Detail() {
    }

//    public Order_Detail(String itemCode, String ordersId, String batchId, int order_detailQty, double order_detailSellingPrice, String order_detailReason) {
//        this.itemCode = itemCode;
//        this.ordersId = ordersId;
//        this.batchId = batchId;
//        this.order_detailQty = order_detailQty;
//        this.order_detailSellingPrice = order_detailSellingPrice;
//        this.order_detailReason = order_detailReason;
//    }

    public Order_Detail(String itemCode, String ordersId, String batchId, int order_detailQty, double order_detailBatchSellingPrice, double order_detailSellingPrice, String order_detailReason) {
        this.itemCode = itemCode;
        this.ordersId = ordersId;
        this.batchId = batchId;
        this.order_detailQty = order_detailQty;
        this.order_detailBatchSellingPrice = order_detailBatchSellingPrice;
        this.order_detailSellingPrice = order_detailSellingPrice;
        this.order_detailReason = order_detailReason;
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
     * @return the order_detailQty
     */
    public int getOrder_detailQty() {
        return order_detailQty;
    }

    /**
     * @param order_detailQty the order_detailQty to set
     */
    public void setOrder_detailQty(int order_detailQty) {
        this.order_detailQty = order_detailQty;
    }

    /**
     * @return the order_detailSellingPrice
     */
    public double getOrder_detailSellingPrice() {
        return order_detailSellingPrice;
    }

    /**
     * @param order_detailSellingPrice the order_detailSellingPrice to set
     */
    public void setOrder_detailSellingPrice(double order_detailSellingPrice) {
        this.order_detailSellingPrice = order_detailSellingPrice;
    }

    /**
     * @return the order_detailReason
     */
    public String getOrder_detailReason() {
        return order_detailReason;
    }

    /**
     * @param order_detailReason the order_detailReason to set
     */
    public void setOrder_detailReason(String order_detailReason) {
        this.order_detailReason = order_detailReason;
    }

    /**
     * @return the order_detailBatchSellingPrice
     */
    public double getOrder_detailBatchSellingPrice() {
        return order_detailBatchSellingPrice;
    }

    /**
     * @param order_detailBatchSellingPrice the order_detailBatchSellingPrice to set
     */
    public void setOrder_detailBatchSellingPrice(double order_detailBatchSellingPrice) {
        this.order_detailBatchSellingPrice = order_detailBatchSellingPrice;
    }
    

   
    

}
