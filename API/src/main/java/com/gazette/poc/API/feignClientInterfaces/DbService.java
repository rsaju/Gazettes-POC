package com.gazette.poc.API.feignClientInterfaces;

import com.gazette.poc.API.entities.UserDTO;
import feign.Headers;
import feign.RequestLine;

//@FeignClient(name = "db-service", url = "http://db-service:8082")
@Headers("Accept: application/json")
public interface DbService {


    @Headers("Content-Type: application/json")
    @RequestLine("POST" + "/add_user")
    public void registerUser(UserDTO user);
}
