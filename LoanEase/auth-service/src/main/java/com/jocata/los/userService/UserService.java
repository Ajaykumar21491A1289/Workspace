package com.jocata.los.userService;

import com.jocata.los.datamodel.user.form.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    public UserProfile setUserService(UserProfile profile){
        String url="http://localhost:8080/users/register";
        ResponseEntity<UserProfile> responseEntity=restTemplate.postForEntity(url,profile, UserProfile.class);
        return responseEntity.getBody();
    }

}
