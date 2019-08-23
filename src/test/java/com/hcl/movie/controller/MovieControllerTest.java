package com.hcl.movie.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.movie.dto.MovieResponseDto;
import com.hcl.movie.service.MovieServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class MovieControllerTest {
	@Mock MovieServiceImpl movieServiceImpl;
	@InjectMocks MovieController movieController;
	MockMvc mockMvc;
	MovieResponseDto movieResponseDto;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
	}
	
	@Test
	public void getMoviesListTest() throws Exception{
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/getMovies").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
