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
public class Supply_Order {

    private String supplierId;
    private String supply_orderId;
    private String supply_orderRequestDate;
    private double supply_orderTotAmount;
    private String supply_orderWillReceiveDate;
    private ArrayList<Supply_Order_Detail> supply_Order_Details;
    private ArrayList<Batch> allBatchDetails;
    private ArrayList<GRN> allGRNDetails;

    public Supply_Order() {
    }

    public Supply_Order(String supplierId, String supply_orderId, String supply_orderRequestDate, double supply_orderTotAmount, String supply_orderWillReceiveDate, ArrayList<Supply_Order_Detail> supply_Order_Details) {
        this.supplierId = supplierId;
        this.supply_orderId = supply_orderId;
        this.supply_orderRequestDate = supply_orderRequestDate;
        this.supply_orderTotAmount = supply_orderTotAmount;
        this.supply_orderWillReceiveDate = supply_orderWillReceiveDate;
        this.supply_Order_Details = supply_Order_Details;
    }

    public Supply_Order(String supplierId, String supply_orderId, double supply_orderTotAmount, ArrayList<Supply_Order_Detail> supply_Order_Details) {
        this.supplierId = supplierId;
        this.supply_orderId = supply_orderId;
        this.supply_orderTotAmount = supply_orderTotAmount;
        this.supply_Order_Details = supply_Order_Details;
    }

    public Supply_Order(String supply_orderId, double supply_orderTotAmount, String supply_orderWillReceiveDate, ArrayList<Batch> allBatchDetails, ArrayList<GRN> allGRNDetails) {
        this.supply_orderId = supply_orderId;
        this.supply_orderTotAmount = supply_orderTotAmount;
        this.supply_orderWillReceiveDate = supply_orderWillReceiveDate;
        this.allBatchDetails = allBatchDetails;
        this.allGRNDetails = allGRNDetails;
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
     * @return the supply_orderRequestDate
     */
    public String getSupply_orderRequestDate() {
        return supply_orderRequestDate;
    }

    /**
     * @param supply_orderRequestDate the supply_orderRequestDate to set
     */
    public void setSupply_orderRequestDate(String supply_orderRequestDate) {
        this.supply_orderRequestDate = supply_orderRequestDate;
    }

    /**
     * @return the supply_orderTotAmount
     */
    public double getSupply_orderTotAmount() {
        return supply_orderTotAmount;
    }

    /**
     * @param supply_orderTotAmount the supply_orderTotAmount to set
     */
    public void setSupply_orderTotAmount(double supply_orderTotAmount) {
        this.supply_orderTotAmount = supply_orderTotAmount;
    }

    /**
     * @return the supply_orderWillReceiveDate
     */
    public String getSupply_orderWillReceiveDate() {
        return supply_orderWillReceiveDate;
    }

    /**
     * @param supply_orderWillReceiveDate the supply_orderWillReceiveDate to set
     */
    public void setSupply_orderWillReceiveDate(String supply_orderWillReceiveDate) {
        this.supply_orderWillReceiveDate = supply_orderWillReceiveDate;
    }

    /**
     * @return the supply_Order_Details
     */
    public ArrayList<Supply_Order_Detail> getSupply_Order_Details() {
        return supply_Order_Details;
    }

    /**
     * @param supply_Order_Details the supply_Order_Details to set
     */
    public void setSupply_Order_Details(ArrayList<Supply_Order_Detail> supply_Order_Details) {
        this.supply_Order_Details = supply_Order_Details;
    }

    /**
     * @return the allBatchDetails
     */
    public ArrayList<Batch> getAllBatchDetails() {
        return allBatchDetails;
    }

    /**
     * @param allBatchDetails the allBatchDetails to set
     */
    public void setAllBatchDetails(ArrayList<Batch> allBatchDetails) {
        this.allBatchDetails = allBatchDetails;
    }

    /**
     * @return the allGRNDetails
     */
    public ArrayList<GRN> getAllGRNDetails() {
        return allGRNDetails;
    }

    /**
     * @param allGRNDetails the allGRNDetails to set
     */
    public void setAllGRNDetails(ArrayList<GRN> allGRNDetails) {
        this.allGRNDetails = allGRNDetails;
    }

}
