package com.connet.client.service;

import com.connet.client.rest.ConnetRestClient;
import org.assertj.core.api.Assertions;
import org.connet.dto.network.PublishIpRequest;
import org.connet.dto.network.PublishIpResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import java.io.IOException;

@SpringBootTest({"spring.main.allow-bean-definition-overriding=true"})
@Import(NetworkServiceTestDirty.OverrideBean.class)
public class NetworkServiceTestDirty {

    @Autowired
    private NetworkService networkService;
    @MockBean
    private ConnetRestClient connetRestClient;

    @Test
    void test_publishIp() {
        Mockito.when(connetRestClient.publishIp(Mockito.any(PublishIpRequest.class)))
                .thenReturn(ResponseEntity.ok(PublishIpResponse.builder().response("1").build()));

        PublishIpResponse publishIpResponse = networkService.publishIp();
        Assertions.assertThat(publishIpResponse.getResponse()).contains("1");
    }

    @TestConfiguration
    public static class OverrideBean {

        @Bean
        public ClientHttpRequestInterceptor oAuthInterceptor() {
            return ((httpRequest, bytes, clientHttpRequestExecution) -> clientHttpRequestExecution.execute(httpRequest,bytes));
        }

    }
}