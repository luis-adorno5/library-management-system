package com.luisadorno.librarymanagementsystemapi.domain.book.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luisadorno.librarymanagementsystemapi.domain.book.model.Book;
import com.luisadorno.librarymanagementsystemapi.domain.book.services.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        Book createdBook = bookService.create(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Book>> getAll() {
        Iterable<Book> books = bookService.getAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getById(@PathVariable("id") UUID id) {
        Book book = bookService.getById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") UUID id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") UUID id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}