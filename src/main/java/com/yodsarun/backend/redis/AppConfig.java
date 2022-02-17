package com.yodsarun.backend.redis;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.yodsarun.backend.BackendApplication;
import com.yodsarun.backend.modal.Users;
import com.yodsarun.backend.repository.UserRepository;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

@Configuration
public class AppConfig {
	private static final Logger log = LoggerFactory.getLogger(BackendApplication.class);

	// Simple Redis configulation
//	@Bean
//	JedisConnectionFactory jedisConnectionFactory() {
//		return new JedisConnectionFactory();
//	}

	@Autowired
	private static UserRepository userRepository;

	// Custom jedis connection factory
//	@Bean
//	public RedisConnectionFactory redisConnectionFactory() {
//		return new LettuceConnectionFactory();
//	}
//
//	@Bean
//	public RedisTemplate<String, Users> redisTemplate() {
//		RedisTemplate<String, Users> empTemplate = new RedisTemplate<>();
//		empTemplate.setConnectionFactory(redisConnectionFactory());
//		return empTemplate;
//	}
}
