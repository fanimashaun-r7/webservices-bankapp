/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapplication.services;

import com.mycompany.bankapplication.database.Database;
import com.mycompany.bankapplication.models.Transaction;
import java.util.List;

/**
 *
 * @author The Young CEO
 */
public class TransactionService {
    
    Database db = new Database(); 

    public List<Transaction> getAllTransactions(int accountId) {
        return db.getCustomerAccountTransactions(accountId);
    }

    public Transaction getTransaction(int accountId, int id) {
        return db.getCustomerAccountTransactions(accountId).get(id - 1);
    }

    public Transaction addTransaction(int accountId, Transaction transaction) {
        transaction.setTransactionId(db.getCustomerAccountTransactions(accountId).size() + 1);
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
