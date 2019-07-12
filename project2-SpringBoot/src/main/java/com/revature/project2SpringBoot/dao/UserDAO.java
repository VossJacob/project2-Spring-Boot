package com.revature.project2SpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.project2SpringBoot.model.User;

public interface UserDAO extends JpaRepository<User,Integer> {

	//-UserDAO
	//- findByEmailAndPassword
	//- User save(User user)   //for both register and update
	
	
	User save(User user);
	
	@Query("select u from User u where u.email = :email and u.password = :password")
	User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
}
