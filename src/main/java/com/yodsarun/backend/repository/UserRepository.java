package com.yodsarun.backend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yodsarun.backend.modal.Users;

public interface UserRepository extends CrudRepository<Users, Long> {
	List<Users> findByLastName(String lastName);
}
