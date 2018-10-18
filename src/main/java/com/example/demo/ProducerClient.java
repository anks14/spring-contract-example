package com.example.demo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("contractProducerService")
public interface ProducerClient {

    @RequestMapping(method = RequestMethod.GET, path = "/testSchema")
    String validate(@PathVariable("shouldPassValidation") boolean shouldPassValidation);

}
