package com.revature.project2SpringBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.project2SpringBoot.model.Comment;
import com.revature.project2SpringBoot.model.User;

public interface UserDAO extends JpaRepository<User,Integer> {

	//-UserDAO
	//- findByEmailAndPassword
	//- User save(User user)   //for both register and update
	
	
//	User save(User user);
	
	@Query("select u from User u where u.email = :email and u.password = :password")
	User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
	@Query("SELECT c FROM Comment c WHERE c.userid = :userid")
	List<Comment> getCommentsByUserId(@Param("userid") Integer userid);
}
