package com.revature.project2SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2SpringBoot.model.Comment;
import com.revature.project2SpringBoot.service.CommentService;

@CrossOrigin
@RestController
@RequestMapping("comment")
public class CommentController {
	
	//update
	//delete
	//findone
	
	@Autowired
	private CommentService commentService;
	
//	@GetMapping("/find")
//	public ResponseEntity<?> findCommentByMovieId(@PathVariable Integer movieid, @PathVariable Integer id){
//		System.out.println("CommentController->findComment");
//		commentService.findCommentByMovieIdAndUserId(movieid,id);
//		return new ResponseEntity<> (commentService,HttpStatus.OK);
//			
//	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createComment(@RequestBody Comment comment){
		System.out.println("CommentController->createComment");
		System.out.println("COMMENT: " + comment);
		commentService.createComment(comment);
		return new ResponseEntity<> (HttpStatus.CREATED);
		
	}
	
//	@DeleteMapping("/{commentid}")
//	public void delete(@PathVariable("commentid") Integer commentid) {
//		commentService.delete(commentid);
//	}
	
	
}
