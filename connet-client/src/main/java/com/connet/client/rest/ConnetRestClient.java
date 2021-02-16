package com.connet.client.rest;

import lombok.AllArgsConstructor;
import org.connet.dto.network.PublishIpRequest;
import org.connet.dto.network.PublishIpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConnetRestClient {
    private RestTemplate restTemplate;

    @Value("${org.connet.api.base-url}")
    private String connetBaseUrl;

    public ConnetRestClient(RestTemplate connetRestTemplate) {
        this.restTemplate = connetRestTemplate;
    }

    public ResponseEntity<PublishIpResponse> publishIp(PublishIpRequest publishIpRequest) {
        return restTemplate.postForEntity(connetBaseUrl + "/api/network/publish", publishIpRequest, PublishIpResponse.class);
    }
}
