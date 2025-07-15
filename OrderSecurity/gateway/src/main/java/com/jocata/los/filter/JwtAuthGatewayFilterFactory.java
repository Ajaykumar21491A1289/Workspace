package com.jocata.los.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
public class JwtAuthGatewayFilterFactory extends AbstractGatewayFilterFactory<JwtAuthGatewayFilterFactory.Config> {

    private final String SECRET_KEY = "ajay";

    public JwtAuthGatewayFilterFactory() {
        super(Config.class);
    }

    public GatewayFilter apply(Config config){

        return (exchange,chain)->{
            String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

            if(authHeader == null || !authHeader.startsWith("Bearer ")){
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            String token = authHeader.substring(7);
            String role = getRoleFromToken(token);
            String username = getUsernameFromToken(token);
            try{
                Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
                exchange = exchange.mutate()
                        .request(builder->builder
                                .header("X-User",username)
                                .header("X-Role",role))
                        .build();
                return chain.filter(exchange);
            }catch (SignatureException e){
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
        };
    }

    public static class Config{}

    private String getUsernameFromToken(String token) {
       return extractAllClaims(token).getSubject();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

    }

    private String getRoleFromToken(String token) {
        Claims claims =extractAllClaims(token);
        return claims.get("role",String.class);
    }


}