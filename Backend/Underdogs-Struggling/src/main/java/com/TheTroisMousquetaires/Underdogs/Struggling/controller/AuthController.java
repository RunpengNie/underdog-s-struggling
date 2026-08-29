package com.TheTroisMousquetaires.Underdogs.Struggling.controller;

import com.TheTroisMousquetaires.Underdogs.Struggling.payload.security.RegisterDto;
import lombok.AllArgsConstructor;
import com.TheTroisMousquetaires.Underdogs.Struggling.payload.security.JWTAuthResponse;
import com.TheTroisMousquetaires.Underdogs.Struggling.payload.security.LoginDto;
import com.TheTroisMousquetaires.Underdogs.Struggling.service.AuthService;
import org.hibernate.cache.spi.support.RegionNameQualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    // Login REST API
    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> authenticate(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse(token);
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Register REST API
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        String token = authService.register(registerDto);
        return ResponseEntity.ok("User registered successfully with token: " + token);
    }
}