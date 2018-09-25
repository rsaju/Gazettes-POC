package com.gazette.poc.Db_Service.Controller;

import com.gazette.poc.Db_Service.Model.Book;
import com.gazette.poc.Db_Service.Service.BookService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    Gson gson = new Gson();

    @GetMapping("/findBook/{bookname}")
    public String searchBookByName(HttpServletRequest request ,@PathVariable("bookname") String bookname) throws Exception{

        String book = URLDecoder.decode(bookname, "UTF-8");
        List<Book> books = bookService.findBybookName(bookname);
        String jsonBook = gson.toJson(books);
        return jsonBook;
    }

    @GetMapping("/findAllBook")
    public String findAllBook(HttpServletRequest request){
        List<Book> books = bookService.findAll();
        String jsonBook = gson.toJson(books);
        return jsonBook;
    }

    @PostMapping("/addBook")
    public void addBook(HttpServletRequest request) throws IOException{
        BufferedReader bufferedReader = request.getReader();
        Gson gson = new Gson();
        Book book = gson.fromJson(bufferedReader, Book.class);
        bookService.save(book);
    }

    @DeleteMapping("/deleteBook/{bookId}")
    public String deleteBook(HttpServletRequest request, @PathVariable("bookId") int bookId) throws Exception {
        bookService.deleteById(bookId);
        return "Book deleteed with Id:"+bookId;
    }

}
