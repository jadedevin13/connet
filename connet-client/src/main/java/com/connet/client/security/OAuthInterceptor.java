package com.connet.client.security;

import com.connet.client.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@AllArgsConstructor
public class OAuthInterceptor implements ClientHttpRequestInterceptor {

    private AuthService authService;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        String idToken = "";
        try {
            idToken = authService.getTokenHolder().getIdToken();
        } catch (NullPointerException exc) {
            throw new RuntimeException("User has to login first");
        }
        HttpHeaders headers = request.getHeaders();
        headers.add("Authorization", "Bearer " + idToken);
        return execution.execute(request, body);
    }
}