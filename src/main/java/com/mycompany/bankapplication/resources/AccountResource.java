/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapplication.resources;

import com.mycompany.bankapplication.models.Account;
import com.mycompany.bankapplication.models.Transaction;
import com.mycompany.bankapplication.services.AccountService;
import com.mycompany.bankapplication.services.TransactionService;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author The Young CEO
 */
@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {

    private AccountService accountService = new AccountService();


    @GET
    public List<Account> getAccounts(@PathParam("customerId") int id) {
        return accountService.getAllAccounts(id);
    }

    @POST
    public Account addAccount(@PathParam("customerId") int id, Account account) {
        return accountService.addAccount(id, account);
    }

    @DELETE
    @Path("/{accountId}")
    public void removeAccount(@PathParam("customerId") int id, @PathParam("accountId") int accountId) {
        accountService.removeAccount(id, accountId);
    }

    @PUT
    @Path("/{accountId}")
    public Account updateAccount(@PathParam("customerId") int id, @PathParam("accountId") int accountId, Account account) {
        return accountService.updateAccountDetails(id, accountId, account);
    }

    @GET
    @Path("/{accountId}")
    public Account getAccount(@PathParam("customerId") int id, @PathParam("accountId") int accountId) {
        Account custAcc = accountService.getAccount(id, accountId);
        return custAcc;

    }

    @Path("/{accountId}/transactions")
    public TransactionResource getCustomerAccountTransactions() {
        return new TransactionResource();
    }



}
