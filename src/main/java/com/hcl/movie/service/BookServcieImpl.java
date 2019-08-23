package com.hcl.movie.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.movie.dto.BookDto;
import com.hcl.movie.dto.BookRequestDto;
import com.hcl.movie.dto.BookResponseDto;
import com.hcl.movie.entity.Book;
import com.hcl.movie.entity.Movie;
import com.hcl.movie.entity.Theatre;
import com.hcl.movie.exception.CommonException;
import com.hcl.movie.repository.BookRepositoy;
import com.hcl.movie.repository.MovieRepository;
import com.hcl.movie.repository.TheatreRepository;
import com.hcl.movie.util.EmailSender;

/**
 * 
 * @author HAriPriya G
 *
 */
@Service
public class BookServcieImpl implements BookService {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	TheatreRepository thetreRepository;

	@Autowired
	BookRepositoy bookRepository;
	
	@Autowired
	EmailSender emailSender;

	/**
	 * 
	 * This method is intended to book the tickets
	 * 
	 * @param BookRequestDto is the input request which includes numberOfSeats,
	 *                       EmailId, movieId, theatreId
	 * @return it returns BookResponseDto object with message and bookingId
	 */

	@Override
	public BookResponseDto book(BookRequestDto bookRequestDto) {
		Optional<Movie> movie = movieRepository.findById(bookRequestDto.getMovieId());
		Optional<Theatre> theatre = thetreRepository.findById(bookRequestDto.getTheatreId());
		if (!movie.isPresent())
			throw new CommonException("Movie not exist");
		if (!theatre.isPresent())
			throw new CommonException("Theatre not exist");
		if (bookRequestDto.getNumberOfSeats() > 3)
			
			throw new CommonException("More than 3 seats are not available to  book the tickets");

		Book bookDb = Book.builder().numberOfSeats(bookRequestDto.getNumberOfSeats())
				.emailId(bookRequestDto.getEmailId())
				.movieId(movie.get().getMovieId())
				.theatreId(bookRequestDto.getTheatreId())
				.totalPrice(bookRequestDto.getNumberOfSeats()*theatre.get().getPrice())
				.build();
		Book book = bookRepository.save(bookDb);

		if (bookRequestDto.getNumberOfSeats() > theatre.get().getAvailableSeats())
			throw new CommonException("Insufficient seats");

		int updateSeats = theatre.get().getAvailableSeats() - bookRequestDto.getNumberOfSeats();

		theatre.get().setAvailableSeats(updateSeats);
		thetreRepository.save(theatre.get());
		
		BookDto bookDto=new BookDto();
		BeanUtils.copyProperties(book, bookDto);
		
		emailSender.sendTicket(bookRequestDto.getEmailId(), bookDto);

		return new BookResponseDto("Successfully booked" , book.getBookId());
	}

}
