package com.passenger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.passenger.VO.User;
import com.passenger.exception.InvalidUserException;
import com.passenger.exception.LastNameNotFoundException;
import com.passenger.model.Passenger;
import com.passenger.service.PassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

	private static final String USER_URL="http://localhost:8020/user/get-user/";
	
	@Autowired
	PassengerService passerv;
	
	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/addPassenger")
	public ResponseEntity<Passenger> addPassengerDetails(@Validated @RequestBody Passenger pas) {
		if (pas.getLastName().isBlank()) {
			throw new LastNameNotFoundException("LASTNAME NOT FOUND TO ADD");
		}
		return new ResponseEntity<>(passerv.addPassenger(pas),HttpStatus.OK);
	}

	@GetMapping("/getAllPassengerDetails/{userId}")
	public ResponseEntity<List<Passenger>> fetchPasById(@PathVariable("userId") int userId) {
		User user=null;
		try {
			 user = restTemplate.getForObject(USER_URL + userId, User.class);
		} catch (RuntimeException ex) {
			return null;
		}
		if(!user.getUserType().equalsIgnoreCase("Admin")) {
			throw new InvalidUserException("Only admin can can view the bookings.");
		}
		List<Passenger> pass = passerv.getPassenger();
		return new ResponseEntity<>(pass, HttpStatus.OK);
	}

}
