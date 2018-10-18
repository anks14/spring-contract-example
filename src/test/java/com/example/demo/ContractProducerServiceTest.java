package com.example.demo;

import com.github.fge.jsonschema.core.report.ProcessingReport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContractProducerApplication.class)
@DirtiesContext
public class ContractProducerServiceTest {


    @Autowired
    private ContractProducerServiceImpl contractProducerService;



    @Test
    public void whenInvalidJsonIsPassedThenExpectErrorResponse() throws Exception {

        boolean shouldPassValidation = false;


        ProcessingReport validationReport = contractProducerService.validateSchema(shouldPassValidation);

        System.out.println("***Validation Failed!!" + validationReport.toString());
        assertFalse(validationReport.isSuccess());

    }


    @Test
    public void whenValidJsonIsPassedThenExpectSuccessResponse() throws Exception {

        boolean shouldPassValidation = true;

        ProcessingReport validationReport = contractProducerService.validateSchema(shouldPassValidation);

        System.out.println("***Validation Successs!!!" + validationReport.toString());
        assertTrue(validationReport.isSuccess());

    }

}
