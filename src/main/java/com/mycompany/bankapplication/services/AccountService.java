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

    public Account getAccount(int customerId, int id) {

        return db.getCustomerAccounts(customerId).get(id - 1);
    }

    public Account addAccount(int customerId, Account account) {
        account.setAccountId(db.getCustomerAccounts(customerId).size() + 1);
        db.getCustomerAccounts(customerId).add(account);

        return account;
    }

    public void removeAccount(int customerId, int id) {
        db.getCustomerAccounts(customerId).remove(id - 1);
    }

    public Account updateAccountDetails(int customerId, int id, Account account) {
        account.setAccountId(id);
        db.getCustomerAccounts(customerId).set(id - 1, account);
        return account;
    }
}
