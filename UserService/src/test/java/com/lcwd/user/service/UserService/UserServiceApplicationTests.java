package com.lcwd.user.service.UserService;

import com.lcwd.user.service.UserService.entities.Rating;
import com.lcwd.user.service.UserService.external.servises.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	 @Autowired
	private RatingService ratingService;
//
//	@Test
//	void createRating(){
//		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("this is creted bybusing fegin client").build();
//		Rating savedRating= ratingService.createRating(rating);
//		System.out.println("new rating created ");
//	}

}
