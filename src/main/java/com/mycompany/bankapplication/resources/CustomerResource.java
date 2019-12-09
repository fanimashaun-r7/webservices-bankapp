/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapplication.resources;

import com.mycompany.bankapplication.models.Customer;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mycompany.bankapplication.services.CustomerService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

/**
 *
 * @author The Young CEO
 */
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private CustomerService customerService = new CustomerService();

    @GET
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @POST
    public Customer addCustomer(Customer customer) {
        return customerService.addCustomer(customer);
    }

    @DELETE
    @Path("/{customerId}")
    public void removeCustomer(@PathParam("customerId") int id) {
        customerService.removeCustomer(id);
    }

    @PUT
    @Path("/{customerId}")
    public Customer updateCustomer(@PathParam("customerId") int id, Customer customer) {
        return customerService.updateCustomerDetails(id, customer);
    }

    @GET
    @Path("/{customerId}")
    public Customer getCustomer(@PathParam("customerId") int id) {
        Customer customer =  customerService.getCustomerById(id);
        return customer;
    }

    @Path("/{customerId}/accounts")
    public AccountResource getCustomerAccounts() {
        return new AccountResource();
    }
}
