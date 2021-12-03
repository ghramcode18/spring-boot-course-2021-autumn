package org.closure.course.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.With;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@ToString
public class JwtRequest{
    
	private String username;
	private String password;
    
}
