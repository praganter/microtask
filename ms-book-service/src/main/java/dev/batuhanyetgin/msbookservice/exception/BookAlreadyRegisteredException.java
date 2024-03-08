package dev.batuhanyetgin.msbookservice.exception;

public class BookAlreadyRegisteredException extends Exception {

    private static final long serialVersionUID = 1L;


    public BookAlreadyRegisteredException(String message) {
        super(message);
    }
}
