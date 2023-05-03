package com.training.tdd.games.service;

import com.training.tdd.games.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BookService {


    private Map<String, Integer> listOfBooksAndPrice = new HashMap<String, Integer>() {{
        put("BOOK1", 50);
        put("BOOK2", 50);
        put("BOOK3", 50);
        put("BOOK4", 50);
        put("BOOK5", 50);
    }};
    private Map<Integer, Double> percentageMap = new HashMap<Integer, Double>() {{
        put(5, 0.75);
        put(4, 0.8);
        put(3, 0.9);
        put(2, 0.95);
        put(1, 0.0);
    }};
    private static int BASE_PRICE = 50;

    public Map<String, Integer> totalBooks = new HashMap<String, Integer>();


    public Map<String, Integer> getAllBooks() {
        return listOfBooksAndPrice;
    }


    public int getCalculatedPrice(List<Book> books) {
        for (Book book : books) {
            addToBookMap(book);
        }
        HashMap<String, Integer> remainingBooks = new HashMap<String, Integer>(totalBooks);
        int noOfIteration = 5;
        int minVal = Integer.MAX_VALUE;

        int totalNoOfDistinctBooks = getNoOfTotalDistinctBooks(remainingBooks);
        while (totalNoOfDistinctBooks > 0) {

            int totalNoOfBooks = getNoOfTotalBooks(remainingBooks);

            int result = 0;
            while (totalNoOfBooks > 0) {

                int bookIterate = totalNoOfBooks / totalNoOfDistinctBooks;
                int remainNoOfBooks = 0;
                if (bookIterate == 0) {
                    remainNoOfBooks = totalNoOfBooks;
                    result += getPriceWithDiscountPercentage(remainNoOfBooks);
                    remainNoOfBooks = 0;
                } else {
                    remainNoOfBooks = totalNoOfBooks % totalNoOfDistinctBooks;
                }
                while (bookIterate > 0) {

                    result += getPriceWithDiscountPercentage(totalNoOfDistinctBooks);
                    bookIterate--;
                }
                totalNoOfBooks = remainNoOfBooks;

            }

            if (result < minVal) {
                minVal = result;
            }
            totalNoOfDistinctBooks--;
        }

        return (minVal == Integer.MAX_VALUE ? 0 : minVal);
    }

    public void addToBookMap(Book book) {
        if (listOfBooksAndPrice.containsKey(book.getBookName())) {
            totalBooks.put(book.getBookName(), book.getNoOfBooks());
        }
    }

    private int getPriceWithDiscountPercentage(int noOfBooks) {

        if (noOfBooks == 1) return BASE_PRICE;

        return (int) (noOfBooks * BASE_PRICE * percentageMap.get(noOfBooks));
    }

    private int getNoOfTotalBooks(HashMap<String, Integer> books) {

        return books.values().stream().reduce(0, (i, j) -> (i + j));
    }

    private int getNoOfTotalDistinctBooks(HashMap<String, Integer> books) {

        return books.size();
    }
}





