package com.revature.project2SpringBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.project2SpringBoot.model.Movie;

public interface WatchedMovieDAO {

	
	Movie save(Movie movie);
	
	@Query("select m from Movie m where m.id = :userId and watched = 1")
	List<Movie> list();
	
	@Modifying
	@Query("delete from Movie where movieid = :movieid and id = :id")
	void delete(@Param("movieid") Integer movieid, @Param("id") Integer id);
}
