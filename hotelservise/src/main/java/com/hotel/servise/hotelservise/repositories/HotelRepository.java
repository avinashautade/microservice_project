package com.hotel.servise.hotelservise.repositories;

import com.hotel.servise.hotelservise.entites.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}
