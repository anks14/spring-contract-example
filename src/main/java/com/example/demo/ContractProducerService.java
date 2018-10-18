package com.example.demo;

import com.github.fge.jsonschema.core.report.ProcessingReport;

public interface ContractProducerService {


    ProcessingReport validateSchema(boolean shouldPassValidation) throws Exception;
}
