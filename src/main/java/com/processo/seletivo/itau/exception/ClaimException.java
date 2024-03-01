package com.processo.seletivo.itau.exception;

import org.springframework.validation.annotation.Validated;

@Validated
public class ClaimException extends RuntimeException {

        public ClaimException(String message) {
            super(message);
        }

}
