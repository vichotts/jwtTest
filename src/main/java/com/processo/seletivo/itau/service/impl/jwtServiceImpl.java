package com.processo.seletivo.itau.service.impl;

import com.processo.seletivo.itau.exception.ClaimException;
import com.processo.seletivo.itau.service.JwtService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

//LOG4J
@Service
public class jwtServiceImpl implements JwtService {

    @Autowired
    private ValidationClaimsServiceImpl validationClaims;

    private String ok = "verdadeiro";
    private String nOk = "falso";
    private String payloadContent;
    private String role;
    private Integer seed;
    private String name;

    @Override
    public Optional<String> jwtResp(String jwtToken) {
    	try {

        String[] token = jwtToken.split("\\.");

        if(token.length !=3 ){

            throw new ClaimException("Token invalid");
        }

        payloadContent = new String(Base64.getDecoder().decode(token[1]));
        
        JSONObject payload = new JSONObject(payloadContent);

            if(payload.length() !=3 ){

                return Optional.of(nOk) ;
            }

        role = payload.getString("Role");
        seed = payload.getInt("Seed");
        name = payload.getString("Name");

            if(validationClaims.validClaims(role,seed,name) == Boolean.TRUE){
                return Optional.of(ok);
            }else
                return Optional.of(nOk);
        
    	} catch (Exception e) {
            //return ("Erro no JWT" ).describeConstable();
            return Optional.of(nOk);
		}


    }


}
