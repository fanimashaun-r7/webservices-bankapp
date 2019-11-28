/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapplication.services;

import com.mycompany.bankapplication.database.Database;
import com.mycompany.bankapplication.models.Customer;

import java.util.List;

/**
 * @author The Young CEO
 */
public class CustomerService {

    Database db = new Database();

    public List<Customer> getAllCustomers() {
        return db.getCustomers();
    }

    public Customer getCustomerById(int id) {
        return db.getCustomers().get(id - 1);
    }

    public Customer addCustomer(Customer customer) {
        customer.setCustomerId(db.getCustomers().size() + 1);
        db.getCustomers().add(customer);

        return customer;
    }

    public void removeCustomer(int id) {
        db.getCustomers().remove(id - 1);
    }

    public Customer updateCustomerDetails(int id, Customer customer) {
        customer.setCustomerId(id);
        db.getCustomers().set(id - 1, customer);
        return customer;
    }
}
