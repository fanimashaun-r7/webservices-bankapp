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
    
    TransactionService transactionService = new TransactionService();
    
    @GET
    public List<Transaction> getTransactions() {
        return transactionService.getAllTransactions();
    }
    
    @POST
    public Transaction addTransaction(Transaction transaction){
        return transactionService.addTransaction(transaction);
    }
        
    @DELETE
    @Path("/{transactionId}")
    public void removeTransaction(@PathParam("transactionId") int id){
        transactionService.removeTransaction(id);
    }
    
    @PUT
    @Path("/{transactionId}")
    public Transaction updateTransaction(@PathParam("transactionId") int id, Transaction transaction){
        transaction.setTransactionId(id);
        return transactionService.updateTransactionDetails(transaction);
    }
    
    @GET
    @Path("/{transactionId}")
    public Transaction getTransaction(@PathParam("transactionId") int id) {
        return transactionService.getTransaction(id);
    }
}