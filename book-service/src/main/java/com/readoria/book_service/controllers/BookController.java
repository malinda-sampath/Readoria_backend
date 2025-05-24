package com.readoria.book_service.controllers;

import com.readoria.book_service.dtos.request.BookSaveRequestDTO;
import com.readoria.book_service.entities.Book;
import com.readoria.book_service.services.BookService;
import com.readoria.book_service.utils.ResponseBuilder;
import com.readoria.book_service.utils.StandardResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse<String>> saveBook(@RequestBody @Valid BookSaveRequestDTO bookSaveRequestDTO){
        String message = bookService.saveBook(bookSaveRequestDTO);
        return ResponseBuilder.success(message, null);
    }

    @GetMapping("/get/{barcode_id}")
    public ResponseEntity<StandardResponse<Book>> getBookById(@PathVariable String barcode_id) {
        Book book = bookService.getBookById(barcode_id);
        return ResponseBuilder.success("Book retrieved successfully", book);
    }

    @GetMapping("/get-all")
    public ResponseEntity<StandardResponse<List<Book>>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseBuilder.success("Books retrieved successfully", books);
    }

    @DeleteMapping("/delete/{barcode_id}")
    public ResponseEntity<StandardResponse<String>> deleteBook(@PathVariable String barcode_id) {
        String message = bookService.deleteBook(barcode_id);
        return ResponseBuilder.success(message, null);
    }
}
