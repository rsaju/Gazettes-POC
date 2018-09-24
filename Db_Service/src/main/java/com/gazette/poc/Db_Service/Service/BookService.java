package com.gazette.poc.Db_Service.Service;

import com.gazette.poc.Db_Service.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookService extends JpaRepository<Book,Integer> {
}
