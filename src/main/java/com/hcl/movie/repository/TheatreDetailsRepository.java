/**
 * 
 */
package com.hcl.movie.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.movie.entity.Movie;
import com.hcl.movie.entity.Theatre;

/**
 * @author Gurpreet Singh
 *
 */
@Repository
public interface TheatreDetailsRepository extends JpaRepository<Theatre, Integer>{

//	public Optional<Theatre> findByMovieId(Integer movieId);
}
