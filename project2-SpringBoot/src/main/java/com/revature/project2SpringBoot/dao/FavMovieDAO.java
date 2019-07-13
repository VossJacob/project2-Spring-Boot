package com.revature.project2SpringBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.project2SpringBoot.model.Movie;

public interface FavMovieDAO extends JpaRepository<Movie,Integer>{
	//findAll
	//saveFavorite
	void saveFavorite(Movie m);
	List<Movie> findAllFavorites();
}
