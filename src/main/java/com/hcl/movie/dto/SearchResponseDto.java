package com.hcl.movie.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SearchResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer movieId;
	private String name;
	private String lanuage;
	private String movieType;

}
