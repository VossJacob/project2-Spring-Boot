package com.revature.project2SpringBoot.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.project2SpringBoot.model.Comment;

public interface CommentDAO extends JpaRepository<Comment,Integer>{
	
//	CommentDAO
//	-findOne
//	-save
//	-delete
	
	Comment save(Comment comment);
	
	
	@Query("select c from Comment c where c.movieid = :movieid and c.id = :id")
	Comment findCommentByMovieIdAndUserId(@Param("movieid") Integer movieid, @Param("userid") Integer id);

	@Modifying
	@Query("delete from Comment where commentid = :commentid")
	void delete(@Param("commentid") Integer commentid);
	

}
