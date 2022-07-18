package com.luisadorno.librarymanagementsystemapi.domain.author.services;

import java.util.UUID;

import com.luisadorno.librarymanagementsystemapi.domain.author.model.Author;

public interface AuthorService {
    Author create(Author author);

    Iterable<Author> getAll();

    Author getById(UUID id);
}
