package com.dcat23.loanmgmt.customers.service;

import com.dcat23.loanmgmt.customers.dto.CustomerCreationDTO;
import com.dcat23.loanmgmt.customers.dto.CustomerUpdateDTO;
import com.dcat23.loanmgmt.customers.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(CustomerCreationDTO customerDTO);

    Customer getCustomerById(Long id);

    Customer updateCustomer(Long id, CustomerUpdateDTO customerUpdateDTO);

    void deleteCustomer(Long id);

    List<Customer> searchCustomers(String name);
}
