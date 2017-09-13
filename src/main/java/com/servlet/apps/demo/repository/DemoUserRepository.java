package com.servlet.apps.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.servlet.apps.demo.model.User;

public interface DemoUserRepository extends CrudRepository<User, Long> {
	List<User> findByFullname(String fullname);
	List<User> findByEmail(String email); 
}
