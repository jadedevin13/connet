package com.connet.client;

import com.connet.client.property.Auth0Property;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.util.Collections;

@SpringBootApplication
@EnableConfigurationProperties({Auth0Property.class})
public class ConnetClientApplication {

    public static void main(String[] args) {
        Application.launch(JavaFxApplication.class);
    }


    @Bean
    public RestTemplate connetRestTemplate(ClientHttpRequestInterceptor oAuthInterceptor) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(oAuthInterceptor));
        return restTemplate;
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setMaxPayloadLength(64000);
        return loggingFilter;
    }
}
