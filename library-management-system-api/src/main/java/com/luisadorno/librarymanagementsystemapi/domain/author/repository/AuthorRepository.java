package com.luisadorno.librarymanagementsystemapi.domain.author.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisadorno.librarymanagementsystemapi.domain.author.model.Author;

public interface AuthorRepository extends JpaRepository<Author, UUID> {

}
