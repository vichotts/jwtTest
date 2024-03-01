package com.processo.seletivo.itau.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class PayloadJwt {

    private String payloadContent;
    private String role;
    private Integer seed;
    private String name;
}
