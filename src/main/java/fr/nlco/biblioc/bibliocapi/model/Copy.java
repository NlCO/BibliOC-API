package fr.nlco.biblioc.bibliocapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe repésentant les livres de la bibliothèque
 */
@Entity
@Getter
@Setter
public class Copy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer copyId;

    @ManyToOne
    private Book book;

    @OneToOne(mappedBy = "copy", cascade = CascadeType.ALL)
    private Loan loan;

    public Copy() {
    }

    public Copy(Book book, Loan loan) {
        this.book = book;
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "Copy{" +
                "copyId=" + copyId +
                ", book=" + book +
                ", loan=" + loan +
                '}';
    }
}
