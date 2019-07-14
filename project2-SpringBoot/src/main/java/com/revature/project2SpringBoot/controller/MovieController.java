package com.revature.project2SpringBoot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2SpringBoot.model.Movie;
import com.revature.project2SpringBoot.service.MovieService;

@CrossOrigin
@RestController
@RequestMapping("Movie")
public class MovieController {
	
	@Autowired
	private MovieService MovieService;
	
	@PostMapping()
	public ResponseEntity<?> addOrUpdate(@RequestBody Movie movie){
		System.out.println("MovieController->addOrUpdate");
		System.out.println(movie);
		MovieService.addOrUpdateMovie(movie);
		return new ResponseEntity<>(HttpStatus.CREATED);
			
	}
	
//	@DeleteMapping("/{movieid}/")
//	public void delete(@PathVariable("movieid") Integer movieid) {
//		System.out.println("FavController->delete");
//		favMovieService.removeFromFavMovie(movieid);
//	}
	
}
