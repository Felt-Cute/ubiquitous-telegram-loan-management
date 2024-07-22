package com.dcat23.loanmgmt.customers.service;

import com.dcat23.loanmgmt.customers.dto.CustomerCreationDTO;
import com.dcat23.loanmgmt.customers.dto.CustomerUpdateDTO;
import com.dcat23.loanmgmt.customers.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Override
    public Customer createCustomer(CustomerCreationDTO customerDTO) {
        return null;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return null;
    }

    @Override
    public Customer updateCustomer(Long id, CustomerUpdateDTO customerUpdateDTO) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }

    @Override
    public List<Customer> searchCustomers(String name) {
        return List.of();
    }
}
