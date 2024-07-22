package com.dcat23.loanmgmt.customers.controller;

import com.dcat23.loanmgmt.customers.dto.CustomerCreationDTO;
import com.dcat23.loanmgmt.customers.dto.CustomerUpdateDTO;
import com.dcat23.loanmgmt.customers.model.Customer;
import com.dcat23.loanmgmt.customers.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Customers",
        description = "REST APIs to CREATE, UPDATE, FETCH and DELETE Customers")
@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CustomerController {

    private final CustomerService customerService;

    @Operation(
                summary = "Create Customer",
                description = "REST API to create a Customer entity")
    @ApiResponse(
                responseCode = "201",
                description = "HTTP Status CREATED")
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody CustomerCreationDTO customerDTO) {
        Customer createdCustomer = customerService.createCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @Operation(
                summary = "Get Customer By Id",
                description = "REST API to fetch Customer by id")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @Operation(
                summary = "Update Customer",
                description = "REST API to update a Customer entity by id")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerUpdateDTO customerUpdateDTO) {
        Customer updatedCustomer = customerService.updateCustomer(id, customerUpdateDTO);
        return ResponseEntity.ok(updatedCustomer);
    }

    @Operation(
                summary = "Delete Customer",
                description = "REST API to delete a Customer entity")
    @ApiResponse(
                responseCode = "204",
                description = "HTTP Status NO CONTENT")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
                summary = "Search Customers",
                description = "REST API to find a Customer by name")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    @GetMapping("/search")
    public ResponseEntity<List<Customer>> searchCustomers(@RequestParam String name) {
        List<Customer> customers = customerService.searchCustomers(name);
        return ResponseEntity.ok(customers);
    }
}
