package com.processo.seletivo.itau.service.impl;

import com.processo.seletivo.itau.service.ValidationClaimsService;
import java.util.regex.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ValidationClaimsServiceImpl implements ValidationClaimsService {

    Boolean verdadeiro = Boolean.TRUE;
    Boolean falso = Boolean.FALSE;
    @Override
    public boolean validClaims(String role, Integer seed, String name) {

        ValidationClaimsServiceImpl.log.debug("IN-SERVICE.ValidationClaimsServiceImpl");

        return validateRole(role) == verdadeiro
                && validateSeed(seed) == verdadeiro
                && validateName(name) == verdadeiro
                ? verdadeiro
                : falso;
    }

    public static boolean validateRole(String role){

        if (!"Admin".equals(role)){
            //throw new ClaimException("Claim invalid : Código 1111");
            return false;
        }
        return true;
    }

    public static boolean validateSeed(Integer seed){
        if(seed <=1){
            //throw new ClaimException("Claim inválida : Código 2222");
            return false;
        }
        for(int i = 2; i< seed; i++){
            if(seed % i ==0){
                //throw new ClaimException("Claim inválida : Código 2222");
                return false;
            }
        }
        return true;
    }

    public static boolean validateName(String name) {

        if ( name.length() > 256 || name.matches(".*\\d.*")) {
            //throw new ClaimException("Claim inválida : Código 3333");
            return false;
        }
        return true;
    }

}
