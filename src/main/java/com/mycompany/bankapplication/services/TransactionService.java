/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapplication.services;

import com.mycompany.bankapplication.database.Database;
import com.mycompany.bankapplication.models.Customer;
import com.mycompany.bankapplication.models.Transaction;

import java.time.LocalDateTime;
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

    public List<Transaction> getAllTransactions(int accountId) {
        return db.getCustomerAccountTransactions(accountId);
    }

    public Transaction getTransaction(int accountId, int id) {
        return db.getCustomerAccountTransactions(accountId).get(id - 1);
    }

    public Transaction transferMoney(int accountId, Transaction transfer){
        List <Customer> customers = cust.getAllCustomers();
        int custId = transfer.getCustomerId()-1;
        int transCustId = transfer.getTransferCustomerId()-1;
        int transAccId = transfer.getTransferCustomerAccountId() -1;

        db.withdraw(custId ,accountId, transfer.getTransactionAmount());
        db.lodge(transCustId,transAccId, transfer.getTransactionAmount());
        transfer.setTransactionId(db.getCustomerAccountTransactions(accountId).size() + 1);
        transfer.setAccountBalanceAfterTransaction(db.getCustomerAccounts(custId).get(accountId).getCurrentBalance());
        db.getCustomerAccountTransactions(accountId).add(transfer);

        return transfer;
    }

    public Transaction addTransaction(int accountId, Transaction transaction) {
        transaction.setTransactionId(db.getCustomerAccountTransactions(accountId).size() + 1);

        transaction.setDateOfTransaction(new Date());
        if(transaction.getIsDebit()){
            db.withdraw(transaction.getCustomerId()-1,accountId, transaction.getTransactionAmount());
        }else{
            db.lodge(transaction.getCustomerId()-1,accountId, transaction.getTransactionAmount());
        }
        transaction.setAccountBalanceAfterTransaction(db.getCustomerAccounts(transaction.getCustomerId()-1).get(accountId).getCurrentBalance());
        db.getCustomerAccountTransactions(accountId).add(transaction);
        System.out.println("Transaction of id " + transaction.getTransactionId() + " was made!");

        return transaction;
    }

    public void removeTransaction(int accountId, int id) {
        db.getCustomerAccountTransactions(accountId).remove(id);
        System.out.println("Transaction of id " + id + " was removed!");

    }

    public Transaction updateTransactionDetails(int accountId, int id, Transaction transaction) {
        transaction.setTransactionId(id);
        db.getCustomerAccountTransactions(accountId).set(id - 1, transaction);
        return transaction;
    }
}
