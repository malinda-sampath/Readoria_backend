package com.readoria.book_service.repositories;

import com.readoria.book_service.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findByTitle(String title);
    Optional<Book> findByBarcodeId(String barcodeId);
}
