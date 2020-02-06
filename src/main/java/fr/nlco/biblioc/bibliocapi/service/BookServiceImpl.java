package fr.nlco.biblioc.bibliocapi.service;

import fr.nlco.biblioc.bibliocapi.dto.BookStockDto;
import fr.nlco.biblioc.bibliocapi.mapper.BookStockMapper;
import fr.nlco.biblioc.bibliocapi.model.Book;
import fr.nlco.biblioc.bibliocapi.repository.BookRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implémentation de l'interface BookService
 */
@Service("BookService")
public class BookServiceImpl implements BookService {

    private BookStockMapper mapper = Mappers.getMapper(BookStockMapper.class);

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
        return mapper.booksToBookStockDtos(books);
    }
}
