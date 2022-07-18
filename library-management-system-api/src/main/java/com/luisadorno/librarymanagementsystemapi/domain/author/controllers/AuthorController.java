package com.luisadorno.librarymanagementsystemapi.domain.author.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luisadorno.librarymanagementsystemapi.domain.author.model.Author;
import com.luisadorno.librarymanagementsystemapi.domain.author.services.AuthorService;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Author createdAuthor = authorService.create(author);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Author>> getAll() {
        Iterable<Author> authors = authorService.getAll();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

}
