package com.connet.client.service;

import com.connet.client.rest.ConnetRestClient;
import com.connet.client.rest.WhatIsMyIpAddressClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.connet.dto.network.PublicIpDetailRequest;
import org.connet.dto.network.PublishIpRequest;
import org.connet.dto.network.PublishIpResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class NetworkService {

    private ConnetRestClient connetRestClient;
    private WhatIsMyIpAddressClient whatIsMyIpAddressClient;

    public PublishIpResponse publishIp() {
        PublicIpDetailRequest publicIpDetailRequest = PublicIpDetailRequest.builder()
                .provider("http://bot.whatismyipaddress.com/")
                .ipAddress(whatIsMyIpAddressClient.fetchIpAddresss().getBody()).build();

        PublishIpRequest publishIpRequest = PublishIpRequest.builder().publicIpAddress(List.of(publicIpDetailRequest)).build();
        PublishIpResponse publishIpResponse = connetRestClient.publishIp(publishIpRequest).getBody();
        log.debug("Successful publishing IP to server", publishIpResponse);
        return publishIpResponse;
    }
}
