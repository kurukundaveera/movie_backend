package com.hcl.movie.controller;

import java.util.List;

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

import com.hcl.movie.dto.SearchRequestDto;
import com.hcl.movie.dto.SearchResponseDto;
import com.hcl.movie.service.SearchService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class SearchController {
	private static Logger logger = LoggerFactory.getLogger("SearchController.class");
	@Autowired
	SearchService searchService;

	@PostMapping("/search")
	public ResponseEntity<List<SearchResponseDto>> getMovies(@RequestBody SearchRequestDto serarchRequestDto ) {
		logger.info("search movies");
		List<SearchResponseDto> response = searchService.getMovies(serarchRequestDto);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
