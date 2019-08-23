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
import com.hcl.movie.dto.SearchRequestDto;
import com.hcl.movie.service.SearchService;

@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {
	@Mock
	SearchService searchService;
	@InjectMocks
	SearchController searchController;
	MockMvc mockMvc;

	SearchRequestDto searchRequestDto;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(searchController).build();
		searchRequestDto = getSearchRequestDto();
	}

	@Test
	public void testGetMovies() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/search").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(asJsonString(searchRequestDto))).andExpect(status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public SearchRequestDto getSearchRequestDto() {
		return new SearchRequestDto("aa");
	}

}
