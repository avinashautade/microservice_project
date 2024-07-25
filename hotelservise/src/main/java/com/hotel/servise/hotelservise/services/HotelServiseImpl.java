package com.hotel.servise.hotelservise.services;

import com.hotel.servise.hotelservise.entites.Hotel;
import com.hotel.servise.hotelservise.exceptions.ResourceNotFoundException;
import com.hotel.servise.hotelservise.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiseImpl implements HotelServise{

   @Autowired
  private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {


        String randomid=UUID.randomUUID().toString();
        hotel.setId(randomid);
        return hotelRepository.save(hotel)  ;
    }

    @Override
    public List<Hotel> getAllHotels() {

        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {


        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotels with given id is not found"));
    }
}
