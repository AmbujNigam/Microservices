package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.User;
import com.demo.repositories.UserRepository;

//@Repository, @Service, @Component, @Configuration
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	public User findById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			User user = optional.get();
			return user;
		} else {
			// throw exception
			throw new RuntimeException("User with id "+id+" is not found in database");
		}
	}
	public User saveUser(User b) {
		
		return userRepository.save(b);
	}
	public User updateUser(User b) {
		if(userRepository.existsById(b.getId())) {
			return userRepository.save(b); // save if id not found, edit where id is found 
		} else {
			throw new RuntimeException("Invalid id, update operation failed");
		}
	}
	
	public boolean deleteUser(int id) {
		boolean isFound = userRepository.existsById(id);
		userRepository.deleteById(id);
		return isFound;
	}
}
