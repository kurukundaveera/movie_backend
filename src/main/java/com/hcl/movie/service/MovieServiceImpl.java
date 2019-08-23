package com.hcl.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.movie.dto.MovieResponseDto;
import com.hcl.movie.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{

	private static Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
	@Autowired MovieRepository movieRepository;
	@Override
	public List<MovieResponseDto> getAllMovies() {
		logger.info("inside the getAllCategories method");
		List<MovieResponseDto> responseList = new ArrayList<>();
		List<MovieResponseDto> categoryList = movieRepository.findAll();
		if(categoryList.isEmpty()) {
			
			throw new CategoryNotFoundException("categories not found");
		}else
		categoryList.stream().forEach(c ->{
			BusinessCategoryResponseDto response = new BusinessCategoryResponseDto();
			BeanUtils.copyProperties(c,response);
			responseList.add(response);
		});
		return responseList;
	}

}
