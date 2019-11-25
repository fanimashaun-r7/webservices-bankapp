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
    private Boolean debit;
    private Boolean credit;
    private Date dateOfTranaction;
    private String description;
    private float postTransactionBalance;

    public Transaction(int transactionId, Boolean debit, Boolean credit, Date dateOfTranaction, String description, float postTransactionBalance) {
        this.transactionId = transactionId;
        this.debit = debit;
        this.credit = credit;
        this.dateOfTranaction = dateOfTranaction;
        this.description = description;
        this.postTransactionBalance = postTransactionBalance;
    }

    public Transaction() {

    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Boolean getDebit() {
        return debit;
    }

    public void setDebit(Boolean debit) {
        this.debit = debit;
    }

    public Boolean getCredit() {
        return credit;
    }

    public void setCredit(Boolean credit) {
        this.credit = credit;
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

    public float getPostTransactionBalance() {
        return postTransactionBalance;
    }

    public void setPostTransactionBalance(float postTransactionBalance) {
        this.postTransactionBalance = postTransactionBalance;
    }

}
