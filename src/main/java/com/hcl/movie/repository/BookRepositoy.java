package com.hcl.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.movie.entity.Book;

public interface BookRepositoy extends JpaRepository<Book, Integer>{

}
