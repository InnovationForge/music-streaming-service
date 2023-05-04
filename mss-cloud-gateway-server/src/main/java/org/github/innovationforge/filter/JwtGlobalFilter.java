package org.github.innovationforge.filter;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.nimbusds.jose.JOSEException;
import org.github.innovationforge.service.AuthHeaderStubService;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@AllArgsConstructor
public class JwtGlobalFilter implements GlobalFilter {
    private AuthHeaderStubService authHeaderStubService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        try {
            ServerHttpRequest request = exchange.getRequest().mutate().
                    header("x-auth-user", authHeaderStubService.createAuthHeader()).
                    header("X-Forwarded-Client-Cert", "Hash=blablabla;CN=example.com").
                    build();
            log.info("Edge router added x-auth-user to the request: " + request.getPath());
        } catch (JOSEException e) {
            log.error(e.getMessage());
        }
        return chain.filter(exchange);
    }
}
