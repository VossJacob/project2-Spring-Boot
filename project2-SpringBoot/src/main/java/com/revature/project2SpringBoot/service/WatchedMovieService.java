package com.revature.project2SpringBoot.service;

import java.util.List;

import com.revature.project2SpringBoot.model.Movie;

public interface WatchedMovieService {

	List<Movie> list();
	
	void saveMovie(Movie movie);
	
	void delete(Integer movieid, Integer userid);
}
