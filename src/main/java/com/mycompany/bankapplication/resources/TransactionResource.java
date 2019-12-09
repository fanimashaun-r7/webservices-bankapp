/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapplication.resources;

import com.mycompany.bankapplication.models.Transaction;
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
 *
 * @author The Young CEO
 */
@Path("/transactions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransactionResource {
    
    private TransactionService transactionService = new TransactionService();

    @GET
    public List<Transaction> getTransactions(@PathParam("accountId") int accountId) {
        return transactionService.getAllTransactions(accountId);
    }

    @GET
    @Path("/{transactionId}")
    public Transaction getAccount(@PathParam("accountId") int accountId, @PathParam("transactionId") int transactionId) {
        return transactionService.getTransaction(accountId, transactionId);
    }

    @POST
    public Transaction addTransaction(@PathParam("accountId") int accountId, Transaction transaction){
        accountId = accountId-1;
        if(transaction.isTransfer()) {
            return transactionService.transferMoney(accountId, transaction);
        }else{
            return transactionService.addTransaction(accountId, transaction);
        }
    }




    @DELETE
    @Path("/{transactionId}")
    public void removeTransaction(@PathParam("transactionId") int transactionId, int id){
        transactionService.removeTransaction(transactionId, id);
    }

    @PUT
    @Path("/{transactionId}")
    public Transaction updateTransaction(@PathParam("accountId") int accountId, @PathParam("transactionId") int id, Transaction transaction){
        transaction.setTransactionId(id);
        return transactionService.updateTransactionDetails(accountId, id, transaction);
    }

}