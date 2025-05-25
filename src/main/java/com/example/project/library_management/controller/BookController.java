package com.example.project.library_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.library_management.DTO.BookDTO;
import com.example.project.library_management.entity.Genre;
import com.example.project.library_management.service.BookService;
@RestController
@RequestMapping("/api/v1/books")

public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/search")
    public ResponseEntity<Object> searchBooks(
          @RequestParam(required = false) String isbn,
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String authorName,
        @RequestParam(required = false) String genre,
        @RequestParam(required = false) Integer publicationYearFrom,
        @RequestParam(required = false) Integer publicationYearTo,
        @RequestParam(required = false) String publisher,
        @RequestParam(required = false) Boolean isAvailable,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size,
        @RequestParam(defaultValue = "title,asc") String sort) {
    return ResponseEntity.ok(bookService.searchBooks(isbn, title, authorName, genre, publicationYearFrom, publicationYearTo, publisher, isAvailable, page, size, sort));
}


}
