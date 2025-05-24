package com.readoria.book_service.services.IMPL;

import com.readoria.book_service.dtos.request.BookSaveRequestDTO;
import com.readoria.book_service.entities.Book;
import com.readoria.book_service.exceptions.BookAlreadyExistsException;
import com.readoria.book_service.exceptions.ResourceNotFoundException;
import com.readoria.book_service.repositories.BookRepository;
import com.readoria.book_service.services.BookService;
import com.readoria.book_service.utils.barcode.BarcodeID;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public String saveBook(BookSaveRequestDTO bookSaveRequestDTO) {
        Optional<Book> existsBook = bookRepository.findByTitle(bookSaveRequestDTO.getTitle());
        if (existsBook.isPresent()) {
            throw new BookAlreadyExistsException("Book with title '" + bookSaveRequestDTO.getTitle() + "' already exists");
        }

        Book book = modelMapper.map(bookSaveRequestDTO, Book.class);
        String barcodeId = BarcodeID.generateUniqueID();
        book.setBarcodeId(barcodeId);
        bookRepository.save(book);
        return "Book saved successfully";
    }

    @Override
    public Book getBookById(String barcode_id) {
        return bookRepository.findByBarcodeId(barcode_id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with barcode ID '" + barcode_id + "' not found"));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public String deleteBook(String barcode_id) {
        Book book = bookRepository.findByBarcodeId(barcode_id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with barcode ID '" + barcode_id + "' not found"));

        bookRepository.delete(book);
        return "Book deleted successfully";
    }
}

