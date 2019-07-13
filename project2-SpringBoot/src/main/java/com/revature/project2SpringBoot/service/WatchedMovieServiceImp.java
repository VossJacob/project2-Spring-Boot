package com.revature.project2SpringBoot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.project2SpringBoot.dao.WatchedMovieDAO;
import com.revature.project2SpringBoot.model.Movie;

public class WatchedMovieServiceImp implements WatchedMovieService{

	
	@Autowired
	private WatchedMovieDAO watchedMovieDAO;
	
	
	@Transactional
	public List<Movie> list() {
		
		return watchedMovieDAO.list();
	}

	
	public void saveMovie(Movie movie) {
		watchedMovieDAO.save(movie);
		
	}

	
	public void delete(Integer movieid, Integer userid) {
		
		
	}

}
