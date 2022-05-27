package com.example.MVCSpring.models;

import java.util.List;
import java.util.stream.Collectors;

import com.example.MVCSpring.entities.UserEntity;

public class UserModel {
	
	private Long id;
	private String username;
	private List<TodoModel> todos;
	
	public UserModel() {
	}
	
	public static UserModel toModel(UserEntity userEntity) {
		UserModel userModel = new UserModel();
		userModel.setId(userEntity.getId());
		userModel.setUsername(userEntity.getUsername());
		userModel.setTodos(userEntity.getTodos().stream().map(TodoModel::toModel).collect(Collectors.toList()));//Convert Entity List to stream by "stream()", with "map()" call for each entity function toModel. Convert our stream back to List by "convert()"
		return userModel;
	}
	
	
	public List<TodoModel> getTodos() {
		return todos;
	}

	public void setTodos(List<TodoModel> todos) {
		this.todos = todos;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}
