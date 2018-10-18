package com.example.demo;

import com.github.fge.jsonschema.core.report.ProcessingReport;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContractApplication.class,webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier

public class ContractApplicationTest {


    private File invalidJsonDataFile;

    private File validJsonDataFile;

    @Autowired
    private ContractApplication contractApplication;


    @Before
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(contractApplication);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }

    @Test
    public void whenInvalidJsonIsPassedThenExpectErrorResponse() throws Exception {

        File invalidJsonDataFile = new ClassPathResource("inValidData.json").getFile();

        ProcessingReport validationReport = contractApplication.validate(invalidJsonDataFile);

        System.out.println("***Validation Failed!!" + validationReport.toString());
        assertFalse(validationReport.isSuccess());

    }


    @Test
    public void whenValidJsonIsPassedThenExpectSuccessResponse() throws Exception {

        File validJsonDataFile = new ClassPathResource("validData.json").getFile();


        ProcessingReport validationReport = contractApplication.validate(validJsonDataFile);

        System.out.println("***Validation Successs!!!" + validationReport.toString());
        assertTrue(validationReport.isSuccess());

    }

}
