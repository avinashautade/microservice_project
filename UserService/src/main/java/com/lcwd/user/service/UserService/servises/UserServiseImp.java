package com.lcwd.user.service.UserService.servises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.lcwd.user.service.UserService.entities.Hotel;
import com.lcwd.user.service.UserService.entities.Rating;
import com.lcwd.user.service.UserService.external.servises.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lcwd.user.service.UserService.Exceptions.ResourceNotFoundException;
import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.repositories.UserRepository;
import org.springframework.web.client.RestTemplate;


@Service
public class UserServiseImp implements UserServise {

	@Autowired
	private UserRepository userrepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;


	private Logger logger =  LoggerFactory.getLogger(UserServiseImp.class);
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userrepository.save(user);
	}

	@Override
	public List<User> getSAllUser() {
		// TODO Auto-generated method stub
		return userrepository.findAll();
	}

	@Override
	public User getWithId(String userId) {
		// TODO Auto-generated method stub
		//http://localhost:8083/ratings/users/5fafb2a8-38f2-4126-8bdd-95ad8bf5aa49
		User user =userrepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("given user is not presdent in our data base"));
		Rating[] userratings = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		logger.info("{}",userratings);

		 List<Rating> ratings=Arrays.stream(userratings).toList();


		List<Rating> ratingList = ratings.stream().map(rating -> {

			    //http://localhost:8082/hotels/f7e8e828-f894-4044-b6f9-34352953895b

			//ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVISE/hotels/"+rating.getHotelId(),Hotel.class );
                    Hotel hotel = hotelService.getHotel(rating.getHotelId());

					// logger.info("response status code : {} ", forEntity.getStatusCode());
					 rating.setHotel(hotel);

			return  rating;

		}).collect(Collectors.toList());




		user.setRatings(ratingList);

		return user;
	}

}
