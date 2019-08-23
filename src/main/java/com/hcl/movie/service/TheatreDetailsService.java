/**
 * 
 */
package com.hcl.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.movie.dto.TheatreDetailsResponseByIdDto;

/**
 * @author Gurpreet Singh
 *
 */
@Service
public interface TheatreDetailsService {

	public List<TheatreDetailsResponseByIdDto> getTheatreDetailsById(Integer movieId);
}
