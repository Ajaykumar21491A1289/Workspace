package com.jocata.config;

import com.jocata.users.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {

    @Autowired
    private RestTemplate restTemplate;

    public boolean isUserValid(Long userId) {
        String url = "http://localhost:8080/USER-SERVICE/user/" + userId;

        ResponseEntity<UserForm> response = restTemplate.getForEntity(url, UserForm.class);

        return true;

    }
}