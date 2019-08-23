package com.hcl.movie.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class BookRequestDto implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer movieId;
	private Integer theatreId;
	private String emailId;
	private Integer numberOfSeats;

}
