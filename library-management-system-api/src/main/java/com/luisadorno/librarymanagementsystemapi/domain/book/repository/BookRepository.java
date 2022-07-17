package com.luisadorno.librarymanagementsystemapi.domain.book.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisadorno.librarymanagementsystemapi.domain.book.model.Book;

public interface BookRepository extends JpaRepository<Book, UUID> {
    Optional<Book> getByTitle(String title);
}
