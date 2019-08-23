package com.hcl.movie.serviceImpl;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.movie.entity.Book;
import com.hcl.movie.repository.MovieRepository;
import com.hcl.movie.repository.TheatreRepository;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {
	
	@Mock
	MovieRepository movieRepository;
	
	@Mock
	TheatreRepository thetreRepository;
	
	@Test()
	public void createBookTest()
	{
		//Mockito.when(movieRepository.findById())
	}
	
	public Book getBook()
	{
		return new Book(1, 30, 120.00, 1, LocalDate.now(), "h@gmail.com", 1);
	}
	
//	public BookRequestDto getBookRequestDto()
//	{
//		new 
//	}
	

}
