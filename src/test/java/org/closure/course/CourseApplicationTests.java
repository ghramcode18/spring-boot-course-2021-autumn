package org.closure.course;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.closure.course.controllers.EmployeeController;
@WebMvcTest(EmployeeController.class)
class CourseApplicationTests {

	@Autowired
	MockMvc mockMvc;
	@Test
	void contextLoads() throws Exception {
		mockMvc.perform(get("/greeting")).andExpect(content().string("Welcome!"));
	}

}
