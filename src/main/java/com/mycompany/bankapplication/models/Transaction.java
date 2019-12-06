/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapplication.models;

import java.util.Date;

/**
 *
 * @author The Young CEO
 */
public class Transaction {

    private int transactionId;
    private int customerId; 
    private Boolean isDebit;
    private Date dateOfTranaction;
    private String description;
    private float TransactionAmount;

    public Transaction(int transactionId, int customerId, Boolean isDebit, Date dateOfTranaction, String description, float TransactionAmount) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.isDebit = isDebit;
        this.dateOfTranaction = dateOfTranaction;
        this.description = description;
        this.TransactionAmount = TransactionAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Transaction() {

    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Boolean getIsDebit() {
        return isDebit;
    }

    public void setIsDebit(Boolean debit) {
        this.isDebit = debit;
    }

    public Date getDateOfTranaction() {
        return dateOfTranaction;
    }

    public void setDateOfTranaction(Date dateOfTranaction) {
        this.dateOfTranaction = dateOfTranaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getTransactionAmount() {
        return TransactionAmount;
    }

    public void setTransactionAmount(float TransactionAmount) {
        this.TransactionAmount = TransactionAmount;
    }

}
