package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;

@Configuration
public class ContractConfig {

    @Bean
    public JsonSchema getJsonSchema() {

        JsonSchema schema = null;
        try {

            File schemaFile = new ClassPathResource("schema.json").getFile();
            JsonNode schemaNode = JsonLoader.fromFile(schemaFile);
            JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
            schema = schemaFactory.getJsonSchema(schemaNode);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return schema;

    }
}