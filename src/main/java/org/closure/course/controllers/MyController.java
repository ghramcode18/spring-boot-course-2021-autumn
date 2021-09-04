package org.closure.course.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/admin")
	public String admin(Principal principal) {
		return String.format("welcome admin %s", principal.getName());
	}

	@GetMapping("/user")
	public String user(Principal principal) {
		return String.format("welcome user %s", principal.getName());
	}

	@GetMapping("/all")
	public String all() {
		return "<h2>Hello Everyone!</h2>";
	}
}