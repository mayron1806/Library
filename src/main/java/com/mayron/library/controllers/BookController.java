package com.mayron.library.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mayron.library.dtos.CreateBookDTO;
import com.mayron.library.services.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/book")
public class BookController {
    
    private final BookService bookService;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    // listar todos livros
    @GetMapping("/")
    private ResponseEntity<Object> findMany(
        @RequestParam(name = "limit", required = false) Integer limit, 
        @RequestParam(name = "limit", required = false) Integer page
    ){
        System.out.println(limit + " - " + page);
        var result = bookService.getMany(limit, page);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    // pega por id
    @GetMapping("/{id}")
    private ResponseEntity<Object> findOne(@PathVariable Long id){
        var result = bookService.getBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    // criar livro
    @PostMapping("/")
    private ResponseEntity<Object> addBook(@RequestBody @Valid CreateBookDTO bookDTO){
        var result = bookService.addBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // atualiza 

    // deleta
    @DeleteMapping("/{id}")
    private ResponseEntity<Object> removeBook(@PathVariable(required = true) long id){
        var result = bookService.removeBook(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
