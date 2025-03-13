package com.demo.bookMange.service;


import com.demo.bookMange.entity.Book;
import com.demo.bookMange.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    public Optional<Book> getBookById(Long id) {
        Book book = bookMapper.getBookById(id);
        return Optional.ofNullable(book);
    }

    public void saveBook(Book book) {
        bookMapper.addBook(book);
    }

    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    public void deleteBook(Long id) {
        bookMapper.deleteBook(id);
    }
}