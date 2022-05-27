package com.example.MVCSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.MVCSpring.entities.*;
import com.example.MVCSpring.services.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@PostMapping
	public ResponseEntity createTodo(@RequestBody TodoEntity todoEntity,
									 @RequestParam Long userId) {
		try {
			return ResponseEntity.ok(todoService.createTodo(todoEntity, userId));
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("There is some error!");
		}
	} 

	@PutMapping
	public ResponseEntity compliteTodo(@RequestParam Long userId) {
		try {
			return ResponseEntity.ok(todoService.compliteTodo(userId));

		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("There is some error!");
		}
	} 
}
