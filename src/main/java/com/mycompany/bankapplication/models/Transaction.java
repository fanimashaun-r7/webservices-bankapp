/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapplication.models;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author The Young CEO
 */
public class Transaction {

    private int transactionId;
    private boolean isTransfer;
    private int customerId;
    private Boolean isDebit;
    private Date dateOfTransaction;
    private String description;
    private float TransactionAmount;
    private int transferCustomerId;
    private int transferCustomerAccountId;
    private float accountBalanceAfterTransaction;

    public Transaction(int transactionId, int customerId, Boolean isTransfer, Boolean isDebit, Date dateOfTransaction, String description, float TransactionAmount,float accountBalanceAfterTransaction) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.isDebit = isDebit;
        this.isTransfer = isTransfer;
        this.dateOfTransaction = dateOfTransaction;
        this.description = description;
        this.TransactionAmount = TransactionAmount;
        this.accountBalanceAfterTransaction = accountBalanceAfterTransaction;
    }

    public Transaction(int transferCustomerId, int transferCustomerAccountId, int transactionId, int customerId, Boolean isTransfer, Boolean isDebit, Date dateOfTransaction, String description, float TransactionAmount, float accountBalanceAfterTransaction) {
        this.transactionId = transactionId;
        this.isDebit = isDebit;
        this.customerId = customerId;
        this.isTransfer = isTransfer;
        this.dateOfTransaction = dateOfTransaction;
        this.description = description;
        this.TransactionAmount = TransactionAmount;
        this.transferCustomerAccountId = transferCustomerAccountId;
        this.transferCustomerId = transferCustomerId;
        this.accountBalanceAfterTransaction = accountBalanceAfterTransaction;

    }



    public Transaction() {

    }

    public int getCustomerId() {
        return customerId;
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

    public float getAccountBalanceAfterTransaction() {
        return accountBalanceAfterTransaction;
    }

    public void setAccountBalanceAfterTransaction(float accountBalanceAfterTransaction) {
        this.accountBalanceAfterTransaction = accountBalanceAfterTransaction;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public String getDescription() {
        return description;
    }

    public boolean isTransfer() {
        return isTransfer;
    }


    public Boolean isDebit() {
        return isDebit;
    }


    public float getTransactionAmount() {
        return TransactionAmount;
    }

    public int getTransferCustomerId() {
        return transferCustomerId;
    }


    public int getTransferCustomerAccountId() {
        return transferCustomerAccountId;
    }

    public void setTransferCustomerAccountId(int transferCustomerAccountId) {
        this.transferCustomerAccountId = transferCustomerAccountId;
    }

}
