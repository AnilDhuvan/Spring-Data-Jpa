package com.p1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.p1.entity.Book;
import com.p1.service.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // Endpoint to get paginated and sorted list of books
    @GetMapping("/books")
    public Page<Book> getBooks(
            @RequestParam(defaultValue = "0") int page,   // default page = 0
            @RequestParam(defaultValue = "5") int size,   // default page size = 5
            @RequestParam(defaultValue = "title") String sortBy) {
        return bookService.getBooks(page, size, sortBy);
    }
}
