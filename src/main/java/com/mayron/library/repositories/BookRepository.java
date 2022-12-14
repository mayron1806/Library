package com.mayron.library.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayron.library.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    
}
