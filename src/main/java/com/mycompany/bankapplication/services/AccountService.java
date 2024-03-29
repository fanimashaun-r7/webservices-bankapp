/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapplication.services;

import com.mycompany.bankapplication.database.Database;
import com.mycompany.bankapplication.models.Account;

import java.util.List;

/**
 * @author The Young CEO
 */
public class AccountService {

    Database db = new Database();

    public List<Account> getAllAccounts(int customerId) {
        return db.getCustomerAccounts(customerId);
    }

    public Account getAccount(int customerId, int accountId) {

        return db.getCustomerAccounts(customerId).get(accountId);
    }

    public Account addAccount(int customerId, Account account) {
        int accountId = db.getCustomerAccounts(customerId - 1).size() + 1;
        account.setAccountId(accountId);
        db.getCustomerAccounts(customerId - 1).add(account);

        return db.getCustomerAccounts(customerId - 1).get(accountId - 1 );
    }

    public void removeAccount(int customerId, int id) {
        db.getCustomerAccounts(customerId).remove(id);
        for(int i = 0; i<db.getCustomerAccounts(customerId).size(); i++){
            db.getCustomerAccounts(customerId).get(i).setAccountId(i+1);
        }
    }

    public Account updateAccountDetails(int customerId, int id, Account account) {
        account.setAccountId(id);
        db.getCustomerAccounts(customerId).set(id - 1, account);
        return account;
    }
}
