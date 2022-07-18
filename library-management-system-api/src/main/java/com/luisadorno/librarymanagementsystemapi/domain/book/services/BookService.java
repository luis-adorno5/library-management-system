package com.luisadorno.librarymanagementsystemapi.domain.book.services;

import java.util.UUID;

import com.luisadorno.librarymanagementsystemapi.core.exceptions.ResourceCreationException;
import com.luisadorno.librarymanagementsystemapi.core.exceptions.ResourceNotFoundException;
import com.luisadorno.librarymanagementsystemapi.domain.author.model.Author;
import com.luisadorno.librarymanagementsystemapi.domain.book.model.Book;

public interface BookService {
    Book create(Book book) throws ResourceCreationException;

    Iterable<Book> getAll();

    Book getById(UUID id) throws ResourceNotFoundException;

    Book updateBook(UUID id, Book book) throws ResourceNotFoundException;

    Book addAuthor(Book book, Author author);

    Boolean deleteBook(UUID id) throws ResourceNotFoundException;
}
