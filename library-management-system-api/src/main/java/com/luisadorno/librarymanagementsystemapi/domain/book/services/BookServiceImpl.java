package com.luisadorno.librarymanagementsystemapi.domain.book.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisadorno.librarymanagementsystemapi.core.exceptions.ResourceCreationException;
import com.luisadorno.librarymanagementsystemapi.core.exceptions.ResourceNotFoundException;
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
        if (bookRepository.getByTitle(book.getTitle()).isPresent())
            throw new ResourceCreationException(
                    String.format("A book with title {%s} already exists.", book.getTitle()));
        return bookRepository.save(book);
    }

    @Override
    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(UUID id) throws ResourceNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(String.format("Book with id: {%s} does not exist.", id)));
        return book;
    }

    @Override
    public Book updateBook(UUID id, Book book) throws ResourceNotFoundException {
        Book bookToUpdate = bookRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(String.format("Book with id: {%s} does not exist.", id)));
        bookToUpdate.setCategoryId(book.getCategoryId());
        bookToUpdate.setCopiesOwned(book.getCopiesOwned());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setPublicationDate(book.getPublicationDate());
        return bookRepository.save(bookToUpdate);
    }

    @Override
    public Boolean deleteBook(UUID id) throws ResourceNotFoundException {
        Book bookToDelete = bookRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(String.format("Book with id: {%s} does not exist.", id)));
        bookRepository.delete(bookToDelete);
        return true;
    }

}
