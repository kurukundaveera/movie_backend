/**
 * 
 */
package com.hcl.movie.dto;

import java.io.Serializable;

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

public class TheatreDetailsResponseByIdDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer theatreId;
	private String name;
	private String area;
	private Integer movieId;

}
