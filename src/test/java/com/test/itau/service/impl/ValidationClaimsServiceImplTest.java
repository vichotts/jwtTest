package com.test.itau.service.impl;

import com.processo.seletivo.itau.service.impl.JwtServiceImpl;
import com.processo.seletivo.itau.service.impl.ValidationClaimsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ValidationClaimsServiceImplTest {

    @InjectMocks
    ValidationClaimsServiceImpl validationClaim;

    @Test
    void nokClaimsSeedInvalido(){

        String role = "Admin" ;
        Integer seed = 4 ;
        String name = "Toninho Araujo";

        Boolean resp = validationClaim.validClaims(role,seed, name);

        Assertions.assertEquals(resp, Boolean.FALSE);

    }

    @Test
    void nokClaimsSeedInvalido1(){

        String role = "Admin" ;
        Integer seed = 1 ;
        String name = "Toninho Araujo";

        Boolean resp = validationClaim.validClaims(role,seed, name);

        Assertions.assertEquals(resp, Boolean.FALSE);

    }

    @Test
    void nokClaimsNameInvalido(){

        String role = "Admin" ;
        Integer seed = 7841 ;
        String name = "M4ria Olivia";

        Boolean resp = validationClaim.validClaims(role,seed, name);

        Assertions.assertEquals(resp, Boolean.FALSE);

    }
}
