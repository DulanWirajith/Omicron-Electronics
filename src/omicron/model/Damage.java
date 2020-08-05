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
public class Damage {

    private String batchId;
    private String damageId;
    private String serial_num;
    private String damageDate;
    private double damageTotAmount;
    private String itemCode;

    public Damage() {
    }

    public Damage(String batchId, String damageId, String serial_num, String damageDate, double damageTotAmount) {
        this.batchId = batchId;
        this.damageId = damageId;
        this.serial_num = serial_num;
        this.damageDate = damageDate;
        this.damageTotAmount = damageTotAmount;
    }

    public Damage(String batchId, String damageId, String serial_num, String damageDate, double damageTotAmount, String itemCode) {
        this.batchId = batchId;
        this.damageId = damageId;
        this.serial_num = serial_num;
        this.damageDate = damageDate;
        this.damageTotAmount = damageTotAmount;
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
     * @return the damageId
     */
    public String getDamageId() {
        return damageId;
    }

    /**
     * @param damageId the damageId to set
     */
    public void setDamageId(String damageId) {
        this.damageId = damageId;
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
     * @return the damageDate
     */
    public String getDamageDate() {
        return damageDate;
    }

    /**
     * @param damageDate the damageDate to set
     */
    public void setDamageDate(String damageDate) {
        this.damageDate = damageDate;
    }

    /**
     * @return the damageTotAmount
     */
    public double getDamageTotAmount() {
        return damageTotAmount;
    }

    /**
     * @param damageTotAmount the damageTotAmount to set
     */
    public void setDamageTotAmount(double damageTotAmount) {
        this.damageTotAmount = damageTotAmount;
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

    
    
}
