package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Booking;
import com.demo.entities.User;
import com.demo.services.BookingService;

@RestController
@CrossOrigin(value = "*")
public class BookingController {
	
	@Autowired
	private BookingService bookingService; // new FlightService();

	@GetMapping(value = "/bookings", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Booking> getAllBookings() {
		return bookingService.getAllBookings();
	}
	@GetMapping("bookings/{id}")
	public Booking findById(@PathVariable int id) {
		return bookingService.findById(id);
	}
	@PostMapping("/bookings")
	public ResponseEntity<?> saveBooking(@RequestBody Booking b) {
		
		return new ResponseEntity<Booking>(bookingService.saveBooking(b), HttpStatus.CREATED);
	}
	@PutMapping("/bookings")
	public Booking updateBooking(@RequestBody Booking b) {
		return bookingService.updateBooking(b);
	}
	@DeleteMapping("/bookings/{id}")
	public boolean deleteBooking(@PathVariable int id) {
		return bookingService.deleteBooking(id);
	}
}
