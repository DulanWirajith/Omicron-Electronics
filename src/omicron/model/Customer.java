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
public class Customer {

    private String customerId;
    private String customerName;
    private String customerNic;
    private String customerAddress;
    private int customerTel_Num;

    public Customer() {
    }

    public Customer(String customerId, String customerName, String customerNic, String customerAddress, int customerTel_Num) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerNic = customerNic;
        this.customerAddress = customerAddress;
        this.customerTel_Num = customerTel_Num;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the customerNic
     */
    public String getCustomerNic() {
        return customerNic;
    }

    /**
     * @param customerNic the customerNic to set
     */
    public void setCustomerNic(String customerNic) {
        this.customerNic = customerNic;
    }

    /**
     * @return the customerAddress
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * @param customerAddress the customerAddress to set
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * @return the customerTel_Num
     */
    public int getCustomerTel_Num() {
        return customerTel_Num;
    }

    /**
     * @param customerTel_Num the customerTel_Num to set
     */
    public void setCustomerTel_Num(int customerTel_Num) {
        this.customerTel_Num = customerTel_Num;
    }
    
    

        
}
