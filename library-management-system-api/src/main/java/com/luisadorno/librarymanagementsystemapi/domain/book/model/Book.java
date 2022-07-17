package com.luisadorno.librarymanagementsystemapi.domain.book.model;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.luisadorno.librarymanagementsystemapi.domain.category.model.Category;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(name = "book_id")
    private UUID id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "book_id")
    private Set<Category> categoryId;

    private String publicationDate;

    private Byte copiesOwned;

    public Book(String title, Set<Category> categoryId, String publicationDate, Byte copiesOwned) {
        this.title = title;
        this.categoryId = categoryId;
        this.publicationDate = publicationDate;
        this.copiesOwned = copiesOwned;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title)
                && Objects.equals(categoryId, book.categoryId) && Objects.equals(publicationDate, book.publicationDate)
                && Objects.equals(copiesOwned, book.copiesOwned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, categoryId, publicationDate, copiesOwned);
    }

}
