package org.github.innovationforge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Value("${vob.url}")
    private String VOB_URL;

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .uri("http://httpbin.org:80"))
                .route(p -> p
                        .path("/api/msp/**")
                        .filters(f -> f.rewritePath("/api/msp(?<segment>/?.*)",
                                "${segment}"))
                        .uri(VOB_URL))
                .build();
    }
}
