package com.eq.epharma.controller.rest;

import com.eq.epharma.dto.AuthenticationReqDto;
import com.eq.epharma.dto.AuthenticationResDto;
import com.eq.epharma.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResDto> authenticate(@RequestBody AuthenticationReqDto request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
