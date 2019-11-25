/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapplication.services;

import com.mycompany.bankapplication.models.Account;
import com.mycompany.bankapplication.models.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author The Young CEO
 */
public class AccountService {

    public static List<Account> accounts = new ArrayList<>();

    public AccountService() {
        Transaction transaction = new Transaction();
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction);
        
        Account account1 = new Account(1,1, "B3635", "4532 5609 6329 9765", (float) 5095.45, transactions);
        Account account2 = new Account(2,1, "B2596", "5290 6417 4982 0568", (float) 2990.19, transactions);
        Account account3 = new Account(3,1, "B2047", "5480 5166 4457 6830", (float) 4612.88, transactions);
        Account account4 = new Account(4,1, "B4341", "4916 8214 4583 7770", (float) 7797.62, transactions);

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }
    
    public List<Account> getAccountByCustID(int custID){
        List<Account> accounts1 = new ArrayList<Account>();
        for(int i=0; i<accounts.size();i++){
            Account temp = accounts.get(i);
            if(temp.getCustID()==custID){
                accounts1.add(temp);
            }
        }
        return accounts1;
    }

    public Account getAccount(int id) {
        return accounts.get(id - 1);
    }
    

    public Account addAccount(Account account) {
        account.setAccountId(accounts.size() + 1);
        accounts.add(account);
        System.out.println("Account of id " + account.getAccountId() + " was made!");

        return account;
    }

    public void removeAccount(int id) {
        accounts.remove(id);
        System.out.println("Account of id " + id + " was removed!");

    }

    public Account updateAccountDetails(Account account) {
        if (account.getAccountId() <= 0) {
            return null;
        }
        accounts.add(account);
        return account;
    }
}
