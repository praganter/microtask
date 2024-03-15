package dev.batuhanyetgin.msbookservice.service.impl;

import dev.batuhanyetgin.msbookservice.dto.BookDto;
import dev.batuhanyetgin.msbookservice.entity.BookEntity;
import dev.batuhanyetgin.msbookservice.exception.BookAlreadyRegisteredException;
import dev.batuhanyetgin.msbookservice.exception.BookNotFoundException;
import dev.batuhanyetgin.msbookservice.repository.BookRepository;
import dev.batuhanyetgin.msbookservice.service.abstruct.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addBook(BookDto bookDto) throws BookAlreadyRegisteredException {
        if (bookRepository.existsByIsbn(bookDto.getIsbn())) {
            throw new BookAlreadyRegisteredException("Book already registered by isbn: " + bookDto.getIsbn());
        }
        bookRepository.save(modelMapper.map(bookDto, BookEntity.class));
    }

    @Override
    public List<BookDto> getAll() {
        return bookRepository.findAll()
                .stream().map(bookEntity -> modelMapper.map(bookEntity, BookDto.class))
                .toList();
    }

    @Override
    public BookDto getByIsbn(Long isbn) throws BookNotFoundException {
        if (!bookRepository.existsByIsbn(isbn)) {
            throw new BookNotFoundException("Book not found with isbn: " + isbn);
        }
        return modelMapper.map(bookRepository.getByIsbn(isbn), BookDto.class);
    }

    @Override
    public boolean isExists(Long isbn) {
        return bookRepository.existsByIsbn(isbn);
    }

    @Override
    public void removeStock(BookDto stockDto) throws BookNotFoundException {
        BookDto bookDto;
        try {
            bookDto = getByIsbn(stockDto.getIsbn());
        } catch (Exception e) {
            throw new BookNotFoundException("Book not found with isbn: " + stockDto.getIsbn());
        }
        bookRepository.save(modelMapper.map(stockDto, BookEntity.class));
        log.info("Quantity updated" + bookDto);
    }

}
