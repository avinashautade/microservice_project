package com.hotel.servise.hotelservise.services;

import com.hotel.servise.hotelservise.entites.Hotel;

import java.util.List;

public interface HotelServise {

    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel get(String id);
}
