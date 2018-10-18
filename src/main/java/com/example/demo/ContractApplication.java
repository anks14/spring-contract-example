package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@SpringBootApplication
@RestController
public class ContractApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContractApplication.class, args);
    }

    @Autowired
    private JsonSchema schema;

    @RequestMapping("/testSchema")

    public boolean validateSchema() throws Exception {

        File jsonFile = new ClassPathResource("inValidData.json").getFile();
        ProcessingReport report = validate(jsonFile);
        System.out.println("Validation Output"+report.toString());
        return report.isSuccess();


    }

    public ProcessingReport validate(File jsonFile) throws Exception {
        JsonNode dataNode = JsonLoader.fromFile(jsonFile);
        return schema.validate(dataNode);

    }


}