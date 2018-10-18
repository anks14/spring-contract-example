package com.example.demo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("contractProducerService")
public interface ProducerClient {

    @RequestMapping(method = RequestMethod.GET, path = "/testSchema")
    String validatesSchema(@RequestParam("shouldPassValidation") boolean shouldPassValidation);
}

