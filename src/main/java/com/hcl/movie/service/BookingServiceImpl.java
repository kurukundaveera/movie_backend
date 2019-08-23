/**
 * 
 */
package com.hcl.movie.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.movie.dto.BookingResponseDto;
import com.hcl.movie.entity.Book;
import com.hcl.movie.entity.Movie;
import com.hcl.movie.entity.Theatre;
import com.hcl.movie.exception.MovieNotFoundException;
import com.hcl.movie.exception.NoBookingFoundException;
import com.hcl.movie.repository.BookRepositoy;
import com.hcl.movie.repository.MovieRepository;
import com.hcl.movie.repository.TheatreRepository;

/**
 * @author Gurpreet singh
 *
 */
@Service
public class BookingServiceImpl implements BookingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Autowired
	BookRepositoy bookRepository;

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	TheatreRepository theatreRepository;

	/**
	 * This method is use to get booking summary
	 * 
	 * @param Integer bookingId is the input parameter
	 * @return BookingResponseDto is the output which includes movieName,
	 *         numberOfSeats bookingDate, name, totalPrice, emailId
	 * @exception NoBookingFoundException if no booking found MovieNotFoundException
	 *                                    if no movie found MovieNotFoundException
	 *                                    if no theatre found
	 * 
	 */
	@Override
	public BookingResponseDto getBookingsummary(Integer bookingId) {
		LOGGER.info("in getbookingsummary method");

		Optional<Book> book = bookRepository.findByBookId(bookingId);
		if (!book.isPresent())
			throw new NoBookingFoundException("No booking found");

		Optional<Movie> movie = movieRepository.findById(book.get().getMovieId());
		Optional<Theatre> theatre = theatreRepository.findById(book.get().getTheatreId());

		if (!movie.isPresent())
			throw new MovieNotFoundException("No movie found");
		if (!theatre.isPresent())
			throw new MovieNotFoundException("No theatre found");
		BookingResponseDto booking = new BookingResponseDto();

		booking.setNumberOfSeats(book.get().getNumberOfSeats());
		booking.setBookingDate(book.get().getBookingDate());
		booking.setTotalPrice(book.get().getTotalPrice());
		booking.setEmailId(book.get().getEmailId());

		booking.setMovieName(movie.get().getName());
		booking.setName(theatre.get().getName());

		return booking;
	}

}
