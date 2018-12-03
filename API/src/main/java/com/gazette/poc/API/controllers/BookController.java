package com.gazette.poc.API.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gazette.poc.API.entities.BookDTO;
import com.gazette.poc.API.feignClientInterfaces.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    DbService dbService;

    @GetMapping("/searchbook")
    public String findBookByName(@RequestParam("bookname") String bookName,Model model) throws Exception{
        String result = dbService.searchBookByName(URLEncoder.encode(bookName,"UTF-8"));
        ObjectMapper mapper = new ObjectMapper();
        List<BookDTO> bookDTOList = mapper.readValue(result,new TypeReference<List<BookDTO>>(){});
        model.addAttribute("books",bookDTOList);
        return "booksCollection";
    }
    @GetMapping("/findAllBooks")
    public String findAllBooks(Model model) throws IOException {
        ResponseEntity responseEntity = template.getForEntity(getBaseUrl("db-service")+"/findAllBook",String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<BookDTO> bookDTOList = mapper.readValue(responseEntity.getBody().toString(),new TypeReference<List<BookDTO>>(){});
        model.addAttribute("books",bookDTOList);
        return "booksCollection";
    }

}
