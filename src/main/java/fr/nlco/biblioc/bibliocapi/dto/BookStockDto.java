package fr.nlco.biblioc.bibliocapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Classe DTO décrivant la disponiblité d'un livre
 */
@Getter
@Setter
public class BookStockDto implements Serializable {
    private String title;
    private String author;
    private String type;
    private Integer nbCopy;
    private Integer nbAvailable;

    public BookStockDto() {
    }

    public BookStockDto(String title, String author, String type, Integer nbCopy, Integer nbAvailable) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.nbCopy = nbCopy;
        this.nbAvailable = nbAvailable;
    }

    @Override
    public String toString() {
        return "BookStockDto{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", nbCopy=" + nbCopy +
                ", nbAvailable=" + nbAvailable +
                '}';
    }
}
