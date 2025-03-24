package com.p1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.p1.entity.Book;
import com.p1.repo.BookRepo;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepository;

    // Fetch paginated and sorted list of books
    public Page<Book> getBooks(int pageNumber, int pageSize, String sortBy) {
    	
    //	Pageable pageable = PageRequest.of(pageNumber, pageSize);
    	
    	
       Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
    	
    	
        return bookRepository.findAll(pageable);
    	
    	
    	
    }
}
