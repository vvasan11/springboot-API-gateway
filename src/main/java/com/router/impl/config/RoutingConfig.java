package com.router.impl.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/employee/**")
                        .filters(f-> f.setRequestHeader("author","varsha"))
                        .uri("http://localhost:8081/")
                        )

                .route(r -> r.path("/consumer/**")
                        .uri("http://localhost:8082/"))

                .build();

    }
}
