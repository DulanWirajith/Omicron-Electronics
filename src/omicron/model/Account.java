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
public class Account {

    private String accountName;
    private double accountTotal_Amount;

    public Account() {
    }

    public Account(String accountName, double accountTotal_Amount) {
        this.accountName = accountName;
        this.accountTotal_Amount = accountTotal_Amount;
    }

    public Account(String accountName) {
        this.accountName = accountName;
    }

    /**
     * @return the accountName
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * @param accountName the accountName to set
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * @return the accountTotal_Amount
     */
    public double getAccountTotal_Amount() {
        return accountTotal_Amount;
    }

    /**
     * @param accountTotal_Amount the accountTotal_Amount to set
     */
    public void setAccountTotal_Amount(double accountTotal_Amount) {
        this.accountTotal_Amount = accountTotal_Amount;
    }

 }
