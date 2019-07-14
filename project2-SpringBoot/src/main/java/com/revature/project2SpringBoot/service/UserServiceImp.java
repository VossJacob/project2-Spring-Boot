package com.revature.project2SpringBoot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2SpringBoot.dao.UserDAO;
import com.revature.project2SpringBoot.model.Comment;
import com.revature.project2SpringBoot.model.User;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	public void registerUser(User user) {
		userDAO.save(user);
		
	}

	public List<Comment> getCommentsByUserId(Integer userid){
		return userDAO.getCommentsByUserId(userid);
	}
	
	public User login(User user) {
		User userResult = userDAO.findByEmailAndPassword(user.getEmail(), user.getPassword());
		return userResult;
	}


	public void update(User user) {
		userDAO.save(user);
		
	}

}
