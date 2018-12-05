package com.gazette.poc.Db_Service.Controller;

import com.gazette.poc.Db_Service.Model.Book;
import com.gazette.poc.Db_Service.Service.BookService;
import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    Gson gson = new Gson();

    @GetMapping("/findBook/{bookname}")
    @HystrixCommand(fallbackMethod = "getSearchByName")
    public String searchBookByName(@PathVariable("bookname") String bookname) throws UnsupportedEncodingException {

            String jsonBook = null;
            String bookName = URLDecoder.decode(bookname, "UTF-8");
            List<Book> books = bookService.findByBookName(bookName);
            if(books.size()==0){
                System.out.println("Exception thrown at search book by name");
                throw new RuntimeException();
            }
            jsonBook = gson.toJson(books);

        return jsonBook;
    }

    public String getSearchByName(@PathVariable("bookname") String bookname){
        System.out.println("Fall back method in search by name");
        return "fall back method for searchByName method";
    }

    @GetMapping("/findAllBook")
//    @HystrixCommand(fallbackMethod = "getFallBack")
    public String findAllBook() {

        List<Book> books = bookService.findAll();
        String jsonBook = gson.toJson(books);
        return jsonBook;

    }

    public String getFallBack(){
        System.out.println("Inside Fall Back Method");
        return "Hystrix is working";

    }

    @PostMapping("/addBook")
    public void addBook(HttpServletRequest request) throws IOException {
        BufferedReader bufferedReader = request.getReader();
        Book book=gson.fromJson(bufferedReader,Book.class);
        bookService.save(book);
    }

    @DeleteMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int bookId){
        try{
            bookService.deleteBybookId(bookId);
            return "Book deleted from Library"+bookId;
        }catch(Exception e){
            return "Failed to delete Book";
        }
    }


}
