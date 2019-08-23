package com.hcl.movie.serviceImpl;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.movie.dto.BookRequestDto;
import com.hcl.movie.entity.Book;
import com.hcl.movie.entity.Movie;
import com.hcl.movie.entity.Theatre;
import com.hcl.movie.repository.MovieRepository;
import com.hcl.movie.repository.TheatreRepository;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {
	
	@Mock
	MovieRepository movieRepository;
	
	
	@Mock
	TheatreRepository thetreRepository;
	
	Book book;
	BookRequestDto bookRequestDto;
	Movie movie;
	Theatre theatre;
	
	
	@Before
	public void setUp() {
		book = getBook();
		bookRequestDto=getBookRequestDto();
		movie=getMovie();
		theatre=getTheatre();
	}

	@Test()
	public void createBookTest()
	{
		Mockito.when(movieRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(movie));
		Mockito.when(movieRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(movie));
	}
	
	public Book getBook()
	{
		return new Book(1, 30, 120.00, 1, LocalDate.now(), "h@gmail.com", 1);
	}
	
	public BookRequestDto getBookRequestDto()
	{
		return new BookRequestDto(1, 1, "h@gmail.com", 4);
	}
	
	public Movie getMovie()
	{
		return new Movie(1, "Avengers", "English", "A");
	}
	
	public Theatre getTheatre()
	{
		return new Theatre(1, "AA", "Electronic city", 3,120.00);
	}
	
	
	

}

