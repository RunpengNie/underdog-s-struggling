package com.TheTroisMousquetaires.Underdogs.Struggling.service.impl;

import com.TheTroisMousquetaires.Underdogs.Struggling.dao.RoleRepository;
import com.TheTroisMousquetaires.Underdogs.Struggling.dao.UserRepository;
import com.TheTroisMousquetaires.Underdogs.Struggling.entity.Role;
import com.TheTroisMousquetaires.Underdogs.Struggling.entity.User;
import com.TheTroisMousquetaires.Underdogs.Struggling.payload.security.LoginDto;
import com.TheTroisMousquetaires.Underdogs.Struggling.payload.security.RegisterDto;
import com.TheTroisMousquetaires.Underdogs.Struggling.security.JwtTokenProvider;
import com.TheTroisMousquetaires.Underdogs.Struggling.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;
    private RoleRepository roleRepository;

    public AuthServiceImpl(
            JwtTokenProvider jwtTokenProvider,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            RoleRepository roleRepository,
            AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {
        var token = new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        System.out.println("success!!!!");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenProvider.generateToken(authentication);
    }

    @Override
    public String register(RegisterDto registerDto) {
        if (userRepository.findUserByEmail(registerDto.getEmail()).isPresent()) {
            throw new RuntimeException("User with this email already exists");
        }

        Optional<Role> userRole = roleRepository.findRoleByRoleID(5);
        if (userRole.isEmpty()) {
            throw new RuntimeException("Default role general_user is not found");
        }

        User newUser = new User(4, registerDto.getEmail(), registerDto.getUserName(), passwordEncoder.encode(registerDto.getPassword()), userRole.get());

        userRepository.save(newUser);

        var token = new UsernamePasswordAuthenticationToken(registerDto.getEmail(), registerDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenProvider.generateToken(authentication);
    }
}
