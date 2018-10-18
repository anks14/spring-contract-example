package com.example.demo;

import com.github.fge.jsonschema.core.report.ProcessingReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractProducerController {

    @Autowired
    private ContractProducerService contractProducerService;


    @GetMapping("/testSchema")

    public String validateSchema(@RequestParam("shouldPassValidation") boolean shouldPassValidation) throws Exception {

        ProcessingReport report = contractProducerService.validateSchema(shouldPassValidation);

        if (report.isSuccess())
            return "Success!";
        else
            return "Failure!";
    }

}
