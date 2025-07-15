package com.jocata.los.authservice.service;

import com.jocata.los.datamodel.auth.form.AuthRequest;
import com.jocata.los.datamodel.auth.form.AuthResponse;
import com.jocata.los.datamodel.user.form.UserProfile;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthService {

    ResponseEntity<?> register(UserProfile userProfile);

    String validateUser(AuthRequest request);
}
