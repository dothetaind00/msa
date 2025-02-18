package org.interview.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator msaRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/msa/order/**")
                        .filters(f -> f.rewritePath("/msa/order/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                .circuitBreaker(config -> config.setName("orderCircuitBreaker").setFallbackUri("forward:/contact-support")))
                        .uri("lb://ORDER"))
                .route(p -> p
                        .path("/msa/payment/**")
                        .filters(f -> f.rewritePath("/msa/payment/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://PAYMENT"))
                .route(p -> p
                        .path("/msa/restaurant/**")
                        .filters(f -> f.rewritePath("/msa/restaurant/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://RESTAURANT"))
                .route(p -> p
                        .path("/msa/delivery/**")
                        .filters(f -> f.rewritePath("/msa/delivery/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://DELIVERY"))
                .build();
    }

}
