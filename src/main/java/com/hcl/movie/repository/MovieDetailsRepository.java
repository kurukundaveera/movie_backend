/**
 * 
 */
package com.hcl.movie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.movie.entity.Movie;

/**
 * @author Gurpreet Singh
 * 
 *
 */
@Repository
public interface MovieDetailsRepository extends JpaRepository<Movie, Integer> {
	
//	public Optional<Movie> findByMovieId(Integer movieId);

}
