package dev.batuhanyetgin.msorder.client;

import dev.batuhanyetgin.msorder.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "ms-customer-service", path = "/v1/customer")
public interface CustomerServiceClient {
    @GetMapping("/getByMail/{email}")
    CustomerDto getByMail(@PathVariable String email);
}
