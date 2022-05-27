package com.example.MVCSpring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MVCSpring.entities.UserEntity;
import com.example.MVCSpring.exceptions.*;
import com.example.MVCSpring.models.UserModel;
import com.example.MVCSpring.repositories.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public UserEntity registration(UserEntity user) throws UserAlreadyExistException{
		if(userRepo.findByUsername(user.getUsername()) != null) {
			throw new UserAlreadyExistException("There is already had a user with this username, please choose new one!");

		}
		return userRepo.save(user);
	}
	
	public UserModel getOne(Long id) throws UserNotFoundException {
		UserEntity user = userRepo.findById(id).get();
		if (user == null) {
			System.out.println("No user");
			throw new UserNotFoundException("There is no user with such id!");
		}
		return UserModel.toModel(user);
	}
	
	public Long deleteUser(Long id) throws UserNotFoundException {
		UserEntity user = userRepo.findById(id).get();
		if (user == null) {
			throw new UserNotFoundException("There is no user with such id to delete!");
		}
		else {
			userRepo.deleteById(id);
			return id;
		}
	}

}
