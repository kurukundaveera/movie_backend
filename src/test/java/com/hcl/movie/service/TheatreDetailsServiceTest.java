/**
 * 
 */
package com.hcl.movie.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.movie.dto.TheatreDetailsResponseByIdDto;
import com.hcl.movie.entity.Book;
import com.hcl.movie.entity.Movie;
import com.hcl.movie.entity.Theatre;
import com.hcl.movie.repository.MovieTheatreRepository;
import com.hcl.movie.repository.TheatreDetailsRepository;

/**
 * @author Gurpreet Singh
 *
 */



@RunWith(MockitoJUnitRunner.class)

public class TheatreDetailsServiceTest {
	
	@InjectMocks
	TheatreDetailsServiceImpl theatreDetailsServiceImpl;
	
	@Mock
	TheatreDetailsRepository theatreDetailsRepository;
	
	@Mock
	MovieTheatreRepository movieTheatreRepository;
	
	TheatreDetailsResponseByIdDto theatreDetailsResponseByIdDto;
	Theatre theatre;
	Movie movie;
	Book book;
	
	@Before
	public void setup()
	{
		theatreDetailsResponseByIdDto=getTheatreDetailsResponseByIdDto();
	}

	public TheatreDetailsResponseByIdDto getTheatreDetailsResponseByIdDto()
	{
		TheatreDetailsResponseByIdDto theatreDetailsResponseByIdDto = new TheatreDetailsResponseByIdDto();
		theatreDetailsResponseByIdDto.setArea("whitefield");
		theatreDetailsResponseByIdDto.setTheatreName("inox");
		return theatreDetailsResponseByIdDto;
	}
}
