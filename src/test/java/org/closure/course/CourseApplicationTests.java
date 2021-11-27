package org.closure.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.Base64;

import org.closure.course.controllers.MyController;
import org.jooq.tools.jdbc.MockResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import io.restassured.http.Header;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
@WebMvcTest(MyController.class)
class CourseApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void TestWithAssured() throws Exception {
		given().header(new Header("Authorization","Basic YWRtaW46YWRtaW5AMTIz")).get("admin").then().statusCode(200);
	}

	@Test
	@WithMockUser(username = "admin", password = "admin@123", roles = "ADMIN")
	public void mytest1() throws Exception {
		MockHttpServletRequestBuilder mockMvcRequestBuilders = MockMvcRequestBuilders.get("/admin");
		mockMvc.perform(MockMvcRequestBuilders.get("/admin")).andExpect((e) -> {
			assertEquals(200, e.getResponse().getStatus());
		});
	}
}
