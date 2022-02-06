package com.yodsarun.backend.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodsarun.backend.modal.Users;

@Controller
@RequestMapping(value = "/api/v1")
public class UserController {
	@PostMapping("/")
	@ResponseBody
	public Users main() {
		Map map = new HashMap();
		map.put("test", "01");
		return new Users(1,"Yodsarun", "Pongda");
	}

	//@RequestMapping(value = "/customer" , method = RequestMethod.POST)
	@PostMapping("/customer")
	@ResponseBody
	public String getCustomer() {
		return "hello world!! page = customer";
	}
}
