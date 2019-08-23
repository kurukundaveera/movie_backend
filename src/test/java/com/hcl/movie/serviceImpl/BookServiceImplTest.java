package com.hcl.movie.serviceImpl;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.movie.dto.BookRequestDto;
import com.hcl.movie.dto.BookResponseDto;
import com.hcl.movie.entity.Book;
import com.hcl.movie.entity.Movie;
import com.hcl.movie.entity.Theatre;
import com.hcl.movie.exception.CommonException;
import com.hcl.movie.repository.BookRepositoy;
import com.hcl.movie.repository.MovieRepository;
import com.hcl.movie.repository.TheatreRepository;
import com.hcl.movie.service.BookServcieImpl;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {
	
	@Mock
	MovieRepository movieRepository;	
	
	@Mock
	TheatreRepository thetreRepository;
	
	@Mock
	BookRepositoy bookRepository;
	
	@InjectMocks
	BookServcieImpl bookServiceImpl;
	
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
		Mockito.when(thetreRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(theatre));
		Mockito.when(bookRepository.save(Mockito.any())).thenReturn(book);
		BookResponseDto bokResponseDto=bookServiceImpl.book(bookRequestDto);
		Assert.assertEquals("Booking successfull:email sent", bokResponseDto.getMessage());
	}
	
	@Test(expected = CommonException.class)
	public void createBookTest_1()
	{
		Mockito.when(movieRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		bookServiceImpl.book(bookRequestDto);
	}
	
	@Test(expected = CommonException.class)
	public void createBookTest_2()
	{
		Mockito.when(movieRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(movie));
		Mockito.when(thetreRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		bookServiceImpl.book(bookRequestDto);
	}
	
	@Test(expected = CommonException.class)
	public void createBookTest_3()
	{
		Mockito.when(movieRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(movie));
		Mockito.when(thetreRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(theatre));
		bookRequestDto.setNumberOfSeats(4);
		bookServiceImpl.book(bookRequestDto);
	}
	
	
	public Book getBook()
	{
		return new Book(1, 30, 120.00, 1, LocalDate.now(), "h@gmail.com", 1);
	}
	
	public BookRequestDto getBookRequestDto()
	{
		return new BookRequestDto(1, 1, "h@gmail.com", 3);
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

