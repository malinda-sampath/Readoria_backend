package com.readoria.book_service.advisor;

import com.readoria.book_service.exceptions.BookAlreadyExistsException;
import com.readoria.book_service.exceptions.ResourceNotFoundException;
import com.readoria.book_service.utils.ResponseBuilder;
import com.readoria.book_service.utils.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Handle MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardResponse<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseBuilder.badRequest("Validation error", errors);
    }

    // Handle BookAlreadyExistsException
    @ExceptionHandler(BookAlreadyExistsException.class)
    public ResponseEntity<StandardResponse<String>> handleBookAlreadyExists(BookAlreadyExistsException ex) {
        logger.error("Book already exists: {}", ex.getMessage());
        return ResponseBuilder.conflict(ex.getMessage(), null);
    }

    // Handle ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardResponse<String>> handleResourceNotFound(ResourceNotFoundException ex) {
        logger.error("Resource not found: {}", ex.getMessage());
        return ResponseBuilder.notFound(ex.getMessage());
    }
}
