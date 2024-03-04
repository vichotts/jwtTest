package com.processo.seletivo.itau.service.impl;

import com.processo.seletivo.itau.dto.PayloadJwt;
import com.processo.seletivo.itau.service.JwtService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

//LOG4J
@Service
public class JwtServiceImpl implements JwtService {

    @Autowired
    private ValidationClaimsServiceImpl validationClaims;

    private final String ok = "verdadeiro";
    private final String nOk = "falso";

    @Override
    public Optional<String> jwtResp(String jwtToken) {
    	try {
        PayloadJwt payloadJwt = new PayloadJwt();

        String[] token = jwtToken.split("\\.");

        if(token.length !=3 ){

            throw new Exception();
        }

        payloadJwt.setPayloadContent(new String(Base64.getDecoder().decode(token[1])));
        
        JSONObject payload = new JSONObject(payloadJwt.getPayloadContent());

            if(payload.length() !=3 ){

                return Optional.of(nOk) ;
            }
            payloadJwt.setRole(payload.getString("Role")) ;
            payloadJwt.setSeed(payload.getInt("Seed"));
            payloadJwt.setName(payload.getString("Name"));

            if(validationClaims.validClaims(payloadJwt.getRole(),payloadJwt.getSeed(),payloadJwt.getName()) == Boolean.TRUE){
                return Optional.of(ok);
            }else
                return Optional.of(nOk);
        
    	} catch (Exception e) {
            //return ("Erro no JWT" ).describeConstable();
            return Optional.of(nOk);
		}


    }


}
