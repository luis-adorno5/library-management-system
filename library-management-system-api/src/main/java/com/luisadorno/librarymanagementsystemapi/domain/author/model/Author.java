package com.luisadorno.librarymanagementsystemapi.domain.author.model;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.luisadorno.librarymanagementsystemapi.domain.book.model.Book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(name = "author_id")
    private UUID id;

    private String firstName;

    private String lastName;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    private Set<Book> booksWritten;

    public Author(String firstName, String lastName, Set<Book> booksWritten) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.booksWritten = booksWritten;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Book> getBooksWritten() {
        return booksWritten;
    }

    public void addBookWritten(Book book) {
        booksWritten.add(book);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Author)) {
            return false;
        }
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(firstName, author.firstName)
                && Objects.equals(lastName, author.lastName) && Objects.equals(booksWritten, author.booksWritten);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, booksWritten);
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }

}
