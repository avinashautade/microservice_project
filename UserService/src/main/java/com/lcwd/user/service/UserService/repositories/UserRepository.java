package com.lcwd.user.service.UserService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.user.service.UserService.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	// here we can write custom method or custom query

}
