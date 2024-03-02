package dev.batuhanyetgin.mseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
public class MsEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsEurekaServerApplication.class, args);
    }

}
