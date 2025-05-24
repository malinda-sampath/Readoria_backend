package com.readoria.book_service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "barcode_id")
    private String barcodeId;
    private String title;
    private String isbn;
    private String author;
    private String publisher;
    private String description;
    private String language;
    private String genre;
    private LocalDateTime published_at;
    private int total_copies;
    private String barcode_url;
    private boolean is_online_available;
    private String cover_url;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
}
