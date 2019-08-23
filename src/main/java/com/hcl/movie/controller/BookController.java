package com.hcl.movie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.movie.dto.BookRequestDto;
import com.hcl.movie.dto.BookResponseDto;
import com.hcl.movie.service.BookService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class BookController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

	@Autowired
	BookService bookService;

	@PostMapping("/book")
	public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto bookRequestDto) {
		LOGGER.info("book controller");
		return new ResponseEntity<BookResponseDto>(bookService.book(bookRequestDto), HttpStatus.CREATED);

	}

}
