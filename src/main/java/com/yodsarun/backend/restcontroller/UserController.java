package com.yodsarun.backend.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yodsarun.backend.BackendApplication;
import com.yodsarun.backend.modal.Users;
import com.yodsarun.backend.repository.UserRepository;
import com.yodsarun.backend.service.UserService;

@Controller
@RequestMapping(value = "/api/v1")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(BackendApplication.class);

	@Autowired
	private UserService userService;

	@PostMapping("/")
	@ResponseBody
	public Users main() {
		Map map = new HashMap();
		map.put("test", "01");
		return new Users(1, "Yodsarun", "Pongda");
	}

//	@PostMapping(path = "/add") // Map ONLY POST Requests
//	public @ResponseBody String addNewUser(@RequestParam String firstname, @RequestParam String lastname) {
//		// @ResponseBody means the returned String is the response, not a view name
//		// @RequestParam means it is a parameter from the GET or POST request
//
//		Users user = new Users();
//		user.setFirstName(firstname);
//		user.setLastName(lastname);
//		userService.save(user);
//		return "Saved";
//	}

	// @RequestMapping(value = "/customer" , method = RequestMethod.POST)
	@GetMapping(value = "/customer")
	public @ResponseBody Iterable<Users> getCustomer() {
		return userService.getAllCustomer();
	}

	@GetMapping(value = "/customer/{id}")
	public @ResponseBody ResponseEntity<?> getUserById(@PathVariable Long id) {
		Optional<Users> user = userService.getCustomerById(id);
		if (!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
		// return userService.getCustomerById(id);
	}

	@GetMapping(value = "/customer/firstname/{firstName}")
	public @ResponseBody ResponseEntity<?> getUserByFirstName(@PathVariable String firstName) {
		List<Users> user = userService.getCustomerByFirstName(firstName);
		if (user.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
		// return userService.getCustomerById(id);
	}

	@GetMapping(value = "/customer/lastname/{lastname}")
	public @ResponseBody ResponseEntity<?> getUserByLastName(@PathVariable String lastname) {
		Optional<Users> user = userService.getCustomerByLastName(lastname);
		if (!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
		// return userService.getCustomerById(id);
	}
}
