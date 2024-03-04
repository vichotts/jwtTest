package com.test.itau.service.impl;

import com.processo.seletivo.itau.service.impl.JwtServiceImpl;
import com.processo.seletivo.itau.service.impl.ValidationClaimsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class JwtServiceImplTest {

    @InjectMocks
    JwtServiceImpl jwtService;

    @Spy
    ValidationClaimsServiceImpl validationClaims;

    @Test
    void jwtOk(){
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05sIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";

        Optional<String> resp = jwtService.jwtResp(jwt);

        Assertions.assertEquals(resp.get(), "verdadeiro");

    }

    @Test
    void jwtNokTamanhoDoToken(){
        String jwt = "";

        Optional<String> resp = jwtService.jwtResp(jwt);

        Assertions.assertEquals(resp.get(), "falso");

    }

    @Test
    void jwtNokTamanhoDoPayload(){
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiTWVtYmVyIiwiT3JnIjoiQlIiLCJTZWVkIjoiMTQ2MjciLCJOYW1lIjoiVmFsZGlyIEFyYW5oYSJ9.cmrXV_Flm5mfdpfNUVopY_I2zeJUy4EZ4i3Fea98zvY";

        Optional<String> resp = jwtService.jwtResp(jwt);

        Assertions.assertEquals(resp.get(), "falso");

    }

    @Test
    void jwtNokClaimsFalso(){
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRXh0ZXJuYWwiLCJTZWVkIjoiODgwMzciLCJOYW1lIjoiTTRyaWEgT2xpdmlhIn0.6YD73XWZYQSSMDf6H0i3-kylz1-TY_Yt6h1cV2Ku-Qs";

        Optional<String> resp = jwtService.jwtResp(jwt);

        Assertions.assertEquals(resp.get(), "falso");

    }



}
