package com.gazette.poc.Db_Service.Model;

import javax.persistence.*;

@Entity
@Table(name = "book_tbl")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="bid")
    private int bookId;

    @Column(name = "bookname")
    private String bookName;

    @Column(name = "bookauthor")
    private String bookAuthor;

    @Column(name = "bookcount")
    private String bookCount;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getbookName() {
        return bookName;
    }

    public void setbookName(String bookname) {
        this.bookName = bookname;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

}
