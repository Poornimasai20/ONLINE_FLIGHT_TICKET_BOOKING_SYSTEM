package com.passenger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passenger.model.Passenger;
import com.passenger.repo.PassengerRepo;

@Service
public class PassengerService {
	@Autowired
	PassengerRepo pasrepo;
	
	public Passenger addPassenger(Passenger pas)
	{
		return pasrepo.save(pas);
	}
	
	
	
	public  List<Passenger> getPassenger()
	{
		return  (List<Passenger>) pasrepo.findAll();
	}
	public Optional<Passenger> fetchPasById(int passengerid)
	{
		return pasrepo.findById(passengerid);
	}
	
}
