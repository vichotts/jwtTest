package com.processo.seletivo.itau.service;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface JwtService {

    public Optional<String> jwtResp(String jwtToken);
}
