package com.gazette.poc.API.feignClientInterfaces;

import com.gazette.poc.API.entities.UserDTO;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "db-service", url = "http://db-service:8082")
public interface DbService {

    @PostMapping("/add_user")
    @RequestMapping(method= RequestMethod.POST, value="/add_user", consumes = MediaType.)
    public void registerUser(String user);
}
