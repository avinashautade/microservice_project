package com.lcwd.user.service.UserService.controller;

import java.util.List;
import java.util.logging.Logger;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.servises.UserServise;



@RestController
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	private UserServise userServise;
	
	
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User user1 = userServise.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
		
	}
	
	
	@GetMapping("/{userId}")
	//@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name="userRateLimiter", fallbackMethod ="ratingHotelFallback ")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		
		 User user =userServise.getWithId(userId);
		return ResponseEntity.ok(user);
	}

	//creating fall back method for circitbreaker

	public ResponseEntity<User> ratingHotelFallback (String userId, Exception ex){

		User user = User.builder()
				.email("abc@123.com")
				.name("abc")
				.about("this user is created dummy because some service is down")
				.userId("12365")
				.build();

		return new ResponseEntity<>(user, HttpStatus.OK);

	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		
		List<User> allusers= userServise.getSAllUser();
		
		return ResponseEntity.ok(allusers);
	}
	
	
	
	
}
