package com.yodsarun.backend.restcontroller;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
	@GetMapping("/")
	public String main() {
		return "hello world!!";
	}
}
