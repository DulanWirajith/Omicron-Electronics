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
public class GRN {

    private String batchId;
    private String supply_orderId;
    private int grnReceived_Qty;
    private double grnTotAmount;

    public GRN() {
    }

    public GRN(String batchId, String supply_orderId, int grnReceived_Qty, double grnTotAmount) {
        this.batchId = batchId;
        this.supply_orderId = supply_orderId;
        this.grnReceived_Qty = grnReceived_Qty;
        this.grnTotAmount = grnTotAmount;
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
     * @return the grnReceived_Qty
     */
    public int getGrnReceived_Qty() {
        return grnReceived_Qty;
    }

    /**
     * @param grnReceived_Qty the grnReceived_Qty to set
     */
    public void setGrnReceived_Qty(int grnReceived_Qty) {
        this.grnReceived_Qty = grnReceived_Qty;
    }

    /**
     * @return the grnTotAmount
     */
    public double getGrnTotAmount() {
        return grnTotAmount;
    }

    /**
     * @param grnTotAmount the grnTotAmount to set
     */
    public void setGrnTotAmount(double grnTotAmount) {
        this.grnTotAmount = grnTotAmount;
    }

    /**
     * @return the batchId
     */
    

}
