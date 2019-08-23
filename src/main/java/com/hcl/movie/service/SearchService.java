package com.hcl.movie.service;

import java.util.List;

import com.hcl.movie.dto.SearchRequestDto;
import com.hcl.movie.dto.SearchResponseDto;

public interface SearchService {

//	List<SearchResponseDto> getMovies(String name);
	List<SearchResponseDto> getMovies(SearchRequestDto serarchRequestDto);

	

}
