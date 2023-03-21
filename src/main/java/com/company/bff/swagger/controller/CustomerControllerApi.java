package com.company.bff.swagger.controller;

import com.company.bff.swagger.api.CustomerApi;
import com.company.bff.swagger.domain.Customer;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerControllerApi implements CustomerApi {

    @Override
    public ResponseEntity<List<Customer>> getCustomers() {

        Customer jose = Customer.builder().name("jose").phone("552199999999").id(1l).build();
        Customer joao = Customer.builder().name("joao").phone("552199997777").id(2l).build();

        List<Customer> list = Arrays.asList(jose, joao);
        return ResponseEntity.ok(list);
    }

}
