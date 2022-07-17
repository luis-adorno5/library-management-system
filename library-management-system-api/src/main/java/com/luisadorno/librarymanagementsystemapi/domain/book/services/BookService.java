package com.luisadorno.librarymanagementsystemapi.domain.book.services;

import com.luisadorno.librarymanagementsystemapi.core.exceptions.ResourceCreationException;
import com.luisadorno.librarymanagementsystemapi.domain.book.model.Book;

public interface BookService {
    Book create(Book book) throws ResourceCreationException;

    Iterable<Book> getAll();
}
