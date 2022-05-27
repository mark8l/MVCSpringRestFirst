package com.example.MVCSpring.models;

import java.util.List;

import com.example.MVCSpring.entities.TodoEntity;

public class TodoModel {
	private Long id;
	private String title;
	private Boolean complited;
	
	public static TodoModel toModel(TodoEntity todoEntity) {
		TodoModel todoModel = new TodoModel();
		todoModel.setId(todoEntity.getId());
		todoModel.setTitle(todoEntity.getTitle());
		todoModel.setComplited(todoEntity.getComplited());
		return todoModel;
	}
	public TodoModel() {

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getComplited() {
		return complited;
	}
	public void setComplited(Boolean complited) {
		this.complited = complited;
	}
	
	
	
	

}
