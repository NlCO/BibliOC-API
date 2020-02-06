package fr.nlco.biblioc.bibliocapi.service;

import fr.nlco.biblioc.bibliocapi.dto.BookStockDto;
import fr.nlco.biblioc.bibliocapi.model.Book;
import fr.nlco.biblioc.bibliocapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Implémentation de l'interface BookService
 */
@Service("BookService")
public class BookServiceImpl implements BookService {

    private final BookRepository _BookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        _BookRepository = bookRepository;
    }

    /**
     * Methode retournant la liste des livres de la bibliothèque avec leur disponibilité
     *
     * @return liste de livres
     */
    @Override
    public List<BookStockDto> getBooksStock() {
        List<Book> books = _BookRepository.findAll();
        List<BookStockDto> bookStock = new ArrayList<>();
        for (Book b : books
        ) {
            Integer nbCopy = b.getCopies().size();
            Integer nbAvailable = b.getCopies().stream().filter(copy -> Objects.isNull(copy.getLoan())).collect(Collectors.toList()).size();
            BookStockDto t = new BookStockDto(b.getTitle(), b.getAuthor(), b.getType(), nbCopy, nbAvailable);
            bookStock.add(t);
        }
        return bookStock;
    }
}
