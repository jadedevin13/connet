package org.connet.connet.controller;

import org.connet.dto.network.PublicIpDetailRequest;
import org.connet.dto.network.PublishIpRequest;
import org.connet.dto.network.PublishIpResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/network")
public class NetworkController {

    @PostMapping("/publish")
    public PublishIpResponse publishIp(@RequestBody PublishIpRequest publishIpRequest, ServletRequest servletRequest) {
        return PublishIpResponse.builder().response("Mock response: " + publishIpRequest.getPublicIpAddress().stream().map(PublicIpDetailRequest::getIpAddress).collect(Collectors.joining(",")) + "---" + servletRequest.getRemoteAddr()).build();
    }
}
