package com.mayron.library.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mayron.library.dtos.BookDTO;
import com.mayron.library.dtos.CreateBookDTO;
import com.mayron.library.entities.Book;
import com.mayron.library.repositories.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final ModelMapper mapper;

    public BookService(BookRepository bookRepository, ModelMapper mapper) {
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }
    public BookDTO getBookById(long id){
        var result = bookRepository.findById(id);
        if(!result.isPresent()){
            return null;
        }
        return mapper.map(result.get(), BookDTO.class);
    }
    public List<BookDTO> getMany(Integer limit, Integer page){
        if(limit == null) limit = 20;
        if(page == null) page = 0;

        Page<Book> pageBook = bookRepository.findAll(PageRequest.of(page, limit));
        List<Book> listBook = pageBook.getContent();
        return listBook.stream().map(book -> mapper.map(book, BookDTO.class)).collect(Collectors.toList());
    }
    public BookDTO addBook(CreateBookDTO createBookDTO){
        var book = mapper.map(createBookDTO, Book.class);
        bookRepository.save(book);
        return mapper.map(book, BookDTO.class);
    }
    public boolean removeBook(Long id){
        // pega livro para deletar
        var book = bookRepository.findById(id);
        if(book.isPresent()){
            bookRepository.delete(book.get());
            return true;
        }
        return false;
    }
}
