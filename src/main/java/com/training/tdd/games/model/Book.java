package com.training.tdd.games.model;

public class Book {

    public String bookName;
    public int noOfBooks;

    public Book(String bookName, int noOfBooks) {
        this.bookName = bookName;
        this.noOfBooks = noOfBooks;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookNmae) {
        this.bookName = bookNmae;
    }

    public int getNoOfBooks() {
        return noOfBooks;
    }

    public void setNoOfBooks(int noOfBooks) {
        this.noOfBooks = noOfBooks;
    }
}
