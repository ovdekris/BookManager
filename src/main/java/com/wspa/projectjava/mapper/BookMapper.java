package com.wspa.projectjava.mapper;

import com.wspa.projectjava.model.entity.Book;
import com.wspa.projectjava.model.payload.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public Book toBook(BookDto bookDto) {
        return  Book.builder()
                .description(bookDto.getDescription())
                .name(bookDto.getName())
                .build();
    }

    public BookDto fromBook(Book book) {
        return new BookDto(book.getName(), book.getDescription());
    }

    public List<BookDto> fromBookList(List<Book> books) {
        return books.stream().map(this::fromBook).collect(Collectors.toList());
    }
}
