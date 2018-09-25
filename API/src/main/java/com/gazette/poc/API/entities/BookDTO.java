package com.gazette.poc.API.entities;

public class BookDTO {
    private String bid;
    private String bookname;
    private String bookAuthor;
    private Integer bookcount;


    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBookname() {

        return bookname;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;

    }

    public Integer getBookcount() {
        return bookcount;
    }

    public void setBookcount(Integer bookcount) {
        this.bookcount = bookcount;
    }

}
