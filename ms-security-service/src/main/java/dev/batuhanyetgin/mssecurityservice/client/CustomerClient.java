package dev.batuhanyetgin.mssecurityservice.client;

import dev.batuhanyetgin.mssecurityservice.dto.CustomerDto;
import dev.batuhanyetgin.mssecurityservice.dto.RegisterDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-customer-service", path = "/v1/customer")
public interface CustomerClient {

    @GetMapping("/isCustomerExist/{email}")
    boolean isCustomerExist(@PathVariable String email);

    @PostMapping("/create")
    ResponseEntity<String> createCustomer(@RequestBody @Valid RegisterDto customerDto);


    @GetMapping("/getByMail/{email}")
    CustomerDto getByMail(@PathVariable String email);


}
