package com.training.tdd.games.controller;

import com.training.tdd.games.model.Book;
import com.training.tdd.games.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/books")
public class BookStoreController {
    @Autowired
    BookService bookService;

    @GetMapping("/allbooks")
    Map<String, Integer> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @PostMapping("/calculateprice")
    int calculateBookPrice(@RequestBody Book[] books) {
        List<Book> listOfBooks = Arrays.asList(books);
        return this.bookService.getCalculatedPrice(listOfBooks);
    }
}