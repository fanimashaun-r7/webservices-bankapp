package com.mycompany.bankapplication.models;

import java.util.Date;

public class Transfer extends Transaction {
    private int transferCustomerId;
    private int transferCustomerAccountId;

    public Transfer(int transferCustomerId, int TransferCustomerAccountId) {
        this.transferCustomerAccountId = transferCustomerAccountId;
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
