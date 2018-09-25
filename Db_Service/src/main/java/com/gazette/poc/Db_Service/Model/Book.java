package com.gazette.poc.Db_Service.Model;

import javax.persistence.*;

@Entity
@Table(name="book_tbl")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bid;

    @Column(name="bookname")
    private String bookname;

    @Column(name = "bookauthor")
    private String bookAuthor;

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    @Column(name="bookcount")

    private String bookcount;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookcount() {
        return bookcount;
    }

    public void setBookcount(String bookcount) {
        this.bookcount = bookcount;
    }
}
