package com.hotel.servise.hotelservise.controllers;


import com.hotel.servise.hotelservise.entites.Hotel;
import com.hotel.servise.hotelservise.services.HotelServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelServise hotelServise;

    @PostMapping
    public ResponseEntity<Hotel> SaveHotel(@RequestBody Hotel hotel){

        Hotel saveHotel = hotelServise.createHotel(hotel);

        return new ResponseEntity<>(saveHotel, HttpStatus.OK);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> SingaleHotel(@PathVariable  String hotelId){


        return  ResponseEntity.status(HttpStatus.OK).body(hotelServise.get(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> allHotel(){


        return  ResponseEntity.status(HttpStatus.OK).body(hotelServise.getAllHotels());
    }

}
