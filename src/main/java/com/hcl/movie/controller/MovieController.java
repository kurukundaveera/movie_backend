package com.hcl.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.movie.dto.MovieResponseDto;
import com.hcl.movie.entity.Movie;
import com.hcl.movie.service.MovieService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class MovieController {

	
	@Autowired
	MovieService movieService;
	
	public String hello() {
		return "success";
	}
	
	public ResponseEntity<List<Movie>> getMoviesList(){
		
		List<MovieResponseDto> response = movieService.getAllMovies();
		
		return  new ResponseEntity<>(response , HttpStatus.OK);
	}

}
