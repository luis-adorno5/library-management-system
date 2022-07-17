package com.luisadorno.librarymanagementsystemapi.domain.category.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisadorno.librarymanagementsystemapi.domain.category.model.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
