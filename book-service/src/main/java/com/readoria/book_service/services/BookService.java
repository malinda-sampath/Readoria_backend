package com.readoria.book_service.services;

import com.readoria.book_service.dtos.request.BookSaveRequestDTO;
import com.readoria.book_service.entities.Book;

import java.util.List;

public interface BookService {
    String saveBook(BookSaveRequestDTO bookSaveRequestDTO);

    Book getBookById(String barcode_id);

    List<Book> getAllBooks();

    String deleteBook(String barcode_id);
}
