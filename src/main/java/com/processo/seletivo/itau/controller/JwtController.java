package com.processo.seletivo.itau.controller;

import com.processo.seletivo.itau.service.JwtService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/jwt")
@Slf4j
public class JwtController {

	@Autowired
	private JwtService jwtService;

	@GetMapping
	public ResponseEntity<String> getMethodName(@RequestParam @Valid String jwtToken) {
		JwtController.log.debug("IN-CONTROLLER.JwtController");

		Optional<String> jwtResp = jwtService.jwtResp(jwtToken);
        return ResponseEntity.of(jwtResp);

    }

}
