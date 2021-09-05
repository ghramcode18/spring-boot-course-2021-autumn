package org.closure.course.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
public class JwtRequest implements Serializable{
    private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
    
}
