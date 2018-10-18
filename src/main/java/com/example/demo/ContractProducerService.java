package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ContractProducerService {


    @Autowired
    private JsonSchema schema;


    public ProcessingReport validateSchema(boolean shouldPassValidation) throws Exception {

        File jsonFile = null;
        ProcessingReport report = null;

        if (shouldPassValidation) {
            jsonFile = new ClassPathResource("validData.json").getFile();

        } else {
            jsonFile = new ClassPathResource("inValidData.json").getFile();
        }
        report = validate(jsonFile);

        System.out.println("Validation Output" + report.toString());
        return report;

    }

    private ProcessingReport validate(File jsonFile) throws Exception {
        JsonNode dataNode = JsonLoader.fromFile(jsonFile);
        return schema.validate(dataNode);

    }
}
