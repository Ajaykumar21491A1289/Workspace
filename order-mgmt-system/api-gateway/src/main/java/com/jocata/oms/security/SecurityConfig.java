package com.jocata.oms.security;

import com.jocata.oms.service.CustomAuthenticationConverter;
import com.jocata.oms.service.CustomReactiveAuthenticationManager;
import com.jocata.oms.service.CustomSecurityContextRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    private final CustomReactiveAuthenticationManager authenticationManager;
    private final CustomSecurityContextRepository securityContextRepository;
    private final CustomAuthenticationConverter authenticationConverter;

    public SecurityConfig(@Lazy CustomReactiveAuthenticationManager authenticationManager,
                          CustomSecurityContextRepository securityContextRepository,
                          CustomAuthenticationConverter authenticationConverter) {
        this.authenticationManager = authenticationManager;
        this.securityContextRepository = securityContextRepository;
        this.authenticationConverter = authenticationConverter;
    }

    @Bean
    public AuthenticationWebFilter authenticationWebFilter() {

        System.out.println("In AuthenticationWebFilter");
        AuthenticationWebFilter authFilter = new AuthenticationWebFilter(authenticationManager);
        authFilter.setServerAuthenticationConverter(authenticationConverter);
        authFilter.setSecurityContextRepository(securityContextRepository);
        return authFilter;
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http,
                    AuthenticationWebFilter authenticationWebFilter) {

        System.out.println("In SecurityWebFilterChain");
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(auth -> auth
                        .pathMatchers("/user-service/auth/user").permitAll()
                        .pathMatchers("/user-service/api/user/**").
                                hasAnyAuthority("ADMIN", "USER")
                        .pathMatchers("/user-service/api/admin/**").hasAuthority("ADMIN")
                .anyExchange().authenticated())
                .addFilterAfter(authenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
