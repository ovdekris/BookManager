package com.wspa.projectjava.controller;

import com.wspa.projectjava.exception.BookNotFoundException;
import com.wspa.projectjava.model.payload.BookDto;
import com.wspa.projectjava.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/books")
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    @Override
    public ResponseEntity<?> saveBook(@RequestBody BookDto bookDto) {
        bookService.saveBook(bookDto);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<BookDto>> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @Override
    public ResponseEntity<BookDto> getBook(Integer id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @Override
    public ResponseEntity<?> deleteBook(Integer id) {
        try{
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
        } catch (BookNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> updateBook(Integer id, BookDto bookDto) {
        try {
            bookService.updateBook(id, bookDto);
            return ResponseEntity.noContent().build();
        } catch (BookNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
