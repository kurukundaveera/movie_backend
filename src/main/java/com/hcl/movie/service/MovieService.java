package com.hcl.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.movie.dto.MovieResponseDto;
@Service
public interface MovieService {

	public List<MovieResponseDto> getAllMovies();

}
