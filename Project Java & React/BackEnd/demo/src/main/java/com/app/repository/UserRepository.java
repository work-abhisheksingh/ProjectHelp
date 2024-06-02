package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	Optional<User> findByEmailAndPassword(String em , String pwd);

	Optional<User>  findByEmail(String username);
	
//	Optional<User> findByUsername(String username);

	Optional<User> findByuserId(int userid);
	
//	Boolean existByUsername(String username);
//	
//	Boolean existByEmail(String email);
//	
	
}
