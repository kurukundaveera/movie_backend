package com.hcl.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.movie.dto.SearchRequestDto;
import com.hcl.movie.dto.SearchResponseDto;
import com.hcl.movie.entity.Movie;
import com.hcl.movie.exception.MovieNotFoundException;
import com.hcl.movie.repository.MovieRepository;

/**
 * 
 * @author DeepikaSivarajan
 *
 */
@Service
public class SearchServiceImpl implements SearchService {
	private static Logger logger = LoggerFactory.getLogger("SearchController.class");
	@Autowired
	MovieRepository movieRepository;

	/**
	 * 
	 * This method is intended to search movie names(like search)
	 * 
	 * @param movieName is the input request
	 * @return it returns SearchResponseDto list
	 */

	@Override
	public List<SearchResponseDto> getMovies(SearchRequestDto serarchRequestDto ) {

		List<SearchResponseDto> responseList = new ArrayList<>();
		List<Movie> movie = movieRepository.findByNameStartsWithIgnoreCase(serarchRequestDto.getName());
		if (movie.isEmpty()) {
			throw new MovieNotFoundException("Movies not found");
		} else {
			movie.stream().forEach(m -> {
				SearchResponseDto response = new SearchResponseDto();
				BeanUtils.copyProperties(m, response);
				responseList.add(response);
			});
		}
		logger.info("movies fetched");
		return responseList;

	}
}