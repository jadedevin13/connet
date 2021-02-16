package com.connet.client.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WhatIsMyIpAddressClient {

    @Value("${org.connet.extern.what-is-my-ip-address.base-url}")
    private String baseUrl;
    private RestTemplate restTemplate;

    public WhatIsMyIpAddressClient() {
        this.restTemplate = new RestTemplate();
    }

    public HttpEntity<String> fetchIpAddresss() {
        return restTemplate.getForEntity(baseUrl, String.class);
    }
}
