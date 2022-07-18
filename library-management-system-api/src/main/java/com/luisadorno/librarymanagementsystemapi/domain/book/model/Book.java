package com.luisadorno.librarymanagementsystemapi.domain.book.model;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.luisadorno.librarymanagementsystemapi.domain.author.model.Author;
import com.luisadorno.librarymanagementsystemapi.domain.category.model.Category;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(name = "book_id")
    private UUID id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Set<Category> categoryId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    private String publicationDate;

    private Byte copiesOwned;

    public Book(String title, Set<Category> categoryId, Set<Author> authors, String publicationDate,
            Byte copiesOwned) {
        this.title = title;
        this.categoryId = categoryId;
        this.authors = authors;
        this.publicationDate = publicationDate;
        this.copiesOwned = copiesOwned;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Set<Category> getCategoryId() {
        return categoryId;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public Byte getCopiesOwned() {
        return copiesOwned;
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
                && Objects.equals(categoryId, book.categoryId) && Objects.equals(authors, book.authors)
                && Objects.equals(publicationDate, book.publicationDate)
                && Objects.equals(copiesOwned, book.copiesOwned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, categoryId, authors, publicationDate, copiesOwned);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", title, publicationDate, copiesOwned);
    }

}
