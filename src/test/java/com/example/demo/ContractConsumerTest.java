package com.example.demo;


import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContractProducerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ContextConfiguration(classes = ContractConsumerTest.LocalRibbonClientConfiguration.class)
@DirtiesContext
@AutoConfigureMessageVerifier
@AutoConfigureStubRunner(
        ids = "com.example:spring-contract-example:+:stubs:9090",
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)

public class ContractConsumerTest {

    @Autowired
    private ProducerClient producerClient;


    @Before
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(producerClient);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);


    }

    @Test
    public void whenInvalidJsonIsPassedThenExpectErrorResponse() throws Exception {

        String result = producerClient.validatesSchema(false);

        assertEquals(result, "Failure!");

    }


    @Test
    public void whenValidJsonIsPassedThenExpectSuccessResponse() throws Exception {

        String result = producerClient.validatesSchema(true);

        assertEquals(result, "Success!");
    }

    @TestConfiguration
    public static class LocalRibbonClientConfiguration {
        @Bean
        public ServerList<Server> ribbonServerList() {
            return new StaticServerList<>(new Server("localhost", 9090));
        }
    }

}
