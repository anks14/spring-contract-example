package com.example.demo;


import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContractProducerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
public class ContractProducerTest {

    @Autowired
    private ContractProducerController contractProducerController;


    @Before
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(contractProducerController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }


    @Test
    public void whenInvalidJsonIsPassedThenExpectErrorResponse() throws Exception {

        String result = contractProducerController.validateSchema(false);

        assertEquals(result, "Failure!");

    }


    @Test
    public void whenValidJsonIsPassedThenExpectSuccessResponse() throws Exception {

        String result = contractProducerController.validateSchema(true);

        assertEquals(result, "Success!");
    }


}
