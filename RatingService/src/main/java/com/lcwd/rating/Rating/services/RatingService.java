package com.lcwd.rating.Rating.services;


import com.lcwd.rating.Rating.entities.Rating;

import java.util.List;


public interface RatingService {

  Rating create (Rating rating);

  List<Rating> getRating();

  List<Rating> getRatingByUserId(String userid);

  List<Rating> getRatingByHotelId(String hotelId);


}
