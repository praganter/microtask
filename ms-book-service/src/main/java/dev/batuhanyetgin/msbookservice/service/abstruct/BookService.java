package dev.batuhanyetgin.msbookservice.service.abstruct;

import dev.batuhanyetgin.msbookservice.dto.BookDto;
import dev.batuhanyetgin.msbookservice.exception.BookAlreadyRegisteredException;
import dev.batuhanyetgin.msbookservice.exception.BookNotFoundException;

import java.util.List;

public interface BookService {

    void addBook(BookDto bookDto) throws BookAlreadyRegisteredException;

    List<BookDto> getAll();

    BookDto getByIsbn(Long isbn) throws BookNotFoundException;

    boolean isExists(Long isbn);

    void removeStock(BookDto bookDto) throws BookNotFoundException;
}
