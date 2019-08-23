package com.hcl.movie.serviceImpl;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.movie.repository.MovieRepository;
import com.hcl.movie.repository.TheatreRepository;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {
	
	@Mock
	MovieRepository movieRepository;
	
	@Mock
	TheatreRepository thetreRepository;
	

}
