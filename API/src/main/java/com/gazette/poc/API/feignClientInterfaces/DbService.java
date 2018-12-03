package com.gazette.poc.API.feignClientInterfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@FeignClient(name = "db-service", url = "http://db-service:8082")
public interface DbService {

    @GetMapping("/findBook/{bookname}")
    String searchBookByName(@PathVariable("bookname") String bookname);

    @GetMapping("/findAllBook")
    public String findAllBook();
}
