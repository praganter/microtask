package dev.batuhanyetgin.mscustomer.controller;


import dev.batuhanyetgin.mscustomer.dto.CreateCustomerDto;
import dev.batuhanyetgin.mscustomer.dto.CustomerDto;
import dev.batuhanyetgin.mscustomer.service.abstruct.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(CreateCustomerDto customerDto){
        customerService.createCustomer(customerDto);

        return ResponseEntity.ok("En azından çalıştım." + customerDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerDto>> getAllCustomer(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
}
