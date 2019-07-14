package com.revature.project2SpringBoot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2SpringBoot.dao.CommentDAO;
import com.revature.project2SpringBoot.model.Comment;

@Service
public class CommentServiceImp implements CommentService {
	
	@Autowired
	private CommentDAO commentDAO;
	
//	@Transactional
//	public Comment findCommentByMovieIdAndUserId(Integer movieid, Integer id) {
//		Comment commentResult = commentDAO.findCommentByMovieIdAndUserId(movieid, id);
//		
//		return commentResult;
//		
//	}
	
	
	public void createComment (Comment comment) {
		commentDAO.save(comment);
	}
	
	@Transactional
	public void deleteById(Integer commentid) {
		System.out.println("deleteById: " +commentid);
		commentDAO.deleteById(commentid);
		
	}

}
