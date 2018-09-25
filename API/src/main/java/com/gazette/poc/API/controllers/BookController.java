package com.gazette.poc.API.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplateBuilder templateBuilder;

    @GetMapping("/serachbook")
    public void findBookByName(@PathParam("bookname") String bookName){
        RestTemplate template = templateBuilder.build();
        ResponseEntity responseEntity = template.getForEntity(getBaseUrl("Db_Service")+"/findBook/"+bookName,String.class);
        System.out.println(responseEntity);
    }

    private String getBaseUrl(String serviceName){
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        String baseUrl = instances.get(0).getUri().toString();
        return baseUrl;
    }
}
