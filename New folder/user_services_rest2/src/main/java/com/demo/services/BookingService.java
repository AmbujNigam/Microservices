package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Booking;
import com.demo.entities.User;
import com.demo.repositories.BookingRepository;

//@Repository, @Service, @Component, @Configuration
@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}
	public Booking findById(int id) {
		Optional<Booking> optional = bookingRepository.findById(id);
		if(optional.isPresent()) {
			Booking booking = optional.get();
			return booking;
		} else {
			// throw exception
			throw new RuntimeException("Booking with id "+id+" is not found in database");
		}
	}
	public Booking saveBooking(Booking booking) {
				
		return bookingRepository.save(booking);
	}
	public Booking updateBooking(Booking booking) {
		if(bookingRepository.existsById(booking.getPnr())) {
			return bookingRepository.save(booking); // save if id not found, edit where id is found 
		} else {
			throw new RuntimeException("Invalid id, update operation failed");
		}
	}
	
	public boolean deleteBooking(int id) {
		boolean isFound = bookingRepository.existsById(id);
		bookingRepository.deleteById(id);
		return isFound;
	}
}
