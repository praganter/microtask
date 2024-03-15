package dev.batuhanyetgin.msbookservice.controller;

import dev.batuhanyetgin.msbookservice.dto.BookDto;
import dev.batuhanyetgin.msbookservice.exception.BookAlreadyRegisteredException;
import dev.batuhanyetgin.msbookservice.exception.BookNotFoundException;
import dev.batuhanyetgin.msbookservice.service.abstruct.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestBody BookDto bookDto) throws BookAlreadyRegisteredException {
        bookService.addBook(bookDto);
        return ResponseEntity.ok("Book registered successfully");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BookDto>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDto> getDetails(@PathVariable Long isbn) throws BookNotFoundException {
        return ResponseEntity.ok(bookService.getByIsbn(isbn));
    }

    @GetMapping("/isExists/{isbn}")
    public boolean isExists(@PathVariable Long isbn) {
        return bookService.isExists(isbn);
    }

    @PostMapping("/removeStock")
    public void removeStock(@RequestBody BookDto bookDto) throws BookNotFoundException {
        bookService.removeStock(bookDto);
    }


}
