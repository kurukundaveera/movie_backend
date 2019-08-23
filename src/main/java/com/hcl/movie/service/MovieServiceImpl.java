package com.hcl.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.movie.dto.MovieResponseDto;
import com.hcl.movie.entity.Movie;
import com.hcl.movie.exception.MovieNotFoundException;
import com.hcl.movie.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	private static Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
	@Autowired
	MovieRepository movieRepository;

	/*
	 * this method is written to get all the movies list.
	 */
	@Override
	public List<MovieResponseDto> getAllMovies() {
		logger.info("inside the getAllMovies method");
		List<MovieResponseDto> responseList = new ArrayList<>();
		List<Movie> movieList = movieRepository.findAll();
		if (movieList.isEmpty())
			throw new MovieNotFoundException("Movie not found");

		movieList.stream().forEach(c -> {
			MovieResponseDto response = new MovieResponseDto();
			BeanUtils.copyProperties(c, response);
			responseList.add(response);
		});
		return responseList;
	}

}
