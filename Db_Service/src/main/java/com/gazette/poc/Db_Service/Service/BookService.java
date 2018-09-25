package com.gazette.poc.Db_Service.Service;

import com.gazette.poc.Db_Service.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface BookService extends JpaRepository<Book,Integer> {

    List<Book> findByName(String name);
}
