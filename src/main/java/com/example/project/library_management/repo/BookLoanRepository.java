package com.example.project.library_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.library_management.entity.Book;
import com.example.project.library_management.entity.BookLoan;
import com.example.project.library_management.entity.LoanStatus;

@Repository
public interface BookLoanRepository extends JpaRepository<BookLoan,Long>{
    int countByBookAndStatus(Book book, LoanStatus status);




}
