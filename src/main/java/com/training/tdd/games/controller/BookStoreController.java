package com.training.tdd.games.controller;

import com.training.tdd.games.model.Book;
import com.training.tdd.games.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookStoreController {

    public final com.training.tdd.games.service.BookService bookService;

    public BookStoreController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/allbooks")
    List<String> getAllBooks() {
        return this.bookService.findAllBooks();
    }


    @PostMapping("/calculateprice")
    int calculateBookPrice(@RequestBody Book[] books) {
        List<Book> listOfBooks = Arrays.asList(books);
        return this.bookService.calculateBookPrice(listOfBooks);
    }
}