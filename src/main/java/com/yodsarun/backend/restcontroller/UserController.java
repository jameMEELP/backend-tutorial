package com.yodsarun.backend.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodsarun.backend.modal.Users;
import com.yodsarun.backend.repository.UserRepository;

@Controller
@RequestMapping(value = "/api/v1")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/")
	@ResponseBody
	public Users main() {
		Map map = new HashMap();
		map.put("test", "01");
		return new Users(1,"Yodsarun", "Pongda");
	}

	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser (@RequestParam String firstname, @RequestParam String lastname) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Users user = new Users();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		userRepository.save(user);
		return "Saved";
	}

	//@RequestMapping(value = "/customer" , method = RequestMethod.POST)
	@GetMapping(value = "/customer")
	public @ResponseBody Iterable<Users> getCustomer() {
		return userRepository.findAll();
	}
}
