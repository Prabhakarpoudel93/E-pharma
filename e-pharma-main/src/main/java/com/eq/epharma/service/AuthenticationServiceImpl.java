package com.eq.epharma.service;

import com.eq.epharma.config.JwtService;
import com.eq.epharma.dto.AuthenticationReqDto;
import com.eq.epharma.dto.AuthenticationResDto;
import com.eq.epharma.repo.UsersRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UsersRepo usersRepo;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(UsersRepo usersRepo, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.usersRepo = usersRepo;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticationResDto authenticate(AuthenticationReqDto request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getUserPassword()));
        var user=usersRepo.getByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(new HashMap<>(),user);
        AuthenticationResDto authResponse=new AuthenticationResDto();
        authResponse.setToken(jwtToken);
        return authResponse;

    }
}
