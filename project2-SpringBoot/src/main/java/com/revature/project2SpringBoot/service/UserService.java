package com.revature.project2SpringBoot.service;

import java.util.List;

import com.revature.project2SpringBoot.model.Comment;
import com.revature.project2SpringBoot.model.User;

public interface UserService {
	
//	UserService
//	@Transactional
//	- void registerUserUser user)
//	- User login(Integer id)
//	- void update(User user)

	List<Comment> getCommentsByUserId(Integer id);
	
	void registerUser(User user);
	
	User login(User user);
	
	void update(User user);
}
