package com.connet.client.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.auth0")
public class Auth0Property {
    private String domain;
    private String clientId;
    private String clientSecret;
}
