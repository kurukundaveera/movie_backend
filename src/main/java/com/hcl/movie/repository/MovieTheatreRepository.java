/**
 * 
 */
package com.hcl.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.movie.entity.MovieTheatre;

/**
 * @author Gurpreet Singh
 *
 */
@Repository
public interface MovieTheatreRepository extends JpaRepository<MovieTheatre, Integer> {
	
	public List<MovieTheatre> findByMovieId(Integer movieId);
	
}
