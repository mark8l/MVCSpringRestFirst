package com.example.MVCSpring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MVCSpring.repositories.*;
import com.example.MVCSpring.entities.*;
import com.example.MVCSpring.models.TodoModel;

@Service
public class TodoService {
	
	@Autowired
	TodoRepo todoRepo;
	@Autowired
	UserRepo userRepo;
	
	public TodoModel createTodo(TodoEntity todoEntity, Long userId) {
		UserEntity userEntity = userRepo.findById(userId).get();
		todoEntity.setUser(userEntity);
		return TodoModel.toModel(todoRepo.save(todoEntity));
	}
	
	public TodoModel compliteTodo(Long id) {
		TodoEntity todoEntity = todoRepo.findById(id).get();
		todoEntity.setComplited(!todoEntity.getComplited());
		return TodoModel.toModel(todoRepo.save(todoEntity));
	}
} 
