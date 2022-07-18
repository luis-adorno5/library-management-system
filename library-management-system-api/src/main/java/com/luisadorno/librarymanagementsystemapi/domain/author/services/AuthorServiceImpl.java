package com.luisadorno.librarymanagementsystemapi.domain.author.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisadorno.librarymanagementsystemapi.core.exceptions.ResourceNotFoundException;
import com.luisadorno.librarymanagementsystemapi.domain.author.model.Author;
import com.luisadorno.librarymanagementsystemapi.domain.author.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Iterable<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getById(UUID id) {
        Author author = authorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("An author with id: {%s} does not exist.", id)));
        return author;
    }

}
