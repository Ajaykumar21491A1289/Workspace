package com.jocata.oms.service;

import com.jocata.oms.dto.UserDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CustomReactiveUserDetailsService implements ReactiveUserDetailsService {

    private final WebClient webClient;

    @Autowired
    public CustomReactiveUserDetailsService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {

        System.out.println("In CustomReactiveUserDetailsService");
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host("localhost")
                        .port(8081)
                        .path("/user-service/auth/user")
                        .queryParam("username", username)  // Correctly passing as query param
                        .build())
                .retrieve()
                .bodyToMono(UserDetailsDTO.class)
                .map(this::convertToUserDetails)
                .doOnSuccess(user ->
                        System.out.println("✅ User details loaded: " + user.getUsername()))
                .doOnError(error ->
                        System.out.println("❌ Error fetching user details: " + error.getMessage()));
    }

    private UserDetails convertToUserDetails(UserDetailsDTO dto) {
        return User.withUsername(dto.getUsername())
                .password(dto.getPassword())
                .authorities(dto.getRoles().stream().map(role -> role).toArray(String[]::new))
                .build();
    }
}
