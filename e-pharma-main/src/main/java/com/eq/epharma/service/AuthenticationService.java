package com.eq.epharma.service;


import com.eq.epharma.dto.AuthenticationReqDto;
import com.eq.epharma.dto.AuthenticationResDto;

public interface AuthenticationService {

     AuthenticationResDto authenticate(AuthenticationReqDto request);

}
