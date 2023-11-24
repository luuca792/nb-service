package ctu.se.oda.model11.errors.exceptions;

import ctu.se.oda.model11.errors.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
        ex.printStackTrace();
        return new ResponseEntity<>(ErrorDetails.builder().detail(request.getDescription(false)).createAt(LocalDateTime.now()).message(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }
}
