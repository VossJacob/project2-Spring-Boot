package com.revature.project2SpringBoot.service;

import com.revature.project2SpringBoot.model.Comment;

public interface CommentService {
	
	//findOne
	//update
	//delete
	
	//Comment findOne (Comment comment);
	
	void save (Comment comment);
	
	void delete (Integer commentid);

	Comment findCommentByMovieIdAndUserId(Integer movieid, Integer id);
	

}
