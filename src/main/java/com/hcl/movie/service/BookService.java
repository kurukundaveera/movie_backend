package com.hcl.movie.service;

import com.hcl.movie.dto.BookRequestDto;
import com.hcl.movie.dto.BookResponseDto;

public interface BookService {

	BookResponseDto book(BookRequestDto bookRequestDto);

}
