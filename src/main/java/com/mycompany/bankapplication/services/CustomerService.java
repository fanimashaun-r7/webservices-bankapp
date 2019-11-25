/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapplication.services;

import com.mycompany.bankapplication.models.Account;
import com.mycompany.bankapplication.models.Customer;
import com.mycompany.bankapplication.models.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author The Young CEO
 */
public class CustomerService {

    public static List<Customer> customers = new ArrayList<Customer>();

    public CustomerService() {
        Account account = new Account();
        AccountService as = new AccountService();
        List<Account> accounts = as.getAccountByCustID(1);
        accounts.add(account);


        
        Customer customer1 = new Customer(1, "Carol R. Springer", "3635 Tail Ends Road Redgranite, WI 54970", "CarolRSpringer@jourrapide.com", accounts);
        Customer customer2 = new Customer(2, "Tony C. Krantz", "2596 Pyramid Valley Road Guernsey, IA 50172", "TonyCKrantz@teleworm.us", accounts);
        Customer customer3 = new Customer(3, "Jessie J. Wood", "2047 Prudence Street Detroit, MI 48219", "JessieJWood@jourrapide.com", accounts);
        Customer customer4 = new Customer(4, "John D. Ramirez", "4341 Hill Croft Farm Road Sacramento, CA 95814", "JohnDRamirez@dayrep.com", accounts);

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public List<Customer> getCustomersByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        for (Customer c : getAllCustomers()) {
            if (name == null) {
                customerList.add(c);
            }
        }
        return customerList;
    }

    public Customer getCustomer(int id) {
        return customers.get(id - 1);
    }

    public Customer addCustomer(Customer customer) {
        customer.setCustomerId(customers.size() + 1);
        customers.add(customer);
        System.out.println("Customer of id " + customer.getCustomerId() + " was made!");

        return customer;
    }

    public void removeCustomer(int id) {
        customers.remove(id);
        System.out.println("Customer of id " + id + " was removed!");

    }

    public Customer updateCustomerDetails(Customer customer) {
        if (customer.getCustomerId() <= 0) {
            return null;
        }
        customers.add(customer);
        return customer;
    }

}
