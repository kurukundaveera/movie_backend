/**
 * 
 */
package com.hcl.movie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.movie.dto.TheatreDetailsResponseByIdDto;
import com.hcl.movie.entity.MovieTheatre;
import com.hcl.movie.entity.Theatre;
import com.hcl.movie.exception.NoMoviePresentException;
import com.hcl.movie.repository.MovieDetailsRepository;
import com.hcl.movie.repository.MovieTheatreRepository;
import com.hcl.movie.repository.TheatreDetailsRepository;

/**
 * @author Gurpreet Singh
 *
 */
@Service
public class TheatreDetailsServiceImpl implements TheatreDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TheatreDetailsServiceImpl.class);

	@Autowired
	TheatreDetailsRepository theatreDetailsRepository;
	
	@Autowired
	MovieDetailsRepository movieDetailsRepository;
	
	@Autowired
	MovieTheatreRepository movieTheatreRepository;
	
	
	/**
	 * This method is use to get the movie details by passing the movieId
	 * 
	 * @param Integer movieId
	 * @return MovieDetailsResponseByIdDto which includes theatreId, name area,
	 *         movieId.
	 * @exception NoMoviePresentException if no movie is found.
	 */
	@Override
	public List<TheatreDetailsResponseByIdDto> getTheatreDetailsById(Integer movieId) {
		LOGGER.info("in get all theatres by movieId");
		List<TheatreDetailsResponseByIdDto> responseList = new ArrayList<>();
		List<MovieTheatre> movies = movieTheatreRepository.findByMovieId(movieId);
		if(movies.isEmpty())
			throw new NoMoviePresentException("No movie found");
		else
		movies.stream().forEach(b->{
			Optional<Theatre> theatre = theatreDetailsRepository.findById(b.getTheatreId());
			TheatreDetailsResponseByIdDto movieDetailsResponseDto = new TheatreDetailsResponseByIdDto();
			movieDetailsResponseDto.setMovieId(movies.get(0).getMovieId());
			movieDetailsResponseDto.setArea(theatre.get().getArea());
			movieDetailsResponseDto.setName(theatre.get().getName());
			BeanUtils.copyProperties(b, movieDetailsResponseDto);
			responseList.add(movieDetailsResponseDto);
		});
		
		return responseList;
		
	}

}
