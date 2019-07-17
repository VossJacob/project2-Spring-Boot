package com.revature.project2SpringBoot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2SpringBoot.dao.UserDAO;
import com.revature.project2SpringBoot.model.Comment;
import com.revature.project2SpringBoot.model.Movie;
import com.revature.project2SpringBoot.model.User;
import com.revature.project2SpringBoot.util.JavaMailUtil;

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


	public List<Movie> getFavMoviesByUserId(Integer userid) {

		return userDAO.getFavMovieByUserId(userid);
	}


	public List<Movie> getWatchedMoviesByUserId(Integer userid) {
	
		return userDAO.getWatchedMoviesByUserId(userid);
	}

	@Transactional
	public User findById(Integer id) {
		
			User user = null;
			user = userDAO.findOne(id);
			if (user == null) {
				throw new ServiceException("User id not found");
			}
			return user;
	}
	
	public void recoverPasswordByEmail(String email) {
		String password = userDAO.findPasswordByEmail(email);//Retrieve the user's password from the database.
		System.out.println(email);
		System.out.println(password);
		try {
			JavaMailUtil.sendRecoveryEmail(email, password);//Who this email will be sent to.
		}catch(Exception e) {
			System.out.println("Email could not be sent.");
		}
	}
}


