/**
 * 
 */
package com.hcl.movie.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.movie.dto.BookingResponseDto;
import com.hcl.movie.exception.NoBookingFoundException;
import com.hcl.movie.service.BookingServiceImpl;

/**
 * @author Gurpreet Singh
 * 
 * This is the controller class for boooking summary
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class BookingController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

	@Autowired
	BookingServiceImpl bookingServiceImpl;
	
	
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
	@GetMapping("/booking/{bookingId}")
	public ResponseEntity<BookingResponseDto> getBookingsummary(@PathVariable Integer bookingId)
	{
		LOGGER.info("in get booking summary by bookingId method");
		BookingResponseDto response = bookingServiceImpl.getBookingsummary(bookingId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
