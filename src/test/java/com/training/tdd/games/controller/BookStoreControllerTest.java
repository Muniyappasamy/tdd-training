package com.training.tdd.games.controller;

import com.training.tdd.games.model.Book;
import com.training.tdd.games.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = BookStoreController.class)
class BookStoreControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookService bookService;
    public Map<String, Integer> listOfBooksAndPrice = new HashMap<String, Integer>() {{
        put("BOOK1", 50);
        put("BOOK2", 50);
        put("BOOK3", 50);
        put("BOOK4", 50);
        put("BOOK5", 50);
    }};

    @Test
    public void getallbooksTest() throws Exception {

        Mockito.when(bookService.getAllBooks()).thenReturn(listOfBooksAndPrice);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/books/allbooks");

        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.BOOK1").exists()).andReturn();
    }

    @Test
    public void checkCalculatedPriceTest() throws Exception {

        Book book1 = new Book("BOOK1",2);
        Book book2 = new Book("BOOK2",2);

        List<Book> listofBooks = Arrays.asList(book1,book2);
        Mockito.when(bookService.getCalculatedPrice(listofBooks)).thenReturn(190);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/books/calculateprice").contentType(MediaType.APPLICATION_JSON)
                .content("[{\"bookName\":\"BOOK1\",\"noOfBooks\":2},{\"bookName\":\"BOOK2\",\"noOfBooks\":2}]");
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}