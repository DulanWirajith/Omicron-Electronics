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
public class Sup_Payment {

    private String supply_orderId;
    private String sup_paymentId;
    private String sup_paymentDate;
    private String sup_paymentMethod;
    private String sup_paymentCheckDate;
    private String sup_paymentCheckNumber;
    private double sup_paymentAmount;
    private String account;
    
    public Sup_Payment() {
    }

    public Sup_Payment(String supply_orderId, String sup_paymentId, String sup_paymentDate, String sup_paymentMethod, String sup_paymentCheckDate, String sup_paymentCheckNumber, double sup_paymentAmount) {
        this.supply_orderId = supply_orderId;
        this.sup_paymentId = sup_paymentId;
        this.sup_paymentDate = sup_paymentDate;
        this.sup_paymentMethod = sup_paymentMethod;
        this.sup_paymentCheckDate = sup_paymentCheckDate;
        this.sup_paymentCheckNumber = sup_paymentCheckNumber;
        this.sup_paymentAmount = sup_paymentAmount;
    }

    public Sup_Payment(String supply_orderId, String sup_paymentId, String sup_paymentDate, String sup_paymentMethod, String sup_paymentCheckDate, String sup_paymentCheckNumber, double sup_paymentAmount, String account) {
        this.supply_orderId = supply_orderId;
        this.sup_paymentId = sup_paymentId;
        this.sup_paymentDate = sup_paymentDate;
        this.sup_paymentMethod = sup_paymentMethod;
        this.sup_paymentCheckDate = sup_paymentCheckDate;
        this.sup_paymentCheckNumber = sup_paymentCheckNumber;
        this.sup_paymentAmount = sup_paymentAmount;
        this.account = account;
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
     * @return the sup_paymentId
     */
    public String getSup_paymentId() {
        return sup_paymentId;
    }

    /**
     * @param sup_paymentId the sup_paymentId to set
     */
    public void setSup_paymentId(String sup_paymentId) {
        this.sup_paymentId = sup_paymentId;
    }

    /**
     * @return the sup_paymentDate
     */
    public String getSup_paymentDate() {
        return sup_paymentDate;
    }

    /**
     * @param sup_paymentDate the sup_paymentDate to set
     */
    public void setSup_paymentDate(String sup_paymentDate) {
        this.sup_paymentDate = sup_paymentDate;
    }

    /**
     * @return the sup_paymentMethod
     */
    public String getSup_paymentMethod() {
        return sup_paymentMethod;
    }

    /**
     * @param sup_paymentMethod the sup_paymentMethod to set
     */
    public void setSup_paymentMethod(String sup_paymentMethod) {
        this.sup_paymentMethod = sup_paymentMethod;
    }

    /**
     * @return the sup_paymentCheckDate
     */
    public String getSup_paymentCheckDate() {
        return sup_paymentCheckDate;
    }

    /**
     * @param sup_paymentCheckDate the sup_paymentCheckDate to set
     */
    public void setSup_paymentCheckDate(String sup_paymentCheckDate) {
        this.sup_paymentCheckDate = sup_paymentCheckDate;
    }

    /**
     * @return the sup_paymentCheckNumber
     */
    public String getSup_paymentCheckNumber() {
        return sup_paymentCheckNumber;
    }

    /**
     * @param sup_paymentCheckNumber the sup_paymentCheckNumber to set
     */
    public void setSup_paymentCheckNumber(String sup_paymentCheckNumber) {
        this.sup_paymentCheckNumber = sup_paymentCheckNumber;
    }

    /**
     * @return the sup_paymentAmount
     */
    public double getSup_paymentAmount() {
        return sup_paymentAmount;
    }

    /**
     * @param sup_paymentAmount the sup_paymentAmount to set
     */
    public void setSup_paymentAmount(double sup_paymentAmount) {
        this.sup_paymentAmount = sup_paymentAmount;
    }

    /**
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
    }
    
    
}
