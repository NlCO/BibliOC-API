package fr.nlco.biblioc.bibliocapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant les ouvrages
 */
@Entity
@Getter
@Setter
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column(unique = true)
    private String isbn;

    private String title;
    private String author;
    private String type;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Copy> copies = new ArrayList<>();

    public Book() {
    }

    public Book(String ISBN, String title, String author, String type, List<Copy> copies) {
        this.isbn = ISBN;
        this.title = title;
        this.author = author;
        this.type = type;
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", copies=" + copies +
                '}';
    }
}
