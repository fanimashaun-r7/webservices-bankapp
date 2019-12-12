/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapplication.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author The Young CEO
 */
public class Account {

    private int accountId;
    private String accountType;
    private String sortCode;
    private String accountNo;
    private float currentBalance;
    private List<Transaction> transactions = new ArrayList<>();
    

    public Account() {
    }

    public Account(int accountId, String accountType, String sortCode, String accountNo, float currentBalance, List<Transaction> transactions) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.sortCode = sortCode;
        this.accountNo = accountNo;
        this.currentBalance = currentBalance;
        this.transactions = transactions;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(float currentBalance) {
        this.currentBalance = currentBalance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
