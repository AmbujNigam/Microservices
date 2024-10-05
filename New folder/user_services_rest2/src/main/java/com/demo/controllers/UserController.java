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

import com.demo.entities.User;
import com.demo.services.UserService;

@RestController
@CrossOrigin(value = "*")
public class UserController {
	
	@Autowired
	private UserService userService; // new FlightService();

	@GetMapping(value = "/users", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	@GetMapping("users/{id}")
	public User findById(@PathVariable int id) {
		return userService.findById(id);
	}
	@PostMapping("/users")
	public ResponseEntity<?> saveUser(@RequestBody User b) {
		return new ResponseEntity<User>(userService.saveUser(b), HttpStatus.CREATED);
	}
	@PutMapping("/users")
	public User updateUser(@RequestBody User b) {
		return userService.updateUser(b);
	}
	@DeleteMapping("/users/{id}")
	public boolean deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}
}
