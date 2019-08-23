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
import com.hcl.movie.dto.BookRequestDto;
import com.hcl.movie.dto.MovieResponseDto;
import com.hcl.movie.service.BookService;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {
	@Mock
	BookService bookService;
	@InjectMocks
	BookController bookController;
	MockMvc mockMvc;
	MovieResponseDto movieResponseDto;

	BookRequestDto bookRequestDto;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
		bookRequestDto = getBookRequestDto();
	}

	@Test
	public void getBookTest() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/api/book").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(asJsonString(bookRequestDto)))
				.andExpect(status().isCreated());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public BookRequestDto getBookRequestDto() {
		return new BookRequestDto(1, 1, "h@gmail.com", 4);
	}
}
