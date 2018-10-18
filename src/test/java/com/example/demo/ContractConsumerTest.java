package com.example.demo;


import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import static org.junit.Assert.assertEquals;
/*

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContractProducerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
@AutoConfigureStubRunner(
        ids = "com.example:spring-contract-example:+:stubs:9090",
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
*/

public class ContractConsumerTest {

   /* @Autowired
    private ProducerClient producerClient;

    @Before
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(producerClient);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }

    @Test
    public void whenInvalidJsonIsPassedThenExpectErrorResponse() throws Exception {

        String result = producerClient.validate(false);

        assertEquals(result, "Failure!");

    }


    @Test
    public void whenValidJsonIsPassedThenExpectSuccessResponse() throws Exception {

        String result = producerClient.validate(true);

        assertEquals(result, "Success!");
    }

*/
}
