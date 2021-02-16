package org.connet.connet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.connet.dto.network.PublicIpDetailRequest;
import org.connet.dto.network.PublishIpRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class NetworkControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_publishIp() throws Exception {
        PublishIpRequest mockPublishIpRequest = PublishIpRequest.builder().publicIpAddress(List.of(PublicIpDetailRequest.builder().ipAddress("1").provider("x").build())).build();

        this.mockMvc.perform(post("/api/network/publish")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsBytes(mockPublishIpRequest)))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("\"response\":\"Mock response: 1---127.0.0.1\"")));
    }
}