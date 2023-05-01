package com.training.tdd.games.service;

import com.training.tdd.games.model.Book;
import com.training.tdd.games.repository.Books;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BookService {

    private Map<Books,Integer> books = new HashMap<>();

    public List<String> findAllBooks() {
        return Stream.of(Books.values()).map(Books::name).collect(Collectors.toList());
    }

    public int calculateBookPrice(List<Book> listOfBooks) {

        for(Book book:listOfBooks){
            int noOfBooks = book.getNoOfBooks();
            while(noOfBooks > 0){
                addBook(contains(book.getBookName()));
                noOfBooks -- ;
            }

        }

        int result = getOptimalPrice();
        System.out.println("total : " + result);
        return result;


    }

    public int getOptimalPrice(){
        int total = 0;
        HashMap<Books,Integer> remainingBooks = new HashMap<>(books);
        while(getNumberOfBooks(remainingBooks) > 0){

            int numberOfDistinctBooks = getNumberOfDistinctBooks(remainingBooks);
            if(numberOfDistinctBooks == 5){
                total+= (int )5* 50 * (25/100);
            }
            else if(numberOfDistinctBooks == 4){
                total+= (int )4* 50 * (20/100);
            }
            else if(numberOfDistinctBooks == 3){
                total+= (int )3* 50 * (10/100);
            }
            else{
                total+= 50;
            }

            removeOneIssueOfEachBook((HashMap<Books, Integer>) remainingBooks);
        }

        return total;
    }
    public static Books contains(String test) {

        for (Books c : Books.values()) {
            if (c.name().equals(test)) {
                return c;
            }
        }

        return null;
    }

    private void removeOneIssueOfEachBook(HashMap<Books, Integer> remainingBooks) {
        Set<Books> distinctBooks = new HashSet<>(remainingBooks.keySet());
        for(Books book: distinctBooks){
            int amount = remainingBooks.get(book);
            if(amount == 1){
                remainingBooks.remove(book);
            }
            else {
                remainingBooks.put(book,amount-1);
            }
        }
    }

    private int getNumberOfDistinctBooks(HashMap<Books, Integer> remainingBooks) {
        return remainingBooks.values().stream().reduce(0,(i,j) -> i+j);
    }

    private int getNumberOfBooks(HashMap<Books, Integer> remainingBooks) {
        return remainingBooks.size();
    }
    public void addBook(Books book) {
        int amt =0 ;
        if(books.containsKey(book)){
            amt = books.get(book);
        }
        books.put(book,amt+1);
    }
}
