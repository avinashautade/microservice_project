package com.hotel.servise.hotelservise.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("staffs")
public class StaffControler {

    @GetMapping
    public ResponseEntity<List <String>> getStaff(){

        List<String> staff =Arrays.asList("avinash","kiran","ramesh","adity");
        return  new ResponseEntity<List <String>>(staff, HttpStatus.OK);
    }
}
