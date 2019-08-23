package com.hcl.movie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.movie.entity.Book;

public interface BookRepositoy extends JpaRepository<Book, Integer>{
	
	Optional<Book> findByBookId(Integer bookingId);

}
