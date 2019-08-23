package com.hcl.movie.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.movie.dto.SearchResponseDto;
import com.hcl.movie.service.SearchService;

/**
 * 
 * @author DeepikaSivarajan
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class SearchController {
	private static Logger logger = LoggerFactory.getLogger("SearchController.class");
	@Autowired
	SearchService searchService;

	/**
	 * 
	 * This method is intended to search movie names(like search)
	 * 
	 * @param movieName is the input request
	 * @return it returns SearchResponseDto list
	 */

	@GetMapping("/search/{name}")
	public ResponseEntity<List<SearchResponseDto>> getMovies(@PathVariable String name) {
		logger.info("search movies");
		List<SearchResponseDto> response = searchService.getMovies(name);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
