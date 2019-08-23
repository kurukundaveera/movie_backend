/**
 * 
 */
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

import com.hcl.movie.dto.TheatreDetailsResponseByIdDto;
import com.hcl.movie.exception.NoMoviePresentException;
import com.hcl.movie.service.TheatreDetailsServiceImpl;

/**
 * @author Gurpreet Singh This is the controller class for getting the movie
 *         details by movieId
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class TheatreDetailsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TheatreDetailsController.class);

	@Autowired
	TheatreDetailsServiceImpl movieDetailsServiceImpl;

	/**
	 * This method is use to get the movie details by passing the movieId
	 * 
	 * @param Integer movieId
	 * @return MovieDetailsResponseByIdDto which includes theatreId, name area,
	 *         movieId.
	 * @exception NoMoviePresentException if no movie is found.
	 */
	
	@GetMapping("/movieDetails/{movieId}")
	public ResponseEntity<List<TheatreDetailsResponseByIdDto>> getTheatreDetailsById(@PathVariable Integer movieId) {
		LOGGER.info("in get movie details by id method");
		List<TheatreDetailsResponseByIdDto> response = movieDetailsServiceImpl.getTheatreDetailsById(movieId);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
