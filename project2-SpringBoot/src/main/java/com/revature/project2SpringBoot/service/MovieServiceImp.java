package com.revature.project2SpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2SpringBoot.dao.MovieDAO;
import com.revature.project2SpringBoot.model.Movie;

@Service
public class MovieServiceImp implements MovieService {

	@Autowired 
	private MovieDAO MovieDAO;
	
	
	public void addOrUpdateMovie(Movie movie) {
		MovieDAO.save(movie);
		
	}

	
//	public void removeFromFavMovie(Integer movieid) {
//		favMovieDAO.deleteFavMovie(movieid);
//		
//	}
	
	

}
