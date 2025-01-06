package com.wspa.projectjava.controller;

import com.wspa.projectjava.model.payload.BookDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BookController {

    @PostMapping
    @Operation(
            description = "Creates book.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully created",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request!"
                    ),
                    @ApiResponse(responseCode = "400", ref = "defaultBadRequest"),
                    @ApiResponse(responseCode = "401", ref = "defaultUnauthorized"),
                    @ApiResponse(responseCode = "403", ref = "defaultForbidden"),
                    @ApiResponse(responseCode = "500", ref = "defaultInternalServerError")
            }
    )
    ResponseEntity<?> saveBook(BookDto book);
    @GetMapping
    @Operation(
            description = "Returns all books.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Returns all books.",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                                        [
                                                                          {
                                                                            "name": "string11",
                                                                            "description": "string11"
                                                                          },
                                                                          {
                                                                            "name": "string11",
                                                                            "description": "string11"
                                                                          },
                                                                          {
                                                                            "name": "4",
                                                                            "description": "4"
                                                                          }
                                                                        ]                                   
                                                            """
                                            )
                                    }
                            )
                    ),
                    @ApiResponse(responseCode = "400", ref = "defaultBadRequest"),
                    @ApiResponse(responseCode = "401", ref = "defaultUnauthorized"),
                    @ApiResponse(responseCode = "403", ref = "defaultForbidden"),
                    @ApiResponse(responseCode = "500", ref = "defaultInternalServerError")
            }
    )
    ResponseEntity<List<BookDto>> getBooks();

    @GetMapping(path = "/{id}")
    @Operation(
            description = "Fetches an book by id.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully returned the book by id.",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = @ExampleObject(value = """
                                                   
                                                                {
                                                                    "name": "string11",
                                                                     "description": "string11"
                                                                   }
                                                  
                                            """)
                            )
                    ),
                    @ApiResponse(responseCode = "400", ref = "defaultBadRequest"),
                    @ApiResponse(responseCode = "401", ref = "defaultUnauthorized"),
                    @ApiResponse(responseCode = "403", ref = "defaultForbidden"),
                    @ApiResponse(responseCode = "500", ref = "defaultInternalServerError")
            }
    )
    ResponseEntity<BookDto> getBook(@PathVariable Integer id);

    @DeleteMapping(path = "/{id}")
    @Operation(
            description = "Delete book.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully created",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request!"
                    ),
                    @ApiResponse(responseCode = "400", ref = "defaultBadRequest"),
                    @ApiResponse(responseCode = "401", ref = "defaultUnauthorized"),
                    @ApiResponse(responseCode = "403", ref = "defaultForbidden"),
                    @ApiResponse(responseCode = "500", ref = "defaultInternalServerError")
            }
    )
    ResponseEntity<?> deleteBook(@PathVariable Integer id);

    @PutMapping(path = "/{id}")
    @Operation(
            description = "Update book.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully created",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request!"
                    ),
                    @ApiResponse(responseCode = "400", ref = "defaultBadRequest"),
                    @ApiResponse(responseCode = "401", ref = "defaultUnauthorized"),
                    @ApiResponse(responseCode = "403", ref = "defaultForbidden"),
                    @ApiResponse(responseCode = "500", ref = "defaultInternalServerError")
            }
    )
    ResponseEntity<?> updateBook(@PathVariable Integer id, @RequestBody BookDto bookDto);
}
