package dev.batuhanyetgin.mscustomer.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<String> handleAuthException(UserNotFoundException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleAuthException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
