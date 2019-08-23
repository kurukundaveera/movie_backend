/**
 * 
 */
package com.hcl.movie.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.movie.dto.BookingResponseDto;
import com.hcl.movie.entity.Book;
import com.hcl.movie.entity.Movie;
import com.hcl.movie.entity.Theatre;
import com.hcl.movie.exception.MovieNotFoundException;
import com.hcl.movie.exception.NoBookingFoundException;
import com.hcl.movie.repository.BookRepositoy;
import com.hcl.movie.repository.MovieRepository;
import com.hcl.movie.repository.TheatreRepository;

/**
 * @author Gurpreet Singh
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BookingServiceImplTest {

	@InjectMocks
	BookingServiceImpl bookingServiceImpl;
	@Mock
	BookRepositoy bookRepository;

	@Mock
	MovieRepository movieRepository;

	@Mock
	TheatreRepository theatreRepository;
	
	BookingResponseDto bookingResponseDto;
	Book book;
	Movie movie;
	Theatre theatre;
	
	@Before
	public void setup()
	{
		
		bookingResponseDto = getBookingResponseDto();
		book = getBook();
		movie = getMovie();
		theatre = getTheatre();
		
	}
	
	public BookingResponseDto getBookingResponseDto()
	{
		BookingResponseDto bookingResponseDto = new BookingResponseDto();
		bookingResponseDto.setEmailId("gurpreet.gohir@gmail.com");
		bookingResponseDto.setMovieName("Avengers");
		bookingResponseDto.setName("inox");
		bookingResponseDto.setTotalPrice(200D);
		bookingResponseDto.setNumberOfSeats(25);
		return bookingResponseDto;
	}
	
	public Book getBook()
	{
		Book book = new Book();
		book.setBookId(1);
		book.setMovieId(1);
		book.setTheatreId(1);
		return book;
	}
	 
	public Movie getMovie()
	{
		Movie movie = new Movie();
		movie.setLanuage("English");
		movie.setMovieId(1);
		movie.setMovieType("A");
		return movie;
	}
	
	public Theatre getTheatre()
	{
		Theatre theatre = new Theatre();
		theatre.setArea("whitefield");
		theatre.setPrice(200D);
		theatre.setName("inox");
		return theatre;
	}
	
	@Test
	public void testgetBookingsummary()
	{
		Mockito.when(bookRepository.findByBookId(Mockito.anyInt())).thenReturn(Optional.of(book));
		Mockito.when(movieRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(movie));
		Mockito.when(theatreRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(theatre));
		BookingResponseDto responseList = bookingServiceImpl.getBookingsummary(1);
		assertEquals(bookingResponseDto.getName(),responseList.getName());
	}
	
	@Test(expected = NoBookingFoundException.class)
	public void testgetBookingsummary_1()
	{
		bookingServiceImpl.getBookingsummary(1);
	}
	
}
