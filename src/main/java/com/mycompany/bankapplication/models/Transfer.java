package com.mycompany.bankapplication.models;

import java.util.Date;

public class Transfer extends Transaction {
    private int transferCustomerId;
    private int transferCustomerAccountId;


    public Transfer(int transferCustomerId, int TransferCustomerAccountId,int transactionId, int customerId, Boolean isDebit, Date dateOfTranaction, String description, float TransactionAmount) {
        super(transactionId, customerId, isDebit, dateOfTranaction, description, TransactionAmount);
        this.transferCustomerAccountId = TransferCustomerAccountId;
        this.transferCustomerId = transferCustomerId;
    }

    public int getTransferCustomerId() {
        return transferCustomerId;
    }

    public void setTransferCustomerId(int transferCustomerId) {
        this.transferCustomerId = transferCustomerId;
    }

    public int getTransferCustomerAccountId() {
        return transferCustomerAccountId;
    }

    public void setTransferCustomerAccountId(int transferCustomerAccountId) {
        this.transferCustomerAccountId = transferCustomerAccountId;
    }
}
