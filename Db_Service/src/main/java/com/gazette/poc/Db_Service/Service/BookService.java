package com.gazette.poc.Db_Service.Service;

import com.gazette.poc.Db_Service.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "book", path = "book")
public interface BookService extends JpaRepository<Book,Integer> {
}