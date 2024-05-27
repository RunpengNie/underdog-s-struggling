package com.TheTroisMousquetaires.Underdogs.Struggling.controller;

import com.TheTroisMousquetaires.Underdogs.Struggling.payload.security.JWTAuthResponse;
import com.TheTroisMousquetaires.Underdogs.Struggling.payload.security.LoginDto;
import com.TheTroisMousquetaires.Underdogs.Struggling.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    // Login REST API
    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> authenticate(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }
}