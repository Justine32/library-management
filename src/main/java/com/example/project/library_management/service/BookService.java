package com.example.project.library_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.library_management.DTO.BookDTO;
import com.example.project.library_management.DTO.BookMapper;
import com.example.project.library_management.entity.Book;
import com.example.project.library_management.entity.Genre;
import com.example.project.library_management.entity.LoanStatus;
import com.example.project.library_management.repo.BookLoanRepository;
import com.example.project.library_management.repo.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookLoanRepository bookLoanRepository;

   public List<BookDTO> searchBooks(String title, String authorName, Genre genre) {
    return bookRepository.findAll()
        .stream()
        .map(book -> {
            int availableCopies = book.getTotalCopies() - getActiveLoansCount(book);
            return BookMapper.toDTO(book, availableCopies);
        })
        .collect(Collectors.toList());

   



}

   private Integer getActiveLoansCount(Book book) {
    return bookLoanRepository.countByBookAndStatus(book, LoanStatus.ACTIVE);
   }

   public Object searchBooks(String isbn, String title, String authorName, String genre, Integer publicationYearFrom,
        Integer publicationYearTo, String publisher, Boolean isAvailable, int page, int size, String sort) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'searchBooks'");
   }

   
}
