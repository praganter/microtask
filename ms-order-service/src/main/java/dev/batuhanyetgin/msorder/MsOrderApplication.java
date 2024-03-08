package dev.batuhanyetgin.msorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EntityScan(basePackages = {"dev.batuhanyetgin.msbookservice.entity", "dev.batuhanyetgin.msorder.entity", "dev.batuhanyetgin.mscustomer.entity"})
public class MsOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsOrderApplication.class, args);
    }

}
