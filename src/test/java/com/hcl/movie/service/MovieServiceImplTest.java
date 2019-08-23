package com.hcl.movie.service;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.hcl.movie.dto.MovieResponseDto;
import com.hcl.movie.entity.Movie;
import com.hcl.movie.exception.MovieNotFoundException;
import com.hcl.movie.repository.MovieRepository;
@RunWith(MockitoJUnitRunner.class)

public class MovieServiceImplTest {
	@Mock MovieRepository movieRepository;
	@InjectMocks MovieServiceImpl movieServiceImpl;
	List<Movie> movieList;
	Movie movie;
	@Before
	public void setUp() {
		movieList = new ArrayList<>();
		movie = new Movie();
		movie.setMovieId(12);
		movie.setName("Rockstar");
		movie.setLanuage("Hindi");
		movie.setMovieType("A");
		movieList.add(movie);
	}
	@Test
	public void getAllMoviesTest() {
		Mockito.when(movieRepository.findAll()).thenReturn(movieList);
		List<MovieResponseDto> response = movieServiceImpl.getAllMovies();	
		Assert.assertEquals("Rockstar", response.get(0).getName());
	}
	
	@Test(expected = MovieNotFoundException.class)
	public void getAllMoviesTest_1() {
		movieServiceImpl.getAllMovies();
	}
}
