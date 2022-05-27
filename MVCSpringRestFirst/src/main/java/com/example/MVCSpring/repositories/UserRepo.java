package com.example.MVCSpring.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.MVCSpring.entities.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long>{
	UserEntity findByUsername(String username);

}
