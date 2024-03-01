package com.processo.seletivo.itau.service;

public interface ValidationClaimsService {

    boolean validClaims(String role, Integer seed, String name);
}
