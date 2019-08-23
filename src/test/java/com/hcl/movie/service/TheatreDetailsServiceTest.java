/**
 * 
 */
package com.hcl.movie.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.movie.dto.TheatreDetailsResponseByIdDto;
import com.hcl.movie.entity.Book;
import com.hcl.movie.entity.Movie;
import com.hcl.movie.entity.MovieTheatre;
import com.hcl.movie.entity.Theatre;
import com.hcl.movie.exception.NoMoviePresentException;
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
	List<Movie> movie1;
	Book book;
	MovieTheatre movieth;
	List<MovieTheatre> mv;
	List<TheatreDetailsResponseByIdDto> theatredetails;
	
	@Before
	public void setup()
	{
		theatreDetailsResponseByIdDto=getTheatreDetailsResponseByIdDto();
		theatre = getTheatre();
		movie = getMovie();
		book = getBook();
		movieth = getMovieTheatre();
		movie1 = new ArrayList<>();
		mv = new ArrayList<>();
		theatredetails = new ArrayList<>();
		movie1.add(movie);
		mv.add(movieth);
		theatredetails.add(theatreDetailsResponseByIdDto);
	}

	public TheatreDetailsResponseByIdDto getTheatreDetailsResponseByIdDto()
	{
		TheatreDetailsResponseByIdDto theatreDetailsResponseByIdDto = new TheatreDetailsResponseByIdDto();
		theatreDetailsResponseByIdDto.setArea("whitefield");
		theatreDetailsResponseByIdDto.setTheatreName("inox");
		theatreDetailsResponseByIdDto.setMovieId(1);
		theatreDetailsResponseByIdDto.setTheatreId(1);
		return theatreDetailsResponseByIdDto;
	}
	
	public Theatre getTheatre()
	{
		Theatre theatre = new Theatre();
		theatre.setArea("whitefield");
		theatre.setName("inox");
		return theatre;
	}
	
	public Movie getMovie()
	{
		Movie movie = new Movie();
		movie.setLanuage("English");
		movie.setName("Avengers");
		return movie;
	}
	
	public MovieTheatre getMovieTheatre()
	{
		MovieTheatre movieth = new MovieTheatre();
		movieth.setMovieId(1);
		movieth.setMovieTheatreId(1);
		movieth.setTheatreId(1);
		return movieth;
	}
	public Book getBook()
	{
		Book book = new Book();
		book.setBookId(1);
		book.setMovieId(1);
		book.setNumberOfSeats(4);
		book.setTheatreId(1);
		book.setTotalPrice(200D);
		return book;
	}
	
	@Test
	public void testGetTheatreDetailsById()
	{
		Mockito.when(movieTheatreRepository.findByMovieId(Mockito.anyInt())).thenReturn(mv);
		Mockito.when(theatreDetailsRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(theatre));
		List<TheatreDetailsResponseByIdDto> responseList = theatreDetailsServiceImpl.getTheatreDetailsById(1);
		assertEquals(theatredetails.get(0).getTheatreName(),responseList.get(0).getTheatreName());
	}
	
	@Test(expected = NoMoviePresentException.class)
	public void testGetTheatreDetailsById_1()
	{
		 theatreDetailsServiceImpl.getTheatreDetailsById(1);
	}
}
