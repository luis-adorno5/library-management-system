package com.luisadorno.librarymanagementsystemapi.domain.book.controllers;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luisadorno.librarymanagementsystemapi.domain.book.model.Book;
import com.luisadorno.librarymanagementsystemapi.domain.book.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Book>> getAll() {
        Iterable<Book> books = bookService.getAll();
        return ResponseEntity.ok(books);
    }

}