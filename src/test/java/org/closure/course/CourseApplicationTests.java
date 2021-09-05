package org.closure.course;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.closure.course.controllers.EmployeeController;
import org.closure.course.dto.JwtRequest;
import org.closure.course.dto.JwtResponse;
import org.closure.course.services.JwtUserDetailsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
// @WithMockUser
// @WebMvcTest(EmployeeController.class)
class CourseApplicationTests {
	@Autowired
	MockMvc mockMvc;

	@Test
	void greetingWithNoJwt() throws Exception {
		mockMvc.perform(get("/greeting")).andExpect(status().isForbidden());
	}

	@Test
	void greretingWitRegisteredUserAndJwt() throws Exception {

		JwtRequest jwtRequest = new JwtRequest("admin", "admin@123");
		ObjectMapper objectMapper = new ObjectMapper();
		String jwtJson = objectMapper.writeValueAsString(jwtRequest);
		String jwtResponseJson = mockMvc
				.perform(post("/authenticate").contentType(MediaType.APPLICATION_JSON).content(jwtJson))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		JsonNode jsonNode = objectMapper.readTree(jwtResponseJson);
		String token = jsonNode.get("jwttoken").asText();
		mockMvc.perform(get("/greeting").header("Authorization", String.format("Bearer %s", token))).andExpect(status().isOk());
	}
}
