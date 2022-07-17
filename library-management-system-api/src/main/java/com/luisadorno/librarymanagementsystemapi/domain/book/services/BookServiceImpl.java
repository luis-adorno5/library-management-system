package com.luisadorno.librarymanagementsystemapi.domain.book.services;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisadorno.librarymanagementsystemapi.core.exceptions.ResourceCreationException;
import com.luisadorno.librarymanagementsystemapi.domain.book.model.Book;
import com.luisadorno.librarymanagementsystemapi.domain.book.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book book) throws ResourceCreationException {
        return null;
    }

    @Override
    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }

}
