package org.closure.course.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Getter
@Setter
@AllArgsConstructor
@With
public class JwtResponse implements Serializable{
    private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

    
}
