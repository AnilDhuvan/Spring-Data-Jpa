package com.p1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p1.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
	
    // JpaRepository already provides pagination and sorting methods!
	
}