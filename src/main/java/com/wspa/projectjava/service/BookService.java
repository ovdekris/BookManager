package com.wspa.projectjava.service;

import com.wspa.projectjava.exception.BookNotFoundException;
import com.wspa.projectjava.mapper.BookMapper;
import com.wspa.projectjava.model.entity.Book;
import com.wspa.projectjava.model.payload.BookDto;
import com.wspa.projectjava.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public void saveBook(BookDto bookDto) {
        log.info("Try to save book with name {}", bookDto.getName());
        try {
            bookRepository.save(bookMapper.toBook(bookDto));
            log.info("Successfully saved book with name {}", bookDto.getName());
        } catch (Exception e) {
            log.error("Error when try to save book with name {}", bookDto.getName());
            throw new RuntimeException(e);
        }
    }

    public List<BookDto> getBooks(){
        return bookMapper.fromBookList(bookRepository.findAll());
    }

    public BookDto getBook(Integer id){
        return bookMapper.fromBook(bookRepository.findBookById(id));
    }

    public void deleteBook(Integer id) throws BookNotFoundException {
        Book book = bookRepository.findBookById(id);
        if (book == null){
            log.error("Book with Id {} not found", id);
            throw new BookNotFoundException();
        }
        bookRepository.deleteById(id);
        log.info("Book with id {} deleted", id);
    }

    @Transactional
    public void updateBook(Integer id, BookDto bookDto) throws BookNotFoundException {
        Book book = bookRepository.findBookById(id);
        if (book == null) {
            log.error("Book with Id {} not found", id);
            throw new BookNotFoundException();
        }

        String name = bookDto.getName();
        if (name != null) {
            book.setName(name);
        }
        String description = bookDto.getDescription();
        if (description != null) {
            book.setDescription(description);
        }
        try{
            bookRepository.save(book);
            log.info("Successfully saved book with name {}", bookDto.getName());
        } catch (Exception e){
            log.error("Error when try to save book with name {}", bookDto.getName());
            throw new RuntimeException(e);
        }
    }
}
