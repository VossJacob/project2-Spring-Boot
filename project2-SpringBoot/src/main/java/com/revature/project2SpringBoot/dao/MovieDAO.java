package com.revature.project2SpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.project2SpringBoot.model.Movie;

public interface MovieDAO extends JpaRepository<Movie,Integer> {
	
//	@Query("delete from Movie where movieid = ?1 and favorited = 1 ")
//	void deleteFavMovie(@Param("movieid") Integer movieid);

}
