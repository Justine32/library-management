package com.example.project.library_management.DTO;

import com.example.project.library_management.entity.Book;

public class BookMapper {
    public static BookDTO toDTO(Book book, int availableCopies) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(book.getAuthor().getId());
        authorDTO.setName(book.getAuthor().getName());
        authorDTO.setBirthDate(book.getAuthor().getBirthDate());

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setPublicationYear(book.getPublicationYear());
        bookDTO.setPublisher(book.getPublisher());
        bookDTO.setTotalCopies(book.getTotalCopies());
        bookDTO.setAvailableCopies(availableCopies);
        bookDTO.setAuthor(authorDTO);

        return bookDTO;
    }


}
