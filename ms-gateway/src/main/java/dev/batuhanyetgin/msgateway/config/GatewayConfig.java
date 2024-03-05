package dev.batuhanyetgin.msgateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

    private final AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("ms-customer-service", r -> r.path("/v1/customer/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://ms-customer-service"))
                .route("ms-security-service", r -> r.path("/v1/auth/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://ms-security-service"))
                .build();
    }

    @Bean
    public HttpMessageConverters customConverters() {
        return new HttpMessageConverters();
    }
}