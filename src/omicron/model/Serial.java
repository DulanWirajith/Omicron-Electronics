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
public class Serial {

    private String batchId;
    private int serial_num;

    public Serial() {
    }

    public Serial(String batchId, int serial_num) {
        this.batchId = batchId;
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
     * @return the serial_num
     */
    public int getSerial_num() {
        return serial_num;
    }

    /**
     * @param serial_num the serial_num to set
     */
    public void setSerial_num(int serial_num) {
        this.serial_num = serial_num;
    }

}
