package com.lcwd.user.service.UserService.servises;

import java.util.List;

import com.lcwd.user.service.UserService.entities.User;

public interface UserServise {
	
	
	// get single user
	User  saveUser(User user);

	// get all user
	
	List<User> getSAllUser();
	
	//get user by id
	
	User getWithId(String userId);
	
	
	
	
	
}
