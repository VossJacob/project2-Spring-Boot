package com.revature.project2SpringBoot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.project2SpringBoot.model.Comment;
import com.revature.project2SpringBoot.model.Movie;
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
	
	@Query("SELECT m FROM Movie m WHERE m.userid = :userid and m.favorited = 1")
	List<Movie> getFavMovieByUserId(@Param("userid") Integer userid);

	
	@Query("SELECT m FROM Movie m WHERE m.userid = :userid and m.watched = 1")
	List<Movie> getWatchedMoviesByUserId(Integer userid);
	
	
	@Query("select u from User u where u.id = :id")
	User findOne(@Param("id") Integer id);
}
