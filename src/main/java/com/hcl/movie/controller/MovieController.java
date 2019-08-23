package com.hcl.movie.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.movie.dto.MovieResponseDto;
import com.hcl.movie.service.MovieService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class MovieController {
	private static Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	MovieService movieService;
	@GetMapping("/getMovies")
	public ResponseEntity<List<MovieResponseDto>> getMoviesList(){
		logger.info("inside the controller getMoviesList method");
		List<MovieResponseDto> response = movieService.getAllMovies();
		return  new ResponseEntity<>(response , HttpStatus.OK);
	}

}
