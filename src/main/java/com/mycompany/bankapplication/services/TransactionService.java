/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapplication.services;

import com.mycompany.bankapplication.models.Transaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author The Young CEO
 */
public class TransactionService {
        public static List<Transaction> transactions = new ArrayList<>();

    public TransactionService() {

        Transaction transaction1 = new Transaction(1, true, false, new Date(), "Ice Cream", (float) 1095.45);
        Transaction transaction2 = new Transaction(2, false, true, new Date(), "Birthday cake for dad", (float) 2490.19);
        Transaction transaction3 = new Transaction(3, false, true, new Date(), "Playstation for brother", (float) 4600.00);
        Transaction transaction4 = new Transaction(4, true, false, new Date(), "Coffee", (float) 7497.62);

        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    public Transaction getTransaction(int id) {
        return transactions.get(id - 1);
    }

    public Transaction addTransaction(Transaction transaction) {
        transaction.setTransactionId(transactions.size() + 1);
        transactions.add(transaction);
        System.out.println("Transaction of id " + transaction.getTransactionId() + " was made!");

        return transaction;
    }

    public void removeTransaction(int id) {
        transactions.remove(id);
        System.out.println("Transaction of id " + id + " was removed!");

    }

    public Transaction updateTransactionDetails(Transaction transaction) {
        if (transaction.getTransactionId() <= 0) {
            return null;
        }
        transactions.add(transaction);
        return transaction;
    }
}
