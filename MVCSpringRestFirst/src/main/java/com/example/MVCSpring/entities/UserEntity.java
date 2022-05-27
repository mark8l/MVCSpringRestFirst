package com.example.MVCSpring.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user") // "user" straight name of UserEntity var from TodoEntity
	private List<TodoEntity> todos;
	
	public UserEntity() {
		
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<TodoEntity> getTodos() {
		return todos;
	}
	public void setTodos(List<TodoEntity> todos) {
		this.todos = todos;
	}
	
	
}
