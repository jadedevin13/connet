package com.connet.client.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NetworkServiceTest {

    @Autowired
    private NetworkService networkService;

    @Test
    void test_login_first_publishIp() {
        Assertions.assertThatCode(() -> {
            networkService.publishIp();
        }).hasMessage("User has to login first");
    }
}