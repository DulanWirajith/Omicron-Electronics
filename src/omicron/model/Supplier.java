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
public class Supplier {

    private String supplierId;
    private String supplierName;
    private String supplierNic;
    private String supplierAddress;
    private int supplierTel_Num;
    private String supplierEmail;
    private String supplierFax;


    public Supplier() {
    }

    public Supplier(String supplierId, String supplierName, String supplierNic, String supplierAddress, int supplierTel_Num, String supplierEmail, String supplierFax) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierNic = supplierNic;
        this.supplierAddress = supplierAddress;
        this.supplierTel_Num = supplierTel_Num;
        this.supplierEmail = supplierEmail;
        this.supplierFax = supplierFax;
        
    }

    public Supplier(String supplierId) {
        this.supplierId = supplierId;
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
     * @return the supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName the supplierName to set
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * @return the supplierNic
     */
    public String getSupplierNic() {
        return supplierNic;
    }

    /**
     * @param supplierNic the supplierNic to set
     */
    public void setSupplierNic(String supplierNic) {
        this.supplierNic = supplierNic;
    }

    
    /**
     * @return the supplierAddress
     */
    public String getSupplierAddress() {
        return supplierAddress;
    }

    /**
     * @param supplierAddress the supplierAddress to set
     */
    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    /**
     * @return the supplierTel_Num
     */
    public int getSupplierTel_Num() {
        return supplierTel_Num;
    }

    /**
     * @param supplierTel_Num the supplierTel_Num to set
     */
    public void setSupplierTel_Num(int supplierTel_Num) {
        this.supplierTel_Num = supplierTel_Num;
    }

    /**
     * @return the supplierEmail
     */
    public String getSupplierEmail() {
        return supplierEmail;
    }

    /**
     * @param supplierEmail the supplierEmail to set
     */
    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    /**
     * @return the supplierFax
     */
    public String getSupplierFax() {
        return supplierFax;
    }

    /**
     * @param supplierFax the supplierFax to set
     */
    public void setSupplierFax(String supplierFax) {
        this.supplierFax = supplierFax;
    }

   
}
