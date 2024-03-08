package dev.batuhanyetgin.msorder.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-security-service", path = "/v1/auth")
public interface SecurityServiceClient {

    String getEmailFromToken(@PathVariable String token);
}
