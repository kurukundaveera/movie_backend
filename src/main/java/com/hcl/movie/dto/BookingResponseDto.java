/**
 * 
 */
package com.hcl.movie.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Gurpreet Singh
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDto implements Serializable
{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String movieName;
	private Integer numberOfSeats;
	private LocalDate bookingDate;
	private String name;
	private Double totalPrice;
	private String emailId;

}
