package com.hcl.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.movie.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	List<Movie> findByNameStartsWithIgnoreCase(String name);

}
