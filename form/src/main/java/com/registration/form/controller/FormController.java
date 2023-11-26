package com.registration.form.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.registration.form.exception.UserNotFoundException;
import com.registration.form.model.FormEntity;
import com.registration.form.repository.FormRepository;

@RestController
@CrossOrigin("http://localhost:3000/")
public class FormController {
	@Autowired
	private FormRepository formRepository;
	
	@PostMapping("/user")
	FormEntity newUser(@RequestBody FormEntity newUser) {
		return formRepository.save(newUser);
	}
	
	@GetMapping("/users")
	List<FormEntity> getAllUsers(){
		return formRepository.findAll();	
		}
	
	@GetMapping("/user/{id}")
	FormEntity getUserById(@PathVariable int id) {
		return formRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException(id));
	}
	
	@PutMapping("/user/{id}")
	FormEntity updateUser(@RequestBody FormEntity newUser, @PathVariable int id) {
		return formRepository.findById(id)
				.map(user -> {
					user.setUsername(newUser.getUsername());
					user.setName(newUser.getName());
					user.setEmail(newUser.getEmail());
					return formRepository.save(user);
				}).orElseThrow(()->new UserNotFoundException(id));
	}
	
	@DeleteMapping("/user/{id}")
	String deleteUser(@PathVariable int id) {
	 if(!formRepository.existsById(id)) {
		 throw new UserNotFoundException(id);
	 }
	 formRepository.deleteById(id);
	 return "User with id "+id+" has been deleted sucessfully";
	}
	

}
