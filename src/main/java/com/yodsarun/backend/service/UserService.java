package com.yodsarun.backend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.yodsarun.backend.BackendApplication;
import com.yodsarun.backend.modal.Users;
import com.yodsarun.backend.repository.UserRepository;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

@Service
public class UserService {
	private static final Logger log = LoggerFactory.getLogger(BackendApplication.class);
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Iterable<Users> getAllCustomer() {
//		RedisClient redisClient = RedisClient.create("redis://password@localhost:6379/0");
//		StatefulRedisConnection<String, String> connection = redisClient.connect();
//		RedisCommands<String, String> syncCommands = connection.sync();
//
//		syncCommands.set("key", "Hello, Redis!");
//		syncCommands.set("jame", "Hello, jame!");
//		String name = (String) syncCommands.get("jame");
//		log.info("Hello K." + name);

//		connection.close();
//		redisClient.shutdown();

		return userRepository.findAll();
	}

	@Cacheable(value = "users", key = "#id", unless = "#result==null")
	public Optional<Users> getCustomerById(Long id) {
		RedisClient redisClient = RedisClient.create("redis://password@localhost:6379/0");
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();

		Optional<Users> users = userRepository.findById(id);
		if (users.isPresent()) {
			log.info("Retrieve User ID: {}", id);
			syncCommands.set(String.valueOf(id), users.toString());
		}
//		syncCommands.set("key", "Hello, Redis!");
//		syncCommands.set("jame", "Hello, jame!");
		String name = (String) syncCommands.get(String.valueOf(id));
		log.info("Confirm has key {} value is : {}", id, name);

		connection.close();
		redisClient.shutdown();
		return users;
	}

	public List<Users> getCustomerByFirstName(String firstName) {
		return userRepository.findByFirstName(firstName);
	}

	public Optional<Users> getCustomerByLastName(String lastName) {
		return userRepository.findByLastName(lastName);
	}
}
