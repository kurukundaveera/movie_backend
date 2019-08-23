package com.hcl.movie.serviceImpl;

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

import com.hcl.movie.dto.SearchRequestDto;
import com.hcl.movie.dto.SearchResponseDto;
import com.hcl.movie.entity.Movie;
import com.hcl.movie.exception.MovieNotFoundException;
import com.hcl.movie.repository.MovieRepository;
import com.hcl.movie.service.SearchServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SearchServiceImplTest {
	@Mock
	MovieRepository movieRepository;
	@InjectMocks
	SearchServiceImpl searchServiceImpl;

	List<SearchResponseDto> responseList;
	SearchResponseDto response;
	Movie movie;
	List<Movie> movieList;

	SearchRequestDto searchRequestDto;

	@Before
	public void setUp() {

		responseList = new ArrayList<>();
		response = new SearchResponseDto();
		movieList = new ArrayList<>();
		movie = new Movie();
		movie.setMovieId(1);
		movie.setName("avengers");
		movieList.add(movie);
		response.setMovieId(1);
		response.setName("avengers");
		responseList.add(response);

		searchRequestDto = getSearchRequestDto();

	}

	@Test
	public void testGetMovies() {
		Mockito.when(movieRepository.findByNameStartsWithIgnoreCase(Mockito.anyString())).thenReturn(movieList);
		List<SearchResponseDto> movieResponse = searchServiceImpl.getMovies(searchRequestDto);
		Assert.assertEquals(responseList.get(0).getName(), movieResponse.get(0).getName());

	}
	
	@Test(expected = MovieNotFoundException.class)
	public void testGetMovies_1() {
		searchServiceImpl.getMovies(searchRequestDto);
	}

	public SearchRequestDto getSearchRequestDto() {
		return new SearchRequestDto("aa");
	}

}
