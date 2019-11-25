/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapplication.resources;

import com.mycompany.bankapplication.models.Account;
import com.mycompany.bankapplication.services.AccountService;
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
 *
 * @author The Young CEO
 */
@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {
    
    AccountService accountService = new AccountService();
    
    @GET
    public List<Account> getAccounts() {
        return accountService.getAllAccounts();
    }
    
    @POST
    public Account addAccount(Account account){
        return accountService.addAccount(account);
    }
        
    @DELETE
    @Path("/{accountId}")
    public void removeAccount(@PathParam("accountId") int id){
        accountService.removeAccount(id);
    }
    
    @PUT
    @Path("/{accountId}")
    public Account updateAccount(@PathParam("accountId") int id, Account account){
        account.setAccountId(id);
        return accountService.updateAccountDetails(account);
    }
    
    @GET
    @Path("/{accountId}")
    public Account getAccount(@PathParam("accountId") int id) {
        return accountService.getAccount(id);
    }
}
