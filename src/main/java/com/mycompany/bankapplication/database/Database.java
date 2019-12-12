/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapplication.database;

import com.mycompany.bankapplication.models.Account;
import com.mycompany.bankapplication.models.Customer;
import com.mycompany.bankapplication.models.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author The Crazy CEO
 */
public class Database {

    public static List<Customer> customersDB = new ArrayList<Customer>();
    public static List<Account> accountsDB = new ArrayList<Account>();
    public static List<Transaction> transactionsDB = new ArrayList<Transaction>();
    public static List<Account> accountsDB1 = new ArrayList<Account>();
    public static List<Transaction> transactionsDB1 = new ArrayList<Transaction>();
    public static boolean init = true;

    public Database() {
        if (init) {
            //Transactions for customer 1 -- start
            Transaction transaction1 = new Transaction(transactionsDB.size() + 1,1, false ,true, new Date(), "Ice Cream", 5,(float)509);
            transactionsDB.add(transaction1);

            Transaction transaction2 = new Transaction(transactionsDB1.size() + 1,2, false,true, new Date(), "Birthday cake for dad", 25,  (float)595);
            transactionsDB1.add(transaction2);
//
//            Transaction transaction3 = new Transaction(transactionsDB.size() + 1,3,true, new Date(), "Playstation for brother", 450);
//            transactionsDB.add(transaction3);
//
//            Transaction transaction4 = new Transaction(transactionsDB.size() + 1,4,false, new Date(), "Coffee", 3);
//            transactionsDB.add(transaction4);
            //Transactions for customer 1 -- end

            //Accounts for customer 1 -- start
            Account account1 = new Account(accountsDB.size() + 1,"current" ,"B3635", "4532 5609  9765", (float) 509, transactionsDB);
            accountsDB.add(account1);

            Account account2 = new Account(accountsDB1.size() + 1,"savings" , "B87655", "5609 5609 6329 9765", (float) 595, transactionsDB1);
            accountsDB1.add(account2);

//            Account account3 = new Account(accountsDB.size() + 1, "savings" ,"B3652335", "5609  6329 6329", (float) 95.15, transactionsDB);
//            accountsDB.add(account3);
            //Accounts for customer 1 -- end

            //All the customers -- start
            Customer customer1 = new Customer(customersDB.size() + 1, "Carol R. Springer", "3635 Tail Ends Road Redgranite, WI 54970", "CarolRSpringer@jourrapide.com", "1234", accountsDB);
            customersDB.add(customer1);

            Customer customer2 = new Customer(customersDB.size() + 1, "Brooks Fairclough", "96 Coleman Plaza", "bfairclough0@dailymotion.com", "1234", accountsDB1);
            customersDB.add(customer2);
//
//            Customer customer3 = new Customer(customersDB.size() + 1, "Alicea Adlam", "92681 Oxford Way", "aadlam1@sun.com", "1234", accountsDB);
//            customersDB.add(customer3);
//
//            Customer customer4 = new Customer(customersDB.size() + 1, "Hilarius Breckenridge", "886 Bonner Terrace", "hbreckenridge2@ibm.com", "1234", accountsDB);
//            customersDB.add(customer4);
//
//            Customer customer5 = new Customer(customersDB.size() + 1, "Gilberto Izzatt", "4359 Michigan Street", "gizzatt3@paginegialle.it", "1234", accountsDB);
//            customersDB.add(customer5);
            //All the customers -- end
        }
        init = false;
    }

    public List<Customer> getCustomers() {
        return customersDB;
    }

    public void lodge(int custId,int accountId, float amount){
        float currentBal = getCustomerAccounts(custId).get(accountId).getCurrentBalance();
        getCustomerAccounts(custId).get(accountId).setCurrentBalance(currentBal + amount);
    }

    public void withdraw(int custId,int accountId, float amount){
        float currentBal = getCustomerAccounts(custId).get(accountId).getCurrentBalance();
        getCustomerAccounts(custId).get(accountId).setCurrentBalance(currentBal - amount);
    }

    public List<Account> getCustomerAccounts(int customerNo) {
        return customersDB.get(customerNo).getAccounts();
    }


    public List<Transaction> getCustomerAccountTransactions(int customerNo, int accountNo) {
        return customersDB.get(customerNo).getAccounts().get(accountNo).getTransactions();
    }
}
