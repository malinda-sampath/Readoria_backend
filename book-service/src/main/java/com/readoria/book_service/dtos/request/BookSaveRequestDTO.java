package com.readoria.book_service.dtos.request;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookSaveRequestDTO {

    @NotBlank(message="Title is required")
    private String title;
    private String isbn;
    private String author;
    private String publisher;
    private String description;
    private String language;
    private String genre;
    private LocalDateTime published_at;
    private int total_copies;
    private boolean is_online_available;
}
