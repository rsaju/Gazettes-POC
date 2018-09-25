package com.gazette.poc.Db_Service.Controller;

import com.gazette.poc.Db_Service.Model.Book;
import com.gazette.poc.Db_Service.Service.BookService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    Gson gson = new Gson();

    @GetMapping("/findBook/{bookname}")
    public String searchBookByName(HttpServletRequest request ,@PathVariable("bookname") String bookname){

        List<Book> books = bookService.findByName(bookname);
        String jsonBook = gson.toJson(books);
//        ResponseEntity<String> responseEntity = new ResponseEntity<String>
        return jsonBook;
    }
}
