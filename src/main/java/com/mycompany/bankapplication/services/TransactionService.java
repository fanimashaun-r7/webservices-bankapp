/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapplication.services;

import com.mycompany.bankapplication.database.Database;
import com.mycompany.bankapplication.models.Customer;
import com.mycompany.bankapplication.models.Transaction;


import java.util.Date;
import java.util.List;

/**
 *
 * @author The Grumpy CEO
 */
//todo add current time for transactions
public class TransactionService {
    
    Database db = new Database();
    CustomerService cust = new CustomerService();

    public List<Transaction> getAllTransactions(int customerId, int accountId) {
        return db.getCustomers().get(customerId).getAccounts().get(accountId).getTransactions();
    }

    public Transaction getTransaction(int customerId ,int accountId, int id) {
        return db.getCustomers().get(customerId).getAccounts().get(accountId).getTransactions().get(id);
    }

    public Transaction transferMoney(int accountId, Transaction transfer){
        List <Customer> customers = cust.getAllCustomers();
        int custId = transfer.getCustomerId()-1;
        int transCustId = transfer.getTransferCustomerId()-1;
        int transAccId = transfer.getTransferCustomerAccountId() -1;

        db.withdraw(custId ,accountId, transfer.getTransactionAmount());
        db.lodge(transCustId,transAccId, transfer.getTransactionAmount());
        transfer.setTransactionId(db.getCustomerAccountTransactions(custId,accountId).size() + 1);
        transfer.setAccountBalanceAfterTransaction(db.getCustomerAccounts(custId).get(accountId).getCurrentBalance());
        transfer.setDateOfTransaction(new Date());
        db.getCustomerAccountTransactions(custId,accountId).add(transfer);

        return transfer;
    }

    public Transaction addTransaction(int accountId, Transaction transaction) {
        int custId = transaction.getCustomerId()-1;
        transaction.setTransactionId(db.getCustomerAccountTransactions(custId,accountId).size() + 1);

        transaction.setDateOfTransaction(new Date());
        if(transaction.getIsDebit()){
            db.withdraw(transaction.getCustomerId()-1,accountId, transaction.getTransactionAmount());
        }else{
            db.lodge(transaction.getCustomerId()-1,accountId, transaction.getTransactionAmount());
        }
        transaction.setAccountBalanceAfterTransaction(db.getCustomerAccounts(transaction.getCustomerId()-1).get(accountId).getCurrentBalance());
        db.getCustomerAccountTransactions(custId,accountId).add(transaction);
        System.out.println("Transaction of id " + transaction.getTransactionId() + " was made!");

        return transaction;
    }

    public void removeTransaction(int custId, int accountId, int id) {
        db.getCustomerAccountTransactions(custId,accountId).remove(id);
        for(int i = 0; i < db.getCustomerAccountTransactions(custId,accountId).size(); i ++){
            db.getCustomerAccountTransactions(custId,accountId).get(i).setTransactionId(i+1);
        }
        System.out.println("Transaction of id " + id + " was removed!");

    }

    public Transaction updateTransactionDetails(int accountId, int id, Transaction transaction) {
        transaction.setTransactionId(id);
        int custId = transaction.getCustomerId() - 1;
        if(transaction.isTransfer()){
            List <Customer> customers = cust.getAllCustomers();
            db.withdraw(transaction.getCustomerId() - 1 ,accountId, transaction.getTransactionAmount());
            db.lodge(transaction.getTransferCustomerId() - 1,transaction.getTransferCustomerAccountId() -1, transaction.getTransactionAmount());
            transaction.setTransactionId(db.getCustomerAccountTransactions(custId,accountId).size() + 1);
            transaction.setAccountBalanceAfterTransaction(db.getCustomerAccounts(transaction.getCustomerId() - 1).get(accountId).getCurrentBalance());
        }else {
            float currentBAL;
            if (transaction.getIsDebit()) {
                currentBAL = db.getCustomers().get(transaction.getCustomerId() - 1).getAccounts().get(accountId).getCurrentBalance() - transaction.getTransactionAmount();
            } else {
                currentBAL = db.getCustomers().get(transaction.getCustomerId() - 1).getAccounts().get(accountId).getCurrentBalance() + transaction.getTransactionAmount();
            }
            db.getCustomers().get(transaction.getCustomerId() - 1).getAccounts().get(accountId).setCurrentBalance(currentBAL);
            transaction.setAccountBalanceAfterTransaction(currentBAL);
        }
        db.getCustomerAccountTransactions(custId,accountId).set(id, transaction);
        return transaction;
    }
}
