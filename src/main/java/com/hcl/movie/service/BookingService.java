/**
 * 
 */
package com.hcl.movie.service;

import org.springframework.stereotype.Service;

import com.hcl.movie.dto.BookingResponseDto;

/**
 * @author Gurpreet Singh
 *
 */
@Service
public interface BookingService {
	
	public BookingResponseDto getBookingsummary(Integer bookingId);

}
