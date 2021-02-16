package com.connet.client.service;

import com.auth0.client.auth.AuthAPI;
import com.auth0.exception.Auth0Exception;
import com.auth0.json.auth.TokenHolder;
import com.connet.client.property.Auth0Property;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthService {

    private Auth0Property auth0Property;
    private TokenHolder tokenHolder;

    public AuthService(Auth0Property auth0Property) {
        this.auth0Property = auth0Property;
    }

    public TokenHolder retrieveToken(String emailOrUsername, String password) throws Auth0Exception {
        AuthAPI auth = new AuthAPI(auth0Property.getDomain(), auth0Property.getClientId(), "39XMlA3xdM86xyBOibnjZTr5bw0PgFT1EADFWCi7W_ulqxlqOckE7vpKXUjYBbWd");
        tokenHolder = auth.login(emailOrUsername, password.toCharArray()).execute();
        return tokenHolder;
    }

    public TokenHolder getTokenHolder() {
        return tokenHolder;
    }
}
