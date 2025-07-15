package com.jocata.oms.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Component
public class CustomAuthenticationConverter implements ServerAuthenticationConverter {

    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {

        System.out.println("In CustomAuthenticationConverter");
        List<String> authHeaders = exchange.getRequest().getHeaders().get("Authorization");
        if (authHeaders == null || authHeaders.isEmpty()) {
            return Mono.empty();
        }

        String authHeader = authHeaders.get(0);
        if (!authHeader.startsWith("Basic ")) {
            return Mono.empty(); // Not Basic Authentication
        }

        String base64Credentials = authHeader.substring(6);

        byte[] decodedBytes;
        try {
            decodedBytes = Base64.getDecoder().decode(base64Credentials);
        } catch (IllegalArgumentException e) {
            return Mono.empty(); // Invalid Base64 encoding
        }

        String decodedCredentials = new String(decodedBytes, StandardCharsets.UTF_8);

        String[] credentials = decodedCredentials.split(":", 2);
        if (credentials.length != 2) {
            return Mono.empty();
        }

        String username = credentials[0];
        String password = credentials[1];

        return Mono.just(new UsernamePasswordAuthenticationToken(username, password));
    }




    /*@Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        return Mono.justOrEmpty(exchange.getRequest().getHeaders().get("Authorization"))
                .filter(authHeaders -> !authHeaders.isEmpty())
                .map(authHeaders -> authHeaders.get(0)) // Get first header value
                .filter(authHeader -> authHeader.startsWith("Basic "))
                .map(authHeader -> authHeader.substring(6)) // Remove "Basic " prefix
                .map(Base64.getDecoder()::decode) // Decode Base64
                .map(decodedBytes -> new String(decodedBytes, StandardCharsets.UTF_8)) // Convert to string
                .map(credentials -> credentials.split(":", 2)) // Split username:password
                .filter(parts -> parts.length == 2)
                .map(parts -> new UsernamePasswordAuthenticationToken(parts[0], parts[1])); // Create Authentication Token
    }*/

    /*@Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {

        return exchange.getRequest().getBody()
                .next()
                .flatMap(dataBuffer -> {
                    try {
                        byte[] bytes = new byte[dataBuffer.readableByteCount()];
                        dataBuffer.read(bytes);
                        String body = new String(bytes, StandardCharsets.UTF_8);
                        Map credentials = new ObjectMapper().readValue(body, Map.class);
                        String username = (String) credentials.get("username");
                        String password = (String) credentials.get("password");
                        return Mono.just(new UsernamePasswordAuthenticationToken(username, password));
                    } catch (Exception e) {
                        return Mono.error(new BadCredentialsException("Invalid authentication request"));
                    }
                });
    }*/
}
