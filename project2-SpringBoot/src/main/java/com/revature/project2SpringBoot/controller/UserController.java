package com.revature.project2SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2SpringBoot.model.Comment;
import com.revature.project2SpringBoot.model.User;
import com.revature.project2SpringBoot.service.UserService;
@CrossOrigin

@RestController
@RequestMapping("users")
public class UserController {
	
	
//	UserController
//	- login
//	- register
//	-update	
	
	@Autowired
	private UserService userService;
	
	@PostMapping()
	public ResponseEntity<?> register(@RequestBody User user){
		System.out.println("UserController->save");
		userService.registerUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user){
		System.out.println("UserController->login");
		User searchUser = userService.login(user);
		return new ResponseEntity<> (searchUser, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody void update (@PathVariable("id") Integer id, @RequestBody User user) {
		System.out.println("UserController->update" + id);
		userService.update(user);
	}

	@GetMapping("/{commentId}")
	public List<Comment> getComments(@PathVariable("commentId") Integer id){
		return userService.getCommentsByUserId(id);
	}
}
