package com.example.MVCSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.MVCSpring.entities.UserEntity;
import com.example.MVCSpring.exceptions.*;
import com.example.MVCSpring.services.UserService;



@RequestMapping("/users")
@RestController
public class UserController {
	

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity registration(@RequestBody UserEntity user) {
		try {
			userService.registration(user);
			return ResponseEntity.ok("User saved successfully");
		}
		catch(UserAlreadyExistException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body("There is some error!");
		}
	}
	
	@GetMapping
	public ResponseEntity getOneUser(@RequestParam Long id) 
	{
		try {
			return ResponseEntity.ok(userService.getOne(id));
		}
		catch(UserNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body("There is some error!");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(userService.deleteUser(id));
		}
		catch(UserNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body("There is some error!");
		}
	}
	

}
