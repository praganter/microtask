package dev.batuhanyetgin.mscustomer.controller;


import dev.batuhanyetgin.mscustomer.dto.CustomerDto;
import dev.batuhanyetgin.mscustomer.dto.RegisterDto;
import dev.batuhanyetgin.mscustomer.exception.UserNotFoundException;
import dev.batuhanyetgin.mscustomer.service.abstruct.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerDto>> getAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @PostMapping("/create")
    private ResponseEntity<String> createCustomer(@RequestBody @Valid RegisterDto customerDto) {
        customerService.createCustomer(customerDto);

        return ResponseEntity.ok("En azından çalıştım." + customerDto);
    }

    @GetMapping("/getByMail/{email}")
    public CustomerDto getByMail(@PathVariable String email) throws UserNotFoundException {
        return customerService.getByEmail(email);
    }


    @GetMapping("/isCustomerExist/{email}")
    private boolean isCustomerExist(@PathVariable String email) {
        return customerService.isCustomerExist(email);
    }
}
