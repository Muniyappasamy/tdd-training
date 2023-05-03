package com.training.tdd.games.service;

import com.training.tdd.games.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    BookService bookService;

    @BeforeEach
    void setup() {
        bookService = new BookService();
    }

    @Test
    public void nodiscountbooks() {
        Book book1 = new Book("BOOK1", 1);
        List<Book> books = Arrays.asList(book1);
        assertTotal(50, books);
    }

    @Test

    public void fivePercentagediscountbooks() {
        Book book1 = new Book("BOOK1", 1);
        Book book2 = new Book("BOOK2", 1);

        List<Book> books = Arrays.asList(book1, book2);
        assertTotal(95, books);
    }

    @Test
    public void tenPercentagediscountbooks() {
        Book book1 = new Book("BOOK1", 1);
        Book book2 = new Book("BOOK2", 1);
        Book book3 = new Book("BOOK3", 1);
        List<Book> books = Arrays.asList(book1, book2, book3);
        assertTotal(135, books);
    }

    @Test
    public void twentyPercentagediscountbooks() {
        Book book1 = new Book("BOOK1", 1);
        Book book2 = new Book("BOOK2", 1);
        Book book3 = new Book("BOOK3", 1);
        Book book4 = new Book("BOOK4", 1);

        List<Book> books = Arrays.asList(book1, book2, book3, book4);
        assertTotal(160, books);
    }

    @Test
    public void twentyFivePercentagediscountbooks() {
        Book book1 = new Book("BOOK1", 1);
        Book book2 = new Book("BOOK2", 1);
        Book book3 = new Book("BOOK3", 1);
        Book book4 = new Book("BOOK4", 1);
        Book book5 = new Book("BOOK5", 1);
        List<Book> books = Arrays.asList(book1, book2, book3, book4, book5);
        assertTotal(187, books);
    }

    @Test
    public void multiPercentagediscountbooks() {
        Book book1 = new Book("BOOK1", 2);
        Book book2 = new Book("BOOK2", 2);
        Book book3 = new Book("BOOK3", 2);
        Book book4 = new Book("BOOK4", 1);
        Book book5 = new Book("BOOK5", 1);
        List<Book> books = Arrays.asList(book1, book2, book3, book4, book5);
        assertTotal(320, books);
    }

    private void assertTotal(int input, List<Book> books) {
        int result = bookService.getCalculatedPrice(books);
        Assertions.assertEquals(input, result);
    }


}