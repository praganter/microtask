package dev.batuhanyetgin.msorder.exception;

import java.io.Serial;

public class BookNotFoundException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;


    public BookNotFoundException(String message) {
        super(message);
    }
}