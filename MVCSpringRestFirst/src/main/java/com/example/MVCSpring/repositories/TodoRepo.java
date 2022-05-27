package com.example.MVCSpring.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.MVCSpring.entities.TodoEntity;

public interface TodoRepo extends CrudRepository<TodoEntity, Long>{
	
	

}
