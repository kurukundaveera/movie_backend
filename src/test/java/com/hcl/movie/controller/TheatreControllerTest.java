package com.hcl.movie.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.movie.service.TheatreDetailsServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TheatreControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(TheatreControllerTest.class);

	@Mock
	TheatreDetailsServiceImpl theatreDetailsServiceImpl;
	@InjectMocks
	TheatreDetailsController theatreController;
	MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(theatreController).build();
	}

	@Test
	public void getTheatreDetailsByIdTest() throws Exception {
		logger.info("inside the getTheatreDetailsByIdTest method");
		mockMvc.perform(MockMvcRequestBuilders.get("/api/movieDetails/{movieId}",1)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
